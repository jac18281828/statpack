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
 * This is a Probability mass function.
 *
 * @author John Cairns <john@2ad.com>
 */
public class DiscretePMF extends DiscreteFunction {
    private DiscreteDistribution probabilityDistribution;


    /**
     * Construct a PMF from the given distribution.
     *
     * @param pd The probability distribution.
     */

    public DiscretePMF(DiscreteDistribution pd) {
	probabilityDistribution=pd;
    }

    /** 
     * A map from int to double, that computes
     * the PMF for the distribution.
     *
     * @param x The input value.
     * @param double The mapped output vaue.
     */
    public double eval(int x) {
	// Actually the pmf is provided by the distribution
	return probabilityDistribution.getProbability(x);
    }
};
