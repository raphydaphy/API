/*
 * This file ("ISound.java") is part of the RockBottomAPI by Ellpeck.
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

package de.ellpeck.rockbottom.api.assets;

import de.ellpeck.rockbottom.api.util.ApiInternal;
import de.ellpeck.rockbottom.api.util.reg.ResourceName;

import java.util.Set;

public interface ISound extends IAsset {

    ResourceName ID = ResourceName.intern("sound");

    void play();

    void play(float pitch, float volume);

    void play(float pitch, float volume, boolean loop);

    void playAt(double x, double y, double z);

    void playAt(float pitch, float volume, double x, double y, double z);

    void playAt(float pitch, float volume, double x, double y, double z, boolean loop);

    void playAt(float pitch, float volume, double x, double y, double z, boolean loop, float rolloffFactor, float refDistance, float maxDistance);

    @ApiInternal
    boolean isIndexPlaying(int index);

    boolean isPlaying();

    void stop();

    @ApiInternal
    void stopIndex(int index);

    @ApiInternal
    Set<Integer> getPlayingSourceIds();
}
