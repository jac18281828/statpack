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
 * This is the expectation value for a distribution.
 *
 * @author John Cairns <john@2ad.com>
 */
public class Expectation implements Function {
    // distribution
    private ProbabilityDistribution probabilityDistribution;

    /**
     * Construct an expecation from the given distribution.
     *
     * @param pd The probability distribution.
     */

    public Expectation(ProbabilityDistribution pd) {
	probabilityDistribution=pd;
    }

    /**
     * Return the expectation value of X for the distribution.
     * Return the <mean>.
     *
     * @return double The mean of the distribution.
     */
    public double expected() 
    throws DistributionNotDiscrete, DistributionNotContinuous {
	if(probabilityDistribution.isContinuous()) {
	    return expected(new ContinuousX());
	}
	return expected(new DiscreteX());
    }

    /** 
     * Return the expectation value for a function.
     *
     * @param f      The input function.
     * @param double The expectation of f.
     */
    public double expected(DiscreteFunction f) 
	throws DistributionNotDiscrete {
	// Actually the pmf is provided by the distribution
	if(probabilityDistribution.isDiscrete()) {
	    DiscreteDistribution dd=
		(DiscreteDistribution)probabilityDistribution;
	    if(dd.isFinite()) {
		double expVal=0.0;
		
		for(int i=0; i<dd.size(); i++) {
		    expVal += f.eval(i)*dd.getProbability(i);
		}
		return expVal;
	    } else {
		
		double expVal=0.0;
		double prob = dd.getProbability(0);
		double fVal = f.eval(0);
		Monotonicity m=dd.getMonotonicity();
		int i=0;
		double prec=dd.getPrecision();
		    
		// go until, monotonic decreasing and precision
		// is reached.

		while((!m.isDecreasing(i) || 
		       ((fVal*prob) > prec)) &&
		      (i < dd.getMaxIterations())) {
		    // just compute all the values until we start
		    // to converge
		    expVal += fVal*prob;
		    
		    fVal=f.eval(++i);
		    prob=dd.getProbability(i);
		}
		return expVal;
	    }
	    
	} 
	// need a discrete distribution
	throw new DistributionNotDiscrete("Expectation requires a discrete distribution.");
    }

    /** 
     * Return the expectation value for a function.
     *
     * @param f      The input function.
     * @param double The expectation of f.
     */
    public double expected(ContinuousFunction f) 
	throws DistributionNotContinuous {
	// Actually the pmf is provided by the distribution
	if(probabilityDistribution.isContinuous()) {
	    ContinuousDistribution cd=
		(ContinuousDistribution)probabilityDistribution;
	    
	    double expVal=0.0;
	    double prob = cd.getProbability(0);
	    double fVal = f.eval(0);

	    Monotonicity m=cd.getMonotonicity();
	    double x=0.0;
	    
	    double prec=cd.getPrecision();
	    double step=cd.getStep();
	    
	    // go until, monotonic decreasing and precision
	    // is reached.
	    
	    while((!m.isDecreasing(x) || 
		   ((fVal*prob) > prec)) &&
		  (x/step < cd.getMaxIterations())) {
		// just compute all the values until we start
		// to converge
		expVal += fVal*prob;
		
		x+=step;
		
		fVal=f.eval(x);
		prob=cd.getProbability(x);
	    }
	    return expVal;
	} 
	throw new DistributionNotContinuous("Expectation requires a continuous distribution.");
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
