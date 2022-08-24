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
 * For a given value of x, indicate if the function is
 * monotonic increasing or monotonic decreasing as 
 * x is larger and larger.    
 *
 * Note: many functions start out with no monotonicity, 
 * and then become monotonic at some point in the domain...
 * then this function should return "NOT_MONOTONE" unless
 * x is past the point where the function becomes monotonic.
 *
 * @author John Cairns <john@2ad.com>
 */
public class PoissonMonotonicity implements Monotonicity {

    private double mu;

    public PoissonMonotonicity(double u) {
	mu=u;
    }
    
    
    /**
     * Return true if the function is monotone past x and false otherwise.
     *
     * @param  x The starting value of x.
     * @return boolean True if function is monotone.
     */
    public boolean isMonotone(double x) {
	return x>mu;
    }
    
    /**
     * return true if the function is decreasing past x and false otherwise.
     *
     * @param  x The starting value of x.
     * @return boolean True if function is decreasing.
     */
    public boolean isDecreasing(double x) {
	return x>mu;
    }

    /**
     * return true if the function is increasing past x and false otherwise.
     *
     * @param  x The starting value of x.
     * @return boolean True if function is increasing.
     */
    public boolean isIncreasing(double x) {

	// monotone on the range 0-mu but false in general.
	return false;
    }
};
