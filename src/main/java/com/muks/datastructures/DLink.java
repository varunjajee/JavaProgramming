package datastructures;

public class DLink {

	public int data;
	public DLink next;
	public DLink previous;

	public DLink (int d) {
		data = d;
	}

	public String toString() {
		return "{" + data + "} ";
	}
	
	public void printLink() {
		System.out.println("{( " + data + " )}");
	}
} // end DLink
