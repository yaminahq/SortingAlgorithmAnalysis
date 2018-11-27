/**
 * sorts Comparable objects using heap sort
 * 
 * @file Heap.java
 * @author Yaminah Qureshi
 * @version 1
 * @date 02/19/2018
 */
package sort;

/**
 * implements sorting of a Comparable type using heap sort algorithm
 */
public class Heap {
	/**
	 * heap sort using Comparable
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x the input array containing jobs that need to be sorted.
	 * @param n the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
			     for (int k = n/2; k >= 1; k--)
			        sink(x, k, n);
			     while (n > 1)
			     {
			        exch(x, 1, n--);
			        sink(x, 1, n);
			     }
	}
	
	/**
	 * Top-down reheapify
	 * Exchanges a larger child node with parent node
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x the input array containing jobs that need to be sorted.
	 * @param k value of the parent node
	 * @param N the size of the input array
	 */
	private static void sink(Comparable[] x, int k, int N) {
	     while (2*k <= N)
	     {
	        int j = 2*k; // The first child node
	        if (j < N && less(x, j, j+1)) j++; // find larger child node
	        if (!less(x, k, j)) break; //determine if child node is larger than parent node
	        exch(x, k, j); //exchange larger child node with smaller parent node
	        k = j;
	     } 
	}
	
	/**
	 * Determine if Comparable Object is smaller than another Comparable Object
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x the input array containing jobs that need to be sorted.
	 * @param i index of first value to be compared
	 * @param j index of second value to be compared
	 * @return true if first element is smaller than second
	 */
	private static boolean less(Comparable[] x, int i, int j) {
        return x[i-1].compareTo(x[j-1]) < 0; //if the first object is smaller returns true
    }
	
	/**
	 * Swap two elements of an array
	 * This code was retrieved from Algorithms Fourth edition by Robert Sedgewick and Kevin Wayne
	 * 
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param i - index of first value to be swapped
	 * @param j - index of second value to be swapped
	 */
    private static void exch(Object[] x, int i, int j) {
        Object swap = x[i-1]; //save value of oe element in a temporary variable
        x[i-1] = x[j-1]; //change value of first element
        x[j-1] = swap; //change value of second element
    }
	

	
}
