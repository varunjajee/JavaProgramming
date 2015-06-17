package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class GenArrayStack implements Stack {

	private static final int CAPACITY = 1023;
	private static final int N = 0;
	private Object S [];
	private int t = -1;
	
	public static void main(String[] args) throws StackFullException, StackEmptyException {
		//int N = CAPACITY;
		
		
		GenArrayStack st = new GenArrayStack(4);
		st.myStack();
		System.out.println("+++ poping out t-th element: " + st.pop() );
		
		
		
		System.out.println("+++ the top most element now is : " + st.top());
		
		
		
		
		

	}
	
	
	
	
	public void myStack() {
		if (size() < 0) { new StackEmptyException ("The stack is empty!!!");	}
		
		for (int i = 0; i < size(); i++) {
			System.out.println( S[i] + " ");
		}
	}
	
	
	public GenArrayStack () throws StackFullException {
		this(CAPACITY);
		
	}
	
	
	public GenArrayStack(int cap) throws StackFullException {
		int N = cap;
		S = new Object[N];
		String str = null;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		for (int i = 1; i <= N; i++ ) {
			System.out.println("+++ Enter the element # " + i);
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int n = Integer.parseInt(str);
			push(n);
		}
		
	
	} // end ArrayStack()



	public int size () {
		return (t + 1); // index plus 1
	}
	
	
	public boolean isEmpty() {
		return (size() < 0);
	}

	public int top () throws StackEmptyException {
		if (size() < 0) 
			new StackEmptyException("The stack is empty...");
		return (Integer) S[t];
	}
		
	
	public Object pop () throws StackEmptyException {
		if (size() < 0) 
			new StackEmptyException("The stack is empty... ");
		Object elem;
		elem = S[t];
		S[t--] = null;
		return elem;
	}

	public void push(Object obj) throws StackFullException {
		if (size() > N) { new StackFullException("The stack is full... "); }
		S[++t] = obj;
	}
	

	@Override
	public void print(String text) {
		// TODO Auto-generated method stub
		
	}
	


}
