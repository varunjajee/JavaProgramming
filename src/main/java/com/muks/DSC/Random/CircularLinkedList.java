package com.muks.DSC.Random;

public class CircularLinkedList {

	private CircularLink head;
	private int count;

	
	public boolean isEmpty() {
		return (count == 0);
	}

	
	public static void reverseCList (CircularLink head) {

		CircularLink prev = null;
		CircularLink current = head;
		CircularLink next;

		while (current != null) {
			next = current.nextLink; // tricky: note the next node
			current.nextLink = prev; // move the node onto the result
			prev = current;
			current = next;
			
			if (current == head) {
				//met the beginning node...
				break;
			}
		}
		head.nextLink = prev;
		head = prev;

	}
	
	// ###################################################################################################
	// FIND
	// ###################################################################################################
	public CircularLink find (int key) {
		CircularLink current = head;
		while(current.data != key) {
			current = current.nextLink;
		}
		return current;
	}
	

	// ###################################################################################################
	/*
	 * A simple algorithm called Floyd's algorithm is to have two pointers, a and b, 
	 * which both start at the first element in the linked list. 
	 * Then at each step you incrementAndGet a once and b twice.
	 * Repeat until you either reach the end of the list (no loop), or a == b (the linked list contains a loop).
	 * http://umairsaeed.com/2011/06/23/finding-the-start-of-a-loop-in-a-circular-linked-list/
	 */

	public boolean isCircular (CircularLink head) {
		CircularLink p1 = head;
		CircularLink p2 = head;

		boolean isCircular = false;

		// find the meeting point
		while ( p2.nextLink != null ) {
			p1 = p1.nextLink;
			p2 = p2.nextLink.nextLink;

			if (p1 == p2) {
				isCircular = true;
				break;
			}

		}

		return isCircular;

	} // end isCircular()


	// ###################################################################################################
	// Get start point of the node.	
	public CircularLink findBegining (CircularLink head) {
		System.out.println("\n+++ Find Start Point +++");
		CircularLink p1 = head; // "Slow moviong pointer
		CircularLink p2 = head; // "Fast moving pointer

		while ( p2.nextLink != null ) {
			p1 = p1.nextLink;
			p2 = p2.nextLink.nextLink;

			if ( p1 == p2 ) {
				break;
			}

		}

		// Error check - there is no meeting point hence, not a circular linked list
		if (p2.nextLink == null) {
			return null;
		}

		/*	Move p1 to head. Keep p2 at the meeting point. Each are k steps.
		 * 	Now, from the start of the loop, where ever both the pointers meeting, must be the start of the loop,
		 * 	According to Floyd's Algorithm
		 */


		p1 = head;
		while (p1 != p2) {
			p1 = p1.nextLink;
			p2 = p2.nextLink;
		}

		System.out.println(" p1: " + p1.data + " p2: " + p2.data );
		System.out.println(" Head: " + head.data);
		return p2; // p1/p2 are now pointing to the start of the circular linked list

	} // findBegining()


	// ###################################################################################################
	// Get start point of the node.	
	// ###################################################################################################
	public CircularLink findEnd (CircularLink head) {
		System.out.println("\n+++ Find End Point +++");

		CircularLink p1 = head; // "Slow moviong pointer
		CircularLink p2 = head; // "Fast moving pointer

		while ( p2.nextLink != null ) {
			p2 = p2.nextLink;

			if (p2.nextLink != null && p1 != p2) {
				p2 = p2.nextLink;
				p1 = p1.nextLink;

			} else if (p1 == p2){
				System.out.println(" + Debug: p1: " + p1.data + " & p2: " + p2.data);
				break;

			}

		}

		System.out.println(" p1 => start point: " + p1.nextLink.data + ";\n p2 => end point: " + p2.data);
		return p2;

		/* Note: 	p1.next => start pt
		 * 			p2 is the end pt
		 */

	} // findBegining()


