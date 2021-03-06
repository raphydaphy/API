/*
 * This file ("GuiComponent.java") is part of the RockBottomAPI by Ellpeck.
 * View the source code at <https://github.com/RockBottomGame/>.
 * View information on the project at <https://rockbottom.ellpeck.de/>.
 *
 * The RockBottomAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The RockBottomAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the RockBottomAPI. If not, see <http://www.gnu.org/licenses/>.
 *
 * © 2018 Ellpeck
 */

package de.ellpeck.rockbottom.api.gui.component;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.IRenderer;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.event.impl.InitGuiComponentEvent;
import de.ellpeck.rockbottom.api.gui.Gui;
import de.ellpeck.rockbottom.api.util.Colors;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;

public abstract class GuiComponent {

    public final Gui gui;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    private boolean isActive = true;

    public GuiComponent(Gui gui, int x, int y, int width, int height) {
        this.gui = gui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        RockBottomAPI.getEventHandler().fireEvent(new InitGuiComponentEvent(this.gui, this));
    }

    public static int getGuiColor() {
        return RockBottomAPI.getGame().getSettings().guiColor;
    }

    public static int getElementColor() {
        return Colors.multiplyA(getGuiColor(), 0.5F);
    }

    public static int getUnselectedElementColor() {
        return Colors.multiplyA(getElementColor(), 0.6F);
    }

    public static int getElementOutlineColor() {
        return Colors.multiply(getGuiColor(), 0.75F);
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(IGameInstance game) {

    }

    public void updateInactive(IGameInstance game) {

    }

    public void render(IGameInstance game, IAssetManager manager, IRenderer g, int x, int y) {

    }

    public void renderOverlay(IGameInstance game, IAssetManager manager, IRenderer g, int x, int y) {

    }

    public boolean isMouseOverPrioritized(IGameInstance game) {
        return this.gui == null ? this.isMouseOver(game) : this.gui.isMouseOverPrioritized(game, this);
    }

    public boolean isMouseOver(IGameInstance game) {
        if (this.isActive() && game.getInput().isMouseInWindow()) {
            int mouseX = (int) game.getRenderer().getMouseInGuiX();
            int mouseY = (int) game.getRenderer().getMouseInGuiY();

            int renderX = this.getRenderX();
            int renderY = this.getRenderY();

            return mouseX >= renderX && mouseX < renderX + this.width && mouseY >= renderY && mouseY < renderY + this.height;
        } else {
            return false;
        }
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public boolean onMouseAction(IGameInstance game, int button, float x, float y) {
        return false;
    }

    public boolean onKeyPressed(IGameInstance game, int button) {
        return false;
    }

    public boolean onCharInput(IGameInstance game, int codePoint, char[] characters) {
        return false;
    }

    @Override
    public String toString() {
        return this.getName().toString();
    }

    public abstract ResourceName getName();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRenderX() {
        if (this.gui != null) {
            return this.gui.getX() + this.getX();
        } else {
            return this.getX();
        }
    }

    public int getRenderY() {
        if (this.gui != null) {
            return this.gui.getY() + this.getY();
        } else {
            return this.getY();
        }
    }

    public int getPriority() {
        return 0;
    }

    public boolean shouldDoFingerCursor(IGameInstance game) {
        return this.isMouseOverPrioritized(game);
    }

    public boolean canCloseWithInvKey() {
        return true;
    }
}
