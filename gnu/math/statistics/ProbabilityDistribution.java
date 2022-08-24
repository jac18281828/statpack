/*
 * Author: John A Cairns <john@2ad.com>
 * Date:   Feb 25, 2004
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
 * This interface gives the requirements for a statistical distribution.
 *
 * @author John Cairns <john@2ad.com>
 */
public abstract interface ProbabilityDistribution {

    /**
     * Return true if a discrete distribution.
     *
     * @return boolean True if discrete.
     */
    public boolean isDiscrete();

    /**
     * Return true if a continuous distribution.
     *
     * @return boolean True if discrete.
     */
    public boolean isContinuous();

    /**
     * Set the precision for doing calculations with this distribution.
     *
     * @param p The precision.
     */
    public void setPrecision(double p);

    /**
     * Get the precision for doing calculations with this distribution.
     *
     * @return double The precision for calculations.
     */
    public double getPrecision();

    /**
     * Used to determine convergence of a series.
     *
     * Return an object that describes the monotonicity of the
     * distribution.
     *
     * @return Monotonicity The monotonicity of the distribution.
     */
    public Monotonicity getMonotonicity();

    /**
     * Return the maximum number of iterations to expect for
     * convergence for any operation on this distribution.
     */
    public int getMaxIterations();
}
