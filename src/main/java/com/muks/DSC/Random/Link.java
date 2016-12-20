package com.muks.DSC.Random;

public class Link {
	public int data1;
	public Link first;
	public Link nextLink;


	public Link (int d) {
		data1 = d;
	}

	public String toString() {
		return "{" + data1 + "} ";
	}

	public void printLink() {
		System.out.println("{( " + data1 + " )}");
	}

}
