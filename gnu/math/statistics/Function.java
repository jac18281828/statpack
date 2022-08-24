/*
 * Author: John A Cairns <john@2ad.com>
 * Date:   Feb 26, 2004
 *
 * Copyright (C) 2004 John A Cairns
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package gnu.math.statistics;

/**
 * This interface gives the requirements for a function.
 *
 * @author John Cairns <john@2ad.com>
 */
public interface Function {

    /**
     * Return true if this is a continuous function.
     *
     * @return boolean True if continuous, false otherwise.
     */
    public abstract boolean isContinuous();

    /**
     * Return true if this is a discrete function.
     *
     * @return boolean True if discrete, false otherwise.
     */
    public abstract boolean isDiscrete();
};
