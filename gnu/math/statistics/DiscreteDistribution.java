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
public abstract class DiscreteDistribution implements ProbabilityDistribution {

    // set  a reasonable upper limit on the number of iterations
    static final protected int MAX_ITERATIONS=1000000;

    // the precision for calculations
    protected double precision=Double.MIN_VALUE;

    /** 
     * Given a random variable X.   Return the 
     * probability of X==x.    That is the probability
     * of value x occuring in the distribution.
     *
     * @param x The value to compute a probability for.
     *
     * @return double The probability that X==x.
     */
    public abstract double getProbability(int x);


    /**
     * Return true if this distribution is finite.
     *
     * @return boolean True if distribution is finite.
     */
    public abstract boolean isFinite();

    /**
     * return the size of the finite element set.
     *
     * @return int The number of elements in the distribution,
     *             or -1 if infinite.
     */
    public abstract int     size();

    /**
     * return true since this is a discrete distribution.
     *
     * @return boolean true.
     */
    public boolean isDiscrete() { return true; }

    /**
     * return false since this is a discrete distribution.
     *
     * @return boolean false.
     */
    public boolean isContinuous() { return false; }

    /**
     * Return the maximum number of iterations to expect for
     * convergence for any operation on this distribution.
     */
    public int getMaxIterations() { return MAX_ITERATIONS; }

    /**
     * Set the precision for doing calculations with this distribution.
     *
     * @param p The precision.
     */
    public void setPrecision(double p) { precision=p; }

    /**
     * Get the precision for doing calculations with this distribution.
     *
     * @return double The precision for calculations.
     */
    public double getPrecision() { return precision; }
}