	// ###################################################################################################
	// append nodes to the list
	// ###################################################################################################
	public void append(int x){
		count++;
		CircularLink temp = new CircularLink(x);
		
		if(head == null) {
			head = temp;
			
		} else {
			CircularLink current = head;
			
			while(current.nextLink != head){
				current = current.nextLink;
			}
			current.nextLink = temp;
		}
		temp.nextLink=head;
	
	}

	
	// ###################################################################################################
	// Add a node to the start of the linked list
	// ###################################################################################################
	public void addBeg(int x){
		count++;
		CircularLink temp=new CircularLink(x);
		
		if(head == null) {
			temp.nextLink = temp;
		
		} else {
			CircularLink tp=head;
			while(tp.nextLink != head) {
				tp = tp.nextLink;
			}
			tp.nextLink = temp;
			temp.nextLink = head;
		}
		head = temp;
	}

	// ###################################################################################################
	// Add at a given node - 'xMethod'
	// ###################################################################################################
	public void addAt(int pos,int x) {
		
		CircularLink temp = new CircularLink(x);
		CircularLink current = head;

		for(int i=1; i < pos; i++) {
			if(current.nextLink == head) {
				break;
			}
			current = current.nextLink;
		}

		temp.nextLink = current.nextLink;
		current.nextLink =temp;
		count++;
	}

	
	// ###################################################################################################
	// Display the list
	// ###################################################################################################
	public void displayList() {
		if (head == null) {
			System.out.println("List is empty..");

		} else {
			CircularLink current = head;
			System.out.print("->");

			while(current.nextLink != head) {
				System.out.println(" "+current.data);
				current = current.nextLink;
			}

			System.out.println(current.data+" ->");
			System.out.println("+++ Current.next: Being circular " + current.nextLink.data);
		}
	}

	
	// ###################################################################################################
	// Delete a node at a given position
	// ###################################################################################################
	public void deleteAt(int position) {
		CircularLink current = head;
		CircularLink previous = head;
		
		for(int i = 0; i < position; i++){
			if(current.nextLink == head) {
				break;
			}
			previous = current;
			current = current.nextLink;
		}
		
		System.out.print(current.data);
		if(position == 0) {
			deleteFirst();
		} else {
			previous.nextLink=current.nextLink;
		}
		count--;
	}

	
	// ###################################################################################################
	// Delete the node at the start of the list	
	// ###################################################################################################
	public void deleteFirst() {
		CircularLink current = head;
		
		while(current.nextLink != head){
			current = current.nextLink;
		}
		
		current.nextLink = head.nextLink;	// delete the head node
		head = head.nextLink;
		count--;
		
	}

	// ###################################################################################################
	// Get count of nodes
	// ###################################################################################################
	public int getCount(){
		return count;
	}


	// ###################################################################################################
	public int size () {
		int count = 1;
		CircularLink current = head.nextLink;

		while ( current != head ) {
			count++;
			current = current.nextLink;
		}

		return count;

	}

	// ###################################################################################################
	// override size method
	public int size(CircularLink link) {
		if (link == null) {
			return 0;
		}

		if (link.nextLink == head) return 0;

		return 1 + size(link.nextLink);

	}

	
	// ###################################################################################################
	// main()
	// ###################################################################################################
	public static void main(String[] args) {
		CircularLinkedList ccl = new CircularLinkedList();
		ccl.addBeg(1);
		ccl.append(2);
		ccl.append(3);
		ccl.append(4);
		//ccl.addAt(2, 0);	// add node in between
		ccl.append(5);
		ccl.append(12);

		ccl.displayList();
		//ccl.deleteAt(1); //index starts from zero
		System.out.println("After deletion....");
		ccl.displayList();

		System.out.println("\n + size of the list: " + ccl.size(ccl.head));


		// is circular
		if ( ccl.isCircular(ccl.head) ) {
			System.out.println("+ YES!!! - Linked list is circular");
		} else {
			System.out.println("+ Is NOT a circular list...");
		}

		// find the starting point
		CircularLink startPoint = ccl.findBegining(ccl.head);
		System.out.println("\n Start point: " + startPoint.data);

		// find the end point, cyclic point
		CircularLink endPoint = ccl.findEnd(ccl.head);
		System.out.println("\n end point: " + endPoint.data);
		
		reverseCList(ccl.head);		// reverse a circular linked list
		ccl.displayList();

	}
}