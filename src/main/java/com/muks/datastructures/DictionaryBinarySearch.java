package datastructures;

public class DictionaryBinarySearch {

	/**
	 * NOTE: (// EG: Binary search - using divide and conquer design technique/algorithm)
	 * 
	 * Dictionary is a ADT (Abstract Data Type), store elements so that they can be located quickly using keys.
	 * 
	 * Its a abstract mode of a database.
	 * 		A dictionary stores key-element pairs
	 * 		The main operation supported by a "dictionary" is searching by key
	 * 
	 * 1. Simple container methods: size(), isEmpty(), elements()
	 * 2. Query methods: findElem(k), findAllElem(K) => find all where 1 key associated with many elements..
	 * 3. Update methods: insertItem(k,e), removeElem(k), removeAllElem(k)
	 * 4. Special element: NIL, returned by an unsuccessful search
	 * 5. Supporting order (methods min, max, successor, predecessor) is not required, thus it is enough that keys are 
	 *    comparable for equality.
	 * 
	 * 6. How can dictionay ADT can be implemented.
	 * 		Arrays, linkedlist (inefficient)
	 * 		Hash table (used in javapack)
	 *  	Binary trees
	 *  	Red/Black trees
	 *  	AVL trees
	 *  	B-trees
	 *  
	 *  In Java
	 *  	javapack.adgenutils.Dictionary - Abstract class
	 *  	javapack.util.Map - interface
	 *  
	 *  
	 */
	
	
	// EG: Binary search - using divide and conquer design technique/algorithm
	/*
	 * Example for binary search: [1,3,4,5,6,7,8,10,12,14,15,19,22,23,35], using divide and conquer design 
	 * 
	 *  Algorithm BinarySearch(A, k, low, high) {
	 *  	if low > high then return NIL; // if low is high then something is wrong
	 *  	else 
	 *  		mid <- (low + high)/2;
	 *  		if k = A[mid] then return mid
	 *  		else-if k < A[mid] then 
	 *  			return BinarySearch (A, k, low, mid-1);
	 *  		else 
	 *  			return BinarySearch (A, k, mid+1, high);
	 *  
	 *  
	 *  }
	 * 
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryBinarySearch d = new DictionaryBinarySearch();
		int[] array = {1,2,3,4,8,10,12,14,17,19,22,24,27,28};
		System.out.println("+++ LEN: " + array.length);
		System.out.println(BinarySearchRecursive(array, 22, 1, array.length));

	}
	
	// NOTE: Complexity = log-n base-2 [ log n] or also written as O(log n), by default it's base 2     
	//										2	
	// This is because, for each traverse, the input tends to be half. 
												
	public static int BinarySearchRecursive (int[]arr, int k, int low, int high) {
		if (low > high) { 
			return 0; 
			
		} else {
				int mid = (low + high)/2;
				if (k == arr[mid]) {
					return mid;
				
				} else if (k < arr[mid]) {
					return BinarySearchRecursive(arr, k, low, mid-1);
					
				} else {
					return BinarySearchRecursive(arr, k, mid+1, high);
				
				}
				
		}
		
	} // end of BinarySearchRecursive()
	
	

}
