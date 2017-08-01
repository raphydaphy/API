/*
 * This file ("TileDropsEvent.java") is part of the RockBottomAPI by Ellpeck.
 * View the source code at <https://github.com/Ellpeck/RockBottomAPI>.
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
 */

package de.ellpeck.rockbottom.api.event.impl;

import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.event.Event;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.Tile;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.List;

/**
 * This event is fired when a {@link Tile} drops a list of items
 * <br> The drops can be changed by modifying the drops list
 * <br> Cancelling it will make the tile not drop anything
 */
public class TileDropsEvent extends Event{

    public final Tile tile;
    public final List<ItemInstance> drops;
    public final IWorld world;
    public final int x;
    public final int y;
    public final TileLayer layer;
    public final Entity destroyer;

    public TileDropsEvent(Tile tile, List<ItemInstance> drops, IWorld world, int x, int y, TileLayer layer, Entity destroyer){
        this.tile = tile;
        this.drops = drops;
        this.world = world;
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.destroyer = destroyer;
    }
}