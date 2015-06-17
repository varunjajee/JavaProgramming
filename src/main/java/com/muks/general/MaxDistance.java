package general;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MaxDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 1, 1, 7, 4};
		maxDistance(arr);
		
		Map<Integer, Integer> map = calcularteMaxDistance(arr);
		for (Integer i : map.keySet()) {
			System.out.println(i + "; Distance: " + map.get(i));
		}
	}


	public static Map<Integer, Integer> calcularteMaxDistance( int[] arr ){

		Map<Integer, Integer> distance = new HashMap<Integer, Integer>();		
		Map<Integer, Integer> firstOccurrence = new HashMap<Integer, Integer>();

		for( int i = 0; i < arr.length; i++ ){

			if( firstOccurrence.containsKey( arr[i]) ){
				int firstIndex = firstOccurrence.get( arr[i] );
				distance.put( arr[i], i - firstIndex);
			}
			else {
				// first time occurrence
				firstOccurrence.put( arr[i], i );
				distance.put( arr[i], 0);
			}
		}


		return distance;
	}


	// #########################################################################################################################
	public static void maxDistance(int[] a) {
		TreeSet<Integer> tSet = new TreeSet<Integer>();	// treeset doesn't allow duplicate collection and guarantee sorting

		for (int i = 0; i < a.length; i++) {

			if (!tSet.contains(a[i])) {
				int j = a.length - 1;

				while (j >= i) {

					if (a[i] == a[j]) {
						tSet.add(a[i]);
						System.out.println("Max(" + a[i] + ")= " + (j - i));
						break;
					}
					j--;

				} // while

			} // if

		}	// for

		String s = "";
		for (Integer i : tSet) {
			s += i + " ";
		}
		System.out.println(s);

	}	// maxDistance()


}	// end class
