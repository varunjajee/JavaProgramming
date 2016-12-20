package com.muks.DSC.Random;

public class CircularLink {
	public int data;
	public CircularLink nextLink;

	
	// Constructor for circular linked list.
	public CircularLink(int data){
		this.data=data;
	}
	
	// method to print circular linked list node: 
	public void printLink() { 
		System.out.println("(" + data + ")");
	}


	
	@SuppressWarnings("unused")
	public CircularLink(int data, CircularLink link){
		this.data=data;
		this.nextLink=link;
	}

} // end interface
