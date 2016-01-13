package com.muks.algo;


public class QuickSort_DivideAndConquer {
	/**
	 * Quick sort - falls under the paradigm = divide and conquer
	 * 
	 * Advantages/Few highlights:
	 * --------------------------
	 * 1. Very fast
	 * 2. In-place sorting [which doesn't need any additional memory]
	 * 3. Good for large collection of numbers
	 * 
	 * Time complexity: The complexity of this algo is decided on the "pivotal" element choosen.
	 * 
	 * Best Case:
	 * ----------
	 * At each case, it takes O(log n) and runs through n levels. Hence O(n log n)
	 * This scenario will be where we divided the array at equal half
	 * 
	 * 
	 * Average Case:
	 * -------------
	 * O(n)
	 * 
	 * Worst Case Scenario: Happens when the array is already sorted. n^2 for the reason that it goes at left half and right half
	 * --------------------
	 * O(n^2)
	 * 
	 * Diff between insertion sort and quick sort:
	 * --------------------------------------------
	 * Quick sort, if the array is sorted in either ways, increasing or decreasing order, then we hit the worst of 
	 * O(n^2) since the pivot would be picked either the smallest element or the largest element
	 * 
	 * Best case happens when it is partially sorted
	 * luck when xPivot is picked at the exact half of the sorted  array.
	 * 
	 * Quick coz of in-place swaping
	 * 
	 * Insertion sort, worst case will happen when it is in descending order.. coz we pick a element and place it at a best place.
	 * Best case - If the array is partially sorted in increasing order 
	 * 
	 * 
	 * 
	 * 
	 */
	
    public static void main(String[] args) {

        //int[] a = { 1, 23, 45, 2, 8, 134, 9, 4, 2000 };
        int[] arr = {23,44,1,2009,2,88,123,7,999,1040,88};
        
        // sort call
        quickSort(arr, 0, arr.length-1);
        
        String str = null;
        for (int i : arr) {
        	str += " " + i;
        }
        
        System.out.println("+ SORTED: " + str);
        
    } // main()
    
    // Driver
    public static int[] sortedIntArray(int[] arr) {
    	quickSort(arr, 0, arr.length-1);
    	return arr;
    }
    
    
    // Quick Sort Method
    public static void quickSort(int[] arr, int start, int end) {
    	if (start < end) {
    		int mid = partition(arr, start, end);
    		quickSort(arr, start, mid);
    		quickSort(arr, mid+1, end);
    	}
    }

    // 23,44,1,2009,2,88,123,7,999,1040,88

    // Partition method
    public static int partition(int[] arr, int start, int end) {
    	int xPivotElem = arr[start];
    	int i = start - 1;
    	int j = end + 1;

    	while (true) {
    		i++;
    		while (arr[i] < xPivotElem) {
    			i++;
    		}
    		
    		
    		j--;
    		while (arr[j] > xPivotElem) {
    			j--;
    		}
    		
    		
    		if (i < j) {
				System.out.println("+ " + arr[i] + " - " + arr[j]);
				swap(arr, i, j);
    		} else {
    			return j;
    		}
    	}
    }
    
    
    // swap 2 elements
    public static void swap(int[] a, int i, int j) {
    	int tmp = a[i];
    	a[i] = a[j];
    	a[j] = tmp;
    }
}

