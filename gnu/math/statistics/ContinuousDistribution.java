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
 * This interface gives the requirements for a statistical distribution with
 * a discrete random variable.
 *
 * @author John Cairns <john@2ad.com>
 */
public abstract class ContinuousDistribution 
    implements ProbabilityDistribution {

    /** 
     * Given a random variable X.   Return the 
     * probability of X==x.    That is the probability
     * of value x occuring in the distribution.
     *
     * @param x The value to compute a probability for.
     *
     * @return double The probability that X==x.
     */
    public abstract double getProbability(double x);


    /**
     * Used to determine convergence of a series.
     *
     * Return an object that describes the monotonicity of the
     * distribution.
     *
     * @return Monotonicity The monotonicity of the distribution.
     */
    public abstract Monotonicity getMonotonicity();

    /** 
     * Set the step size for doing calculations with this distribution
     * 
     * @param s The step size.
     */

    public abstract void setStep(double s);

    /**
     * Get the step size.
     *
     * @return double The step size.
     */
    public abstract double getStep();
}
