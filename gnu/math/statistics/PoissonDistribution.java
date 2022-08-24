/*
 * Author: John A Cairns <john@2ad.com>
 * Date:   Feb 25, 2004
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
 * This class gives a Poisson distribution about a mean value of 'mu'
 *
 * @author John Cairns <john@2ad.com>
 */
public class PoissonDistribution extends DiscreteDistribution {

    // the mean (expectation) of the distribution
    private double mu;

    public PoissonDistribution(double u) {
	mu=u;
    }


    /** 
     * Given a random variable X.   Return the 
     * probability of X==x.    That is the probability
     * of value x occuring in a poisson distribution.
     *
     * @param x The value to compute a probability for.
     *
     * @return double The probability that X==x.
     */
    public double getProbability(int x) {
	double xVal=(double)x; // promote x to a double.
	
	// poisson distribution
	return Statistics.clamp((Math.exp(-mu) * Math.pow(mu, xVal) / (double)Statistics.fact(x)), 0.0, 1.0);
    }

    /**
     * Used to determine convergence of a series.
     *
     * Return an object that describes the monotonicity of the
     * distribution.
     *
     * @return Monotonicity The monotonicity of the distribution.
     */
    public Monotonicity getMonotonicity() {
	return new PoissonMonotonicity(mu);
    }

    /**
     * Return true if this distribution is finite.
     *
     * @return boolean True if distribution is finite.
     */
    public boolean isFinite() { return false; }

    /**
     * return the size of the finite element set.
     *
     * @return int The number of elements in the distribution,
     *             or -1 if infinite.
     */
    public int     size() { return -1; }

};
