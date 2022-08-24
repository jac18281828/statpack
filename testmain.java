/*
 * Author: John A Cairns <john@2ad.com>
 * Date:   Feb 27, 2004
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

import gnu.math.statistics.*;


/**
 * This application provides simple tests for the statpack.
 *
 * @author John Cairns <john@2ad.com>
 */
public class testmain {
    
    public static void main( String[] args ) {

	try {
	
	    System.out.println("BEGIN TEST");
	
	    System.out.println("CountedSet:");

	    CountedSet cs = new CountedSet(4);

	    for(int i=0; i<1001; i++) {
		for(int j=0; j<i; j++) {
		    cs.add(i);
		}
	    }
		    


	    for(int i=0; i<1000; i+=50) {
		System.out.println("Number of "+i+"s: "+cs.getCount(i));
	    }

	    System.out.println("Num Bins: "+cs.getNumBins());
	    for(int b=0; b<cs.getNumBins(); b++) {
		System.out.println("bin "+b+": "+cs.getBinCount(b));
	    }

	    System.out.println("Mean count: "+cs.getMeanBinCount());

	    System.out.println("PoissonDistribution:");
	    PoissonDistribution pd = 
		new PoissonDistribution(cs.getMeanBinCount());

	    DiscretePMF pmf = new DiscretePMF(pd);
	
	    for(int i=0; i<20; i+=2) {
		System.out.println("Probability of "+i+" is "+pmf.eval(i));
	    }

	    CDF cdf = new CDF(pd);

	    for(int i=0; i<20; i+=2) {
		System.out.println("CDF of "+i+" is "+cdf.eval(i));
	    }

	    Expectation exp = new Expectation(pd);
	    System.out.println("Expectation of pd: "+exp.expected(new DiscreteX()));
	    Variance    var = new Variance(pd);
	    System.out.println("Variance of pd: "+var.variance());


	    System.out.println("BinomialDistribution:");
	    BinomialDistribution bd = 
		new BinomialDistribution(.2, 20);

	    pmf = new DiscretePMF(bd);
	
	    for(int i=0; i<20; i+=2) {
		System.out.println("Probability of "+i+" is "+pmf.eval(i));
	    }

	    cdf = new CDF(bd);

	    for(int i=0; i<20; i+=2) {
		System.out.println("CDF of "+i+" is "+cdf.eval(i));
	    }

	    exp = new Expectation(bd);
	    System.out.println("Expectation of bd: "+exp.expected(new DiscreteX()));
	    var = new Variance(bd);
	    System.out.println("Variance of bd: "+var.variance());
	} catch (DistributionNotDiscrete   dnd) {
	    System.err.println("Error: wrong distribution.");
	}
    }
};
