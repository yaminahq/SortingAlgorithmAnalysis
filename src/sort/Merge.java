/**
 * sorts Comparable objects using merge sort
 * 
 * @file Merge.java
 * @author Yaminah Qureshi
 * @version 1
 * @date 02/19/2018
 */
package sort;

/**
 * implements sorting of a Comparable type using merge sort algorithm
 */
public class Merge {
	
	 private static Comparable[] aux;      // auxiliary array for merges
     
	/**
	 * merge sort using Comparable
	 * Sets up the merge sort
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x the input array containing jobs that need to be sorted.
	 * @param n the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
        aux = new Comparable[n];    // Allocate space just once.
        sort(x, 0, n - 1);
	}
	
	/**
	 * sorts an array through the specified indices
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param a the input array containing jobs that need to be sorted.
	 * @param lo the index at which to start sorting
	 * @param lo the index at which to halt sorting
	 */
    private static void sort(Comparable[] a, int lo, int hi)
    {  // Sort a[lo..hi].
       if (hi <= lo) return;
       int mid = lo + (hi - lo)/2;
       sort(a, lo, mid);       // Sort left half.
       sort(a, mid+1, hi);     // Sort right half.
       merge(a, lo, mid, hi);  // Merge results (code on page 271).
    }
    
	/**
	 * merges two sorted halves of an array retaining the sorted order
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param a the input array containing jobs that need to be sorted.
	 * @param lo the index at which to start merging
	 * @param mid the index value of the array at which the two sorted portions of array are partitioned
	 * @param hi the index at which to halt merging
	 */
	  public static void merge(Comparable[] a, int lo, int mid, int hi)
	  {  // Merge a[lo..mid] with a[mid+1..hi].
	     int i = lo, j = mid+1;
	     for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi].
	        aux[k] = a[k];
	     for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
	        if      (i > mid)              a[k] = aux[j++];
	        else if (j > hi )              a[k] = aux[i++];
	        else if (less(aux[j], aux[i])) a[k] = aux[j++];
	        else                           a[k] = aux[i++];
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
		
}
