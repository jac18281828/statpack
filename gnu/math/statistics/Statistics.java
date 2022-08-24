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
 * This class gives a Binomial distribution with n values of probability p.
 *
 * @author John Cairns <john@2ad.com>
 */
public class Statistics {
    /**
     * Return the factorial of n.
     *
     * @param n The number to compute.
     *
     * @return int The factorial of n.
     */
    public static int fact(int n) {
	int factorial=1;

	for(int j=2; j<=n; j++) {
	    factorial *= j;
	}
	return factorial;
    }

    /**
     * Return the combinations of k elements chosen from n
     *
     * @param n The number of elements.
     * @param k the number to chose.
     *
     * @return int The number of combinations.
     */
    public static int comb(int n, int k) {
	return perm(n, k)/fact(k);
    }


    /**
     * Return the permutations of k elements chosen from n
     *
     * @param n The number of elements.
     * @param k the number to chose.
     *
     * @return int The number of permutations.
     */
    public static int perm(int n, int k) {
	return fact(n)/fact(n-k);
    }

    /**
     * Clamp the value x between r and p.
     *
     * @param x The value to clamp.
     * @param r The lower value of the clamp.
     * @param p The upper value of the clamp.
     *
     * @return double A value such that, value=x, value=r if x<r or
     *         value=p if x>p.
     */
    public static double clamp(double x, double r, double p) {
	if(x<r) {
	    return r;
	} else if(x>p) {
	    return p;
	}
	return x;
    }

};
