package AlgosOnString;

public class StringPermutations {

	public static void main(String[] args) { 

		stringPermutations("ABCD");

	}


	// Get permutations:
	public static void stringPermutations(String s){
		permute("",s);
	}

	private static void permute(String prefix, String s){
		System.out.println(prefix + "---"+ s);
		int n = s.length();

		if (n==0) {
			System.out.println("-------------------------------"+prefix);

		}  else {
			for(int i=0; i < n; i++) {
				permute( prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1,n) );
			}
		}

	}

}