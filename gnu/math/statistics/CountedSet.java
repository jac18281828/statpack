/*
 * Author: John A Cairns <john@2ad.com>
 * Date:   Feb 28, 2004
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
 * A counted set maps numeric values to
 * counts, as in a histogram or poisson distribution.
 *
 * @author John Cairns <john@2ad.com>
 */
public class CountedSet {

    private HashMap		countedObjects;

    // total number of objects 
    private int		ntot=0;

    // width of bins
    private int		nBins;

    /**
     * Construct a CountedSet.
     *
     * @param numBins The number of bins.
     */

    public CountedSet(int numBins) {
	countedObjects = new HashMap();
	nBins=numBins;
    }

    /**
     * Construct a CountedSet.
     *
     * @param numBins The number of bins.
     * @param cap The initial capacity of the set (number of counts).
     */

    public CountedSet(int numBins, int cap) {
	countedObjects = new HashMap(cap);
	nBins=numBins;
    }

    /**
     * Construct a CountedSet from a CountedSet.
     *
     * @param cs The counted set to copy.
     */
    public CountedSet(CountedSet cs) {
	countedObjects = new HashMap(cs.countedObjects);
	ntot=cs.ntot;
	nBins=cs.nBins;
    }

    /**
     * Insert an element for counting in the set.
     *
     * @param l The value to be counted.
     */
    public void add(int l) {
	Integer lVal = new Integer(l);

	ntot++;

	if(countedObjects.containsKey(lVal)) {
	    // update the count
	    Integer count = (Integer)countedObjects.get(lVal);
	    int n = count.intValue();
	    // add one
	    n += 1;
	    // put it back
	    countedObjects.put(lVal, new Integer(n));
	} else {
	    Integer count = new Integer(1); // initial count at 1.
	    countedObjects.put(lVal, count);
	}
    }

    /**
     * remove an element that was counted.
     *
     * @param l The element to remove.
     */
    public void remove(int l) {
	Integer lVal=(Integer)countedObjects.remove(new Integer(l));
	if(lVal!=null) {
	    ntot -= lVal.intValue();
	}
    }


    /**
     * Return the number of elements counted in this object.
     *
     * @return int the number of objects counted.
     */
    public int size() { return countedObjects.size(); }


    /**
     * Return the number of bins.
     */
    public int getNumBins() { return nBins; }

    /**
     * Return the total counts.
     *
     */
    public int nTotal() {
	return ntot;
    }


    /**
     * Clear the object.
     */
    public void clear() {
	countedObjects.clear();
	ntot=0;
    }

    /**
     * The mean value.
     *
     * @return int The mean value.
     */
    public int getMeanValue() {
	int sum=0;
	for(int i=0; i<getNumBins(); i++) {
	    sum += getBinMeanValue(i)*getBinCount(i);
	}
	sum /= nTotal();
	
	return sum;
    }

    /**
     * Return the count for a particular value.
     *
     * @param l The value to check the count.
     *
     * @return int the count.
     */
    public int getCount(int l) {
	Integer lVal = new Integer(l);
	if(countedObjects.containsKey(lVal)) {
	    return ((Integer)countedObjects.get(lVal)).intValue();
	}
	return 0;
    }



    /**
     * Return the mean count per bin.
     *
     * @return int The mean count per bin.
     */
    public int getMeanBinCount() {
	int sum=0;
	for(int b=0; b<getNumBins(); b++) {
	    sum += getBinCount(b);
	}
	return sum/getNumBins();
    }

    /**
     * Get the count in the bth bin.
     *
     * @param b The bin to return the count for.
     *
     * @return int The count in the bth bin.
     */
    public int getBinCount(int b) {
	Set valueSet = countedObjects.entrySet();
	Object value[] = valueSet.toArray();

	int binSize = (size()+1)/getNumBins();
	int sum=0;

	int binStart=b*binSize;
	int binEnd=(b+1)*binSize-1;
	//System.out.println("BinStart: "+binStart);
	//System.out.println("BinEnd:   "+binEnd);

	for(int i=binStart;i<binEnd; i++) {
	    sum+=((Integer)((Map.Entry)value[i]).getValue()).intValue();
	}
	return sum;
    }

    /**
     * Get the average value in the bth bin.
     *
     * @param b The bin to return the count for.
     *
     * @return int The average value in the bth bin.
     */
    public int getBinMeanValue(int b) {
	Set valueSet = countedObjects.entrySet();
	Object value[] = valueSet.toArray();

	int binSize = size()/getNumBins();
	int sum=0;
	int nTot=0;

	int binStart=b*binSize;
	int binEnd=(b+1)*binSize-1;
	//System.out.println("BinStart: "+binStart);
	//System.out.println("BinEnd:   "+binEnd);


	for(int i=binStart;i<binEnd; i++) {
	    int count=((Integer)((Map.Entry)value[i]).getValue()).intValue();
	    sum+=count*((Integer)((Map.Entry)value[i]).getKey()).intValue();
	    nTot+=count;
	}

	if(nTot>0) {
	    return sum/nTot;
	}
	return 0; // value is undefined
    }

    /**
     * Get the minimum value.
     * 
     * @return int The minimum value.
     */
    public int getMinValue() {

	TreeSet keySet = new TreeSet(countedObjects.keySet());

	return ((Integer)keySet.first()).intValue();
    }

    /**
     * Get the maximum value.
     * 
     * @return int The maximum value.
     */
    public int getMaxValue() {

	TreeSet keySet = new TreeSet(countedObjects.keySet());

	return ((Integer)keySet.last()).intValue();
    }
};
