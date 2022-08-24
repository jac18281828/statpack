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

import java.util.*;

/**
 * This is a Cumulative Distribution Function.
 *
 * @author John Cairns <john@2ad.com>
 */
public class CDF extends ContinuousFunction {
    // the distribution
    private DiscreteDistribution discreteDistribution;

    // the steps in the cdf
    private Vector		cdfSteps=null;


    /**
     * Construct a CDF from the given distribution.
     *
     * @param dd The discrete probability distribution.
     */

    public CDF(DiscreteDistribution dd) {
	discreteDistribution=dd;

	// if dd is finite, store the distribution
	if(dd.isFinite()) {
	    cdfSteps = new Vector((int)dd.size());
	    for(int i=0; i<dd.size(); i++) {
		Object ovec=new Double(addCDF(i));
		cdfSteps.add(ovec);
	    }	    
	}
    }

    /** 
     * A map from double to double, that computes
     * the CDF for the distribution.
     *
     * @param x The input value.
     * @param double The mapped output vaue.
     */
    public double eval(double x) {
	Double X = new Double(x);
	if(discreteDistribution.isFinite()) {
	    return ((Double)cdfSteps.get(X.intValue())).doubleValue();
	} else {
	    return addCDF(X.intValue());
	}
    }

    /*
     * Add the probability steps from 0 to y.
     *
     * @param y The value to sum until.
     *
     * @param double The sum of probabilities from 0 to y.
     */
    protected double addCDF(int y) {
	double cdf=0.0;
	for(int j=0; j<=y; j++) {
	    cdf += discreteDistribution.getProbability(j);
	};
	return Statistics.clamp(cdf, 0.0, 1.0);
    };
};
