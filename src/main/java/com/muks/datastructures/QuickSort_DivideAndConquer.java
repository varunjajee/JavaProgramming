package datastructures;


public class QuickSort_DivideAndConquer {

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
    
    
    // Quick Sort Method
    public static void quickSort(int[] a, int p, int r) {
    	if (p < r) {
    		int mid = partition(a, p, r);
    		quickSort(a, p, mid);
    		quickSort(a, mid+1, r);
    	}
    }
    
    
    public static int[] sortedIntArray(int[] arr) {
    	quickSort(arr, 0, arr.length-1);
    	return arr;
    }
    
    // Partition method
    public static int partition(int[] a, int p, int r) {
    	int xPivotElem = a[p];
    	int i = p-1;
    	int j = r+1;
    	
    	while (true) {
    		i++;
    		while (a[i] < xPivotElem) {
    			i++;
    		}
    		
    		
    		j--;
    		while (a[j] > xPivotElem) {
    			j--;
    		}
    		
    		
    		if (i < j) {
    			swap(a, i, j);
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