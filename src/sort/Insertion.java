/**
 * sorts Comparable objects using various implementation of insertion sort
 * 
 * @file Insertion.java
 * @author Yaminah Qureshi
 * @version 1
 * @date 02/19/2018
 */
package sort;

/**
 * implements sorting of objects using insertion sort algorithms
*/
public class Insertion {
	/**
	 * regular insertion sort
	 * Implements insertion sort without the use of compareTo method of Comparable
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x - the input array containing jobs that need to be sorted.
	 */
	public static void sortInsert (Job[] x) {
		  // Sort a[] into increasing order.
	        int N = x.length;
	        for (int i = 1; i < N; i++)
	        {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
	           for (int j = i; j > 0 && normalLessThan(x[j], x[j-1]); j--) {
	        	   Job t = x[j]; x[j] = x[j-1]; x[j-1] = t;
	           }
	        } 
	}
	
	/**
	 * compares order of two job's
	 * Determines whether a job is smaller than another job using job execution time and ID
	 * 
	 * @param job1 the job for which the comparison occurs
	 * @param job2 the job to which the first job is compared to
	 * @return true if the first job is smaller than the second
	 */
	public static boolean normalLessThan(Job job1, Job job2) {
		 if (job1.getExecutionTime() < job2.getExecutionTime())
			 return true; //job is less than second job based on execution time
		 //execution time of jobs are the same
		 if (job1.getExecutionTime() == job2.getExecutionTime()) {
			 String job1ID =  job1.getJobID();
			 String job2ID =  job2.getJobID();
			 int n = job1ID.length();
			 // compare job ID's lexographically
			 for (int i = 0; i < n; i++ ) {
				 if (job1ID.charAt(i) < job2ID.charAt(i))
					 return true; //job is less than second job based on job ID
				 if (i+1 == job2ID.length() || (job1ID.charAt(i) > job2ID.charAt(i)) ) 
					 return false; ////job is greater than second job based on job ID
			 }
		 }
		return false;
	}
	
	/**
	 * insertion sort using Comparable
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		  // Sort a[] into increasing order.
        for (int i = 1; i < n; i++)
        {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
           for (int j = i; j > 0 && less(x[j], x[j-1]); j--)
              exch(x, j, j-1);
        } 
	}
	
	/**
	 * optimized insertion sort
	 * Uses binary search to determine where to insert element into sorted portion of array
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
		  // Sort a[] into increasing order.
		int index; Comparable key;
        for (int i = 1; i < n; i++){  
        		// Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
        		key = x[i];
        		index = binarySearch (x, 0, i, key); //use binary search to find correct index of key based on order
        		// shift all elements to the right of the key's correct location, right one
        		for (int j = index; i-1 >= j ; j++) {
              x[j+1] = x[j];}
           x[index] = key; // insert key in its correct location
        } 
	}
	
	/**
	 * Determine if Comparable Object is smaller than another Comparable Object
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param v the value of the first object to be compared
	 * @param w the value of the second object to be compared
	 * @return true if first element is smaller than second
	 */
	private static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
		}
	
	/**
	 * Swap two elements of an array
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x the input array containing jobs that need to be sorted.
	 * @param i index of first value to be swapped
	 * @param j index of second value to be swapped
	 */
	private static void exch(Comparable[] a, int i, int j){ 
		Comparable t = a[i]; a[i] = a[j]; a[j] = t; 
		}
	
	/**
	 * Determines correct index of a key in a sorted array using binary search
	 * 
	 * @param x the sorted input array in which the key must be inserted
	 * @param lo the value at which the search for the key's correct location begins
	 * @param hi the value at which the search for the key's correct location halts
	 * @param key the element, for which the index of its sorted position in the list must be determined
	 * @return the index at which the key must be placed in order to be in its sorted position
	 */
	public static int binarySearch (Comparable[] x, int lo, int hi, Comparable key)
	{
	    if (lo == hi) //the index where they key belongs based on order
	        return lo;
	    int mid = lo + ((hi - lo) / 2);
	    if (key.compareTo(x[mid]) > 0) //key must belong it greater half of the array because its greater than the mid value
	        return binarySearch (x, mid + 1, hi, key);
	    else if (key.compareTo(x[mid]) < 0) //key must belong it smaller half of the array because its smaller than the mid value
	        return binarySearch (x, lo, mid, key);
	    return mid; //key is equal to the mid value of the array
	}
}
