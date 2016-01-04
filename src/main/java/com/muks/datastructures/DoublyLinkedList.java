package datastructures;


public class DoublyLinkedList {
	private DLink head;
	private DLink tail;


	// Constructor class
	public DoublyLinkedList() {
		//	2 Sentinal/dummy nodes called (1) header & (2) trailer nodes, 
		//  just to mark the start and the end of the linked list
		head = null;
		tail = null;
	}

	// ################################################################################
	/*
	 * p1 starts from head and p2 starts from end
	 */
	public int findMiddleNode( DLink head ) {
		DLink p1 = head;
		DLink p2 = tail;

		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.previous;
		}
		return p1.data;
	}


	// ################################################################################
	// size()
	public int size(DLink current) {
		if (current.next == null) return 0;
		return 1 + size(current.next);
	}


	// ################################################################################
	// isEmpty()
	public boolean isEmpty() {
		return (head == null);
	}


	// ################################################################################
	// inserting at head
	public void insertFirst(int d) {
		DLink newLink = new DLink(d);

		if ( isEmpty() ) {
			tail = newLink;

		} else {
			head.previous = newLink;

		}

		newLink.next = head;
		head = newLink;

	} // end insertFirst()


	// ################################################################################
	public String toStringFromHead() {
		String str = "List (Head-->Tail): ";
		DLink current = head;

		while (current != null) {
			str += current.toString();
			current = current.next;
		}
		System.out.println(" <=> ");

		return str;
	}


	// ################################################################################
	public String toStringFromTail() {
		String str = "List (Tail-->Head): ";
		DLink current = tail;
		while (current != null) {
			str += current.toString();
			current = current.previous;
		}
		return str;
	}


	// ################################################################################
	// print the entire list
	public void printList(DLink head) {
		System.out.println("+++ print list: ");
		DLink current = head;

		while ( current.next != null ) {
			current.printLink();
			current = current.next;
		}

	} // display()



	public static void reverseDLL (DLink head) {
		DLink tmp = null;
		DLink current = head;

		/* Swapping next and prev pointer of all nodes */
		while (current != null) {
			//tmp = current.previous;
			current.previous = current.next;
			current.next = tmp;       
			
			tmp = current;
			current = current.previous;
		}

		/* Before changing head, check for the cases like empty
        list and list with only one node */
	
			head = tmp.previous;
	
		
	}



	// ################################################################################
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);


		list.printList(list.head);

		//System.out.println("+ " + list.toString());

		reverseDLL(list.head);
		list.printList(list.head);



	}

} // DoublyLinkedList()
