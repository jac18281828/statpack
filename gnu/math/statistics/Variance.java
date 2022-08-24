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
 * This is the Variance for a distribution.
 *
 * @author John Cairns <john@2ad.com>
 */
public class Variance implements Function {
    // distribution
    private ProbabilityDistribution probabilityDistribution;

    double variance=0.0;

    /**
     * Construct a Variance from the given distribution.
     *
     * @param pd The probability distribution.
     */

    public Variance(ProbabilityDistribution pd) {
	probabilityDistribution=pd;

	Expectation expectation = new Expectation(pd);

	try {

	    if(pd.isContinuous()) {
		variance=
		    expectation.expected(new ContinuousX2())
		    -Math.pow(expectation.expected(new ContinuousX()), 2.0);
	    } else {
		variance=
		    expectation.expected(new DiscreteX2())
		    -Math.pow(expectation.expected(new DiscreteX()), 2.0);
	    }
	} catch(DistributionNotContinuous dnc) { 
	} catch(DistributionNotDiscrete   dnc) {
	}
	
    }

    /** 
     * Return the variance.
     *
     * @return double The variance of the distribution.
     */
    public double variance() {
	return variance;
    }

    /**
     * Return the standard deviation.
     *
     * @return double The standard deviation of the distribution.
     */
    public double standardDeviation() {
	return Math.sqrt(variance);
    }

    /**
     * Return true if this is a continuous function.
     *
     * @return boolean True if continuous, false otherwise.
     */
    public boolean isContinuous() { return probabilityDistribution.isContinuous(); }

    /**
     * Return true if this is a discrete function.
     *
     * @return boolean True if discrete, false otherwise.
     */
    public boolean isDiscrete() { return probabilityDistribution.isDiscrete(); }
};
