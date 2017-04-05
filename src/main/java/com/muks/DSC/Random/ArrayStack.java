package com.muks.DSC.Random;

import java.io.*;

public class ArrayStack implements Stack {
	/*
	 * Stacks work on LIFO principle
	 * 	If remove a elements is called, then the last elements inserted will be returned.
	 * 
	 */
	
	public static final int CAPACITY = 1024;	// this is the default capactiy for the Stack
	 
	private int N;			// or the non default capacity of the Stack is - "N"
	private Object S [];	// S - is the array of the Stack objects
	private int t = -1;		// is the top element of the Stack, initially its if empty, hence t = "-1"
	
	
	//public static void lib(String[] args) throws StackFullException, StackEmptyException {
	public static void main(String[] args) throws StackEmptyException, StackFullException {
		ArrayStack q = new ArrayStack(4);
		
		q.myStack();
		
		// emptying the Stack
		//q.pEmptyMyStack();
		//q.pEmptyMyStack();
		
//		while (!q.isEmpty()){
//			System.out.print(q.pop() + "  ");
//		}
		
	}	
	
	// ###################################################################################################
	// print the entire Stack
	
	public void pEmptyMyStack () throws StackEmptyException {
		if (size() < 1) { new StackEmptyException("The stack is empty"); }
		
		System.out.print("Retrieved elements from the stack : ");
		while (! isEmpty() ) {
			System.out.println(pop() + " ");
		}
		
	}
	
	// ###################################################################################################
	// this is to initialize the Stack with default capacity
	public ArrayStack() throws StackFullException {
		this(CAPACITY);
	}

	// ###################################################################################################
	// this is to initilize the Stack with given capacity "int cap"
	public ArrayStack(int cap) throws StackFullException {
		N = cap;
		S = new Object[N];
		String str = null;
		
		System.out.println("+++ Key in the input elements: ??? ");
		
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(ir);		
		
		for(int i = 1; i <= N; i++){
			System.out.print("Enter element # " + i + ": ");
			
			try {
				str = bf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int n = Integer.parseInt(str);
			push(n);
		}		
		
		
	}
	
	
	// ###################################################################################################
	// size() getting the size of the Stack
	public int size() {
		return (t+1); // index + 1
	}
	
	
	// ###################################################################################################
	public boolean isEmpty() {
		return (t < 0);
	}
	
	
	// ###################################################################################################
	// push() inserts an element
	public void push(Object obj) throws StackFullException {
		if (size() == N) { throw new StackFullException("Stack overflow."); }
		S[++t] = obj; // this is as good as, incrementAndGet "t" and then assign "obj"
		
	}
	
	
	// ###################################################################################################
	// top() tell/returns the top most element
	public Object top() throws StackEmptyException {
		if (isEmpty()) { throw new StackEmptyException ("stack is empty."); }
		return S[t];
		
	}
	
	
	// ###################################################################################################
	// pop() removes the top most element from Stack
	public Object pop() throws StackEmptyException {
		Object elem;
		
		if (isEmpty()) { throw new StackEmptyException("Stack is empty."); } 
		elem = S[t];
		S[t--] = null; // dereference S[top] and decrement top : this is as good as set "null" first and then reduce
		return elem;

	}


	// ###################################################################################################
	@Override
	public void print(String text) {
		// TODO Auto-generated method stub
		
	}
	
	// ###################################################################################################
	// Method to print the entire Stack
	
	public void myStack() {
		if (size() < 0) { new StackEmptyException("The stack is empty!!!");	}
		
		for (int i = 0; i < size(); i++) {
			System.out.println( S[i] + " ");
		}
	}
	
	
} // end class ArrayStack

// #######################################################################################################