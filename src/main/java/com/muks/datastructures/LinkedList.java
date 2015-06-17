package datastructures;

import java.text.BreakIterator;

public class LinkedList {

	/*
	 * Linked list (may be a doubly linked list) are always better to support node based operations 
	 * when compared to array or list whose operational cost is O(n) whereas, linked list can do it at a constant time of O(1)
	 */

	private static Link first; // To store the first node
	private static Link first2;	// To establish a Y shaped linked list

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		//	1 = 5 -->4-->2-->9
		//	2 =7-->3-->1-->1
		//		list.insert(9);
		//		list.insert(2);
		//		list.insert(4);
		//		list.insert(5);
		//		
		//		list.insert2(1);
		//		list.insert2(1);
		//		list.insert2(3);
		//		list.insert2(7);

		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		list.printList();
		list.recursiveReverse(list.first);
		
		list.printList();
		System.exit(0);

		list.insert2(10);
		list.insert2(9);
		list.insert2(8);

		list.printList();
		list.printList2();



		Link resHead = list.addLists(list.first, list.first2);	// adding 2 link lists

		// return head of the resultant list
		list.printListWithHead(resHead);
		System.exit(0);


		//		list.insert(30);
		//		list.insert(15);
		//		list.insert(9);
		//		list.insert(6);
		//		list.insert(3);
		//
		//		list.insert2(10);
		//		//		list.insert2(15);
		//
		//		list.printList();
		//		list.printList2();
		//
		//		genIntersectedList(first, first2);	// To get a intersected linked list
		//		int intersPoint = findIntersectionPoint(first, first2);
		//		System.out.println("\n+ Intersection Is Found @ : " + intersPoint); 
		//
		//		System.exit(0);


		//		list.insert(1, 2.02);
		//		list.insert(2, 1.01);
		//		list.insert(2, 2.02);
		//		list.insert(5, 3.03);
		//		list.insert(5, 4.04);
		//		list.insert(7, 5.05);

		list.insert(11);
		list.insert(10);
		list.insert(9);
		list.insert(8);
		list.insert(7);
		list.insert(6);
		list.insert(5);
		list.insert(1);
		list.insert(3);
		list.insert(2);
		list.insert(4);

		list.getCyclicLinkedList(list.first);
		Link f = list.findEnd(list.first);
		System.out.println(" f: " + f.data1);
		System.exit(0);

		//		Link mid = list.findMiddle(list.first);
		//		mid.printLink();

		//		segregateEvenAndOdd(list.first);
		//		list.printList();

		System.out.println("+ Original List: ");
		list.printList();

		segregateOddAndEven(first);
		System.out.println("+++ Segregated: " );

		list.printList();
		System.exit(0);

		//		System.out.println("+ Original List: ");
		//		list.printList();
		//		reverseInplace(list.first);
		//		
		segregateList(list.first);
		System.exit(0);

		System.out.println("Lenght of the Linked-List: " + size(list.first));
		list.printList();

		list.reverseList(list.first);
		list.printList();

		deleteDupsOnUnsorted(list.first);
		System.out.println("++ Deleing duplicates...");
		list.printList();

		//		list.addNode(5, 45);
		//		list.printList();

		//		list.insertAtTail(1111);
		//		list.printList();

		//		System.out.println("\n+++ Deleting tail.. ");
		//		Link oldTail = list.deleteTail();
		//		System.out.println("+++ Deleted: ");
		//		oldTail.printLink();
		//
		//		list.printList();

		//		System.out.println("+++ Delete Node: 3");
		//		Link deletedNode = list.deleteNode(first, 1);
		//		
		//		list.printList();
		//		

		//		Link listTail = list.findTail(first);
		//		System.out.println("+++ Tail: " );
		//		listTail.printLink();
		//		
		//		Link deleted =  list.deleteFront();
		//		System.out.println("\n+++ Deleted from front: " );
		//		deleted.printLink();
		//		
		//		System.out.println("\n+++ new linked-list is: ");
		//		list.printList();
		//		
		////		list.deleteNode(first, 4);
		////		



	} // end main()


	Link reverse2(Link start){
	    if(start==null)
	        return null;
	    if((start).nextLink==null)
	        return start;
	    Link next=(start).nextLink;
	    (start).nextLink = null;
	    Link head = reverse2(next);
	    next.nextLink = (start);
	    return head;
	}

	public void recursiveReverse (Link node) {

		/* empty list */
		if (node == null)
			return;   


		if (node.nextLink == null) {
			first = node;
			System.out.println(" Last: " + first.data1);
			return;

		}

		Link rest = node.nextLink;

		if (rest == null) {
			return;
		}

		System.out.println(" rest: " + rest.data1);
		recursiveReverse(rest);
		node.nextLink.nextLink = node;
		node.nextLink = null;
		node = rest;

		first = node;

	}


	public static Link ReverseLinkedListRec(Link node) {
		//base case
		//last node of the list
		//head passed as null
		if (node == null || node.nextLink == null) return null;

		//Next node sequentially moving forward.....
		Link nextNode = node.nextLink;

		//Just remove all the link before the call
		node.nextLink = null;

		//Whenever the callstack starts shrinking only the code from below will be executed. 
		//Stack local variables take care of the rest.
		Link retNode = ReverseLinkedListRec(nextNode);	//stack stores the reference of nextNode sequentially anode passes it back. Reverse traversal starts from here.  

		nextNode.nextLink = node;	//Link nextNode to the current node where you're coming from

		return retNode == null ? nextNode : retNode;	//This makes sure that properly head is passed back instead of a null.
	}



	public Link addLists (Link link1, Link link2) {
		Link res = null;
		Link prev = null;
		Link temp = null;
		int carry = 0, sum;

		while (link1 != null || link2 != null) {
			//sum = carry + ( (l1.data1 != null) ? l1.data1: 0) + ( (l2.data1 != null) ? l2.data1: 0);
			sum = carry + link1.data1 + link2.data1;

			carry = (sum >= 10) ? 1 : 0;			// update carry for next calulation
			sum = sum % 10;						// update sum if it is greater than 10

			temp = new Link(sum);				// Create a new node with sum as data

			// if this is the first node then set it as head of the resultant list
			if(res == null) {
				res = temp;

			} else {	// If this is not the first node then connect it to the res.
				prev.nextLink = temp;

			}

			// Set prev for next insertion
			prev  = temp;

			// Move first and second pointers to next nodes
			if (link1 != null) { 
				link1 = link1.nextLink;
			}

			if (link2 != null) {
				link2 = link2.nextLink;
			}
		}

		if (carry > 0) {
			temp.nextLink = new Link(carry);
		}

		return res;

	}	// addLists()


	// ###################################################################################################
	// Implementing LinkedList constructor
	public LinkedList() {
		first = null;
	}

	// ###################################################################################################
	// returns true if the first elements itself is null
	public static boolean isEmpty() {
		return first == null;

	}


	@SuppressWarnings("null")
	public void getCyclicLinkedList (Link head) { 
		Link current = head;
		Link loopNode = null;
		Link linkEnd = findTail(head);

		int count = 3;
		while (current.nextLink != null) {
			count--;
			if (count == 0) {
				loopNode = current;
				break;
			}

			//System.out.println("+++ Tail: " + current.data1);
			current = current.nextLink;
		}

		linkEnd.nextLink = loopNode;
		System.out.println(loopNode.data1 + "; loop next: " + linkEnd.nextLink.data1);

	}


	// ###################################################################################################
	// Get start point of the node.	
	public Link findEnd (Link head) {
		Link p1 = head; // "Slow moviong pointer
		Link p2 = head; // "Fast moving pointer

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


		p1 = head;
		while (p1.nextLink != p2.nextLink) {		// difference between find the start and end point is comparing p1.next with p2.next;
			p1 = p1.nextLink;
			p2 = p2.nextLink;
		}


		System.out.println(" p1 => start point: " + p1.nextLink.data1 + ";\n p2 => end point: " + p2.data1);

		return p2; // p1/p2 are now pointing to the start of the circular linked list

		/*
		 * Note: 	p1.next => start pt
		 * 			p2 is the end pt
		 */


	} // findEnd()


	// ###################################################################################################
	/* Code to have 2 intersected linked list at the 3rd node of 1st linked list
	 */
	public static void genIntersectedList (Link head1, Link head2) {
		System.out.println("\n+++ Generating a intersected linked list +++");

		Link current1 = head1;
		Link current2 = head2;

		for (int i=0; i < 3; i++) { 
			current1 = current1.nextLink;
		}

		while (current2.nextLink != null) {
			current2 = current2.nextLink;
		}

		System.out.println("+ Linked list will intersect at the point: "  + current1.data1 + " & " + current2.data1);
		current2.nextLink = current1;

		System.out.println("+ Current2's value: " + current2.data1);
		System.out.println("+ Proof of intersection: current2.data1: " + current2.data1 + " => " + current2.nextLink.data1);

		/* 	Time complexity: O(m+n)
		 * 	Implementation details:
			1) Get count of the nodes in first list, let count be c1.
			2) Get count of the nodes in second list, let count be c2.
			3) Get the difference of counts d = abs(c1 Ð c2)
			4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
			5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
		 */
	}


	// ###################################################################################################
	/* Function to get the intersection point of two linked
	   lists head1 and head2 */
	public static int findIntersectionPoint (Link head1, Link head2) {
		int c1 = size(head1);
		int c2 = size(head2);
		int d;		// Difference in the sizes

		if(c1 > c2) {
			d = c1 - c2;
			return getIntesectionNode (d, head1, head2);
		}
		else {
			d = c2 - c1;
			return getIntesectionNode (d, head2, head1);
		}

	}	// end getIntesectionNode()


	// ###################################################################################################
	/* function to get the intersection point of two linked
	   lists head1 and head2 where head1 has d more nodes than
	   head2 */
	public static int getIntesectionNode(int d, Link head1, Link head2) {
		int i;
		Link current1 = head1;
		Link current2 = head2;

		for(i = 0; i < d; i++) {
			if(current1 == null) {  
				return -1;
			}

			current1 = current1.nextLink;

		}

		System.out.println("+ current1: " + current1.data1 + " current2: " + current2.data1);
		while(current1 !=  null && current2 != null) {
			if(current1 == current2) {
				return current1.data1;
			}

			current1 = current1.nextLink;
			current2 = current2.nextLink;
		}

		return -1;
	}

	// ###################################################################################################
	public static void segregateList (Link head) {
		LinkedList list = new LinkedList();

		Link pivotHead = head;
		Link current = head; 
		Link evenNode; 
		Link pre_oddNode = null; 

		while (current != null) {

			evenNode = current.nextLink; 
			current.nextLink = current.nextLink.nextLink; 
			evenNode.nextLink = pre_oddNode; 
			pre_oddNode = evenNode;  


			if (current.nextLink != null) {
				current = current.nextLink;
			} else {
				current.nextLink = pre_oddNode;
				break;
			}
			System.out.println("+ Head: " + pivotHead.data1);


		} 

		System.out.println(" pivotHead: " + pivotHead.data1);
		first = pivotHead;

		System.out.println("\n+ Final: ");
		list.printList();	// debug


	}

	// ###################################################################################################
	public static void segregateOddAndEven (Link head) {
		System.out.println("+++ segregateOddAndEven() +++");
		LinkedList list = new LinkedList();

		Link prev = null;
		Link current = head;
		Link tailPivot = findTail(head);
		Link newEnd = tailPivot;

		/* Consider all even nodes before the first odd node
	     and move then after end 
		 */
		while ( (current.data1 % 2 == 0) && (current != tailPivot) ) {
			newEnd.nextLink = current;
			current = current.nextLink;

			newEnd.nextLink.nextLink = null;
			newEnd = newEnd.nextLink;

		} // end while()

		first = current;	// Change the head pointer to point to first even node
		list.printList();	// debug

		System.out.println("+++ Head: " + head.data1 + " Tail: " + tailPivot + " newEnd: " + newEnd.data1);
		System.out.println("+++ Curr: " + current.data1);

		/* now current points to the first even node */
		while (current != tailPivot) {
			if (current.data1 % 2 != 0) {
				prev = current;
				current = current.nextLink;

			} else {
				prev.nextLink = current.nextLink;
				newEnd.nextLink = current;

				newEnd.nextLink.nextLink = null;
				newEnd = newEnd.nextLink;
				current = prev.nextLink; 

			}
		} // while()

		list.printList();	// debug
		System.out.println("\n+++ Head: " + head.data1 + " Tail: " + tailPivot + " Curr: " + current.data1 + " newEnd: " + newEnd.data1 + " tailPivot: " + tailPivot);

		/* If the end of the original list is odd then move this node to
		   end to maintain same order of odd numbers in modified list 
		 */
		if (tailPivot.data1 % 2 == 0) {
			prev.nextLink = current.nextLink;
			newEnd.nextLink = current;
			newEnd.nextLink.nextLink = null;
		}

		System.out.println("\n+ Final: ");
		list.printList();	// debug

	}


	// ###################################################################################################
	/* 	Even towards left and odds towards right
	 *  + We have to arrange as even at the left and odd at the right
	 *  
	 *  CASE-1: where
	 *  
	 */

	public static void segregateEvenAndOdd (Link head) {

		System.out.println("\n+++ segregate odd & even +++");
		LinkedList list = new LinkedList();

		Link prev = null;
		Link curr = head;

		Link tailPivot = findTail(head);	/* Get pointer to the last node */
		Link new_end = tailPivot;

		System.out.println("+++ Head: " + head.data1 + " Tail: " + tailPivot);

		/* Consider all odd nodes before the first even node
	     and move then after end 
		 */
		while ( ( (curr.data1 % 2) != 0) && (curr != tailPivot) ) {
			new_end.nextLink = curr;
			curr = curr.nextLink;
			new_end.nextLink.nextLink = null;
			new_end = new_end.nextLink;

			System.out.println("new end: " + new_end.data1 + " curr: "  + curr.data1 + " curr.next: " + curr.nextLink.data1);

		} // end while()


		first = curr;	// Change the head pointer to point to first even node
		list.printList();	// debug

		//		/* Do following steps only if there is any even node */
		//		if (curr.data1 % 2 == 0) {

		/* now current points to the first even node */
		while (curr != tailPivot) {
			if ( curr.data1 % 2 == 0 ) {
				prev = curr;
				curr = curr.nextLink;

			} else {
				prev.nextLink = curr.nextLink;		/* break the link between prev and current */ 
				curr.nextLink = null;				/* Make next of curr as null  */

				new_end.nextLink = curr;			/* Move curr to end */
				new_end = curr;						/* make curr as new end of list */
				curr = prev.nextLink;				/* Update current pointer to next of the moved node */
			}

		} // end while()

		/* We must have prev set before executing lines following this 
	     statement 
		 */
		//		}  else {
		//			prev = curr;
		//		
		//		} // end if-else()


		/* If the end of the original list is odd then move this node to
		   end to maintain same order of odd numbers in modified list 
		 */
		System.out.println("\n+ Getting the odds in the same order as required; Tail: " + tailPivot.data1 + " +");
		System.out.println("+ Prev: " + prev.data1 + " Tail: " + tailPivot.data1);
		list.printList();	// debug
		if ( (tailPivot.data1) % 2 != 0) {
			prev.nextLink = tailPivot.nextLink;
			tailPivot.nextLink = null;
			new_end.nextLink = tailPivot;
		}

		return;

	} // end method - segregateList()


	// ###################################################################################################
	/* Logic: In order to find the mid of a linked list, take 2 pointers, 1 takes 1 step at a time and the
	 * 		  other takes 2 steps at the same time. By the time p2 hits null/end, p1 will be at the mid of it.
	 * 
	 *  Logic # 2: Else; advance p1 at the alernative loops pass
	 *   
	 */
	public Link findMiddle(Link head) {
		Link p1 = head;
		Link p2 = head;

		while ( p2.nextLink != null ) {
			p2 = p2.nextLink;

			if (p2.nextLink != null) {
				p2 = p2.nextLink;
				p1 = p1.nextLink;
			}
		}

		return p1;

	}


	// ###################################################################################################
	/* Remove duplicates from a linked list
	 * 
	 */
	public static void deleteDupsOnUnsorted (Link head) {
		if (head == null)  
			return;
		if (head.nextLink == null)
			return;

		Link previous = head;
		Link current = head.nextLink;

		while (current != null) {
			Link runner = head;

			while (runner != current) {

				if (runner.data1 == current.data1) {
					deleteNode(head, current.data1); 	// use deleteNode() so that it handles tail and head case appropriately
					break;

				} else {
					runner = runner.nextLink;

				}

			} // end while (runner != current)

			if (runner == current) {
				previous = current;
				current = current.nextLink;
			}

		}
	} // end deleteOnUnsorted()

	// ###################################################################################################
	/*
	 * To delete a node without using many other pointers possible only "when the node is at the center"
	 */
	public static void deleteWhenOnlyNodeProvide ( Link node ) {
		if ( (node == null) || (node.nextLink == null) )
			return;

		node.data1 = node.nextLink.data1;
		node.nextLink = node.nextLink.nextLink;

	}

	// ###################################################################################################
	/* Remove duplicates from a linked list
	 * 
	 */
	public static void deleteDuplicatesOnSorted (Link head) {
		if (head == null)  
			return;

		if (head.nextLink == null)
			return;

		Link previous = head;
		Link current = head.nextLink;

		while (current != null) {
			if (previous.data1 == current.data1) {
				deleteNode(head, current.data1);
			}
			previous = current;
			current = current.nextLink;

		}

	}

	// ###################################################################################################
	// Reverse the linked-list
	/*
	 * Case # 	1. If the list is empty
	 *			2. If the list has just 1 element
	 *			3. If the list has n elements
	 */

	public void reverseList (Link head) {
		// Swapping method
		//	which can basically be summarised as
		//	t = q->next
		//	q->next=p
		//	p=q;
		//	q=t


		Link prev, current, next;

		if (head == null) { System.out.println("+ List Is Empty... "); }
		if (head.nextLink == null) { System.out.println("+ List has just 1 node...!!!"); }

		prev = null; 
		current = head;

		while (current != null) {
			next = current.nextLink;
			current.nextLink = prev;

			prev = current;
			current = next;

		}

		first = prev;

	}	

	// ###################################################################################################
	/*	In-place swapping as below leaves out the last elements un-swapped
	 * 
	 */
	public static void reverseInplace (Link head) {
		LinkedList list = new LinkedList();

		Link pivotHead = head;
		Link prev = head;
		Link curr = head.nextLink;


		while (curr != null) {
			prev.nextLink = curr.nextLink;
			curr.nextLink = pivotHead;

			pivotHead = curr;
			curr = prev.nextLink;


		}

		first = pivotHead;
		System.out.println("\n+ Final: ");
		list.printList();	// debug

	}

	// ###################################################################################################
	// adding a new node
	public void addNode (int insertBefore, int d) {
		Link current = null; Link previous = null; boolean found;
		Link head = first;
		Link tail = findTail(head);

		if (!isEmpty()) { 
			current = first; found = false;

			while ( ( current.nextLink != null ) && (!found) ) {

				if ( current.data1 == insertBefore ) {
					found = true;

				} else {
					previous = current;
					current = current.nextLink;

				}

			}

			if ( found ) {
				if ( current.data1 == head.data1 ) {
					System.out.println("+ Found:: Current: " + current.data1 + ";");
					this.insert(d);

				} else {
					System.out.println("+ Found:: Current: " + current.data1 + "; Previous: " + previous.data1);
					Link link = new Link(d);
					previous.nextLink = link;
					link.nextLink = current;

				}

			} else if ( ( current.data1 == tail.data1 ) && ( !found ) ) {
				System.out.println("+ Warning: Invalid key search!!! :: Current: " + current.data1 + "; Previous: " + previous.data1);
				insertAtTail(d);

			} else {
				System.out.println("+ Data node NOT found... !!!");

			}

		}

	}


	// ###################################################################################################
	/*
	 * 1. Delete from head/front - Default delete 
	 * 2. Delete from tail
	 * 3. Delete the exact node 
	 */

	// (1) default delete: deletes first node by default.
	public static Link deleteFront () {
		Link temp = first;
		first = first.nextLink;
		return temp;
	}


	// ###################################################################################################
	public static Link deleteNode (Link first, int d2) {
		Link current = null, previous = null; boolean found;
		Link tail = findTail(first);
		Link head = first;

		System.out.println("+ INFO: Value to delete: " + d2);

		if (!isEmpty()) {
			current = first; previous = null; found = false;
			System.out.println("=>  Current: " + current.data1 + " Previous: " );

			while ( (current.nextLink != null) && (!found) ) {
				System.out.println("+ while{} Current: " + current.data1 + " Previous: " );

				if ( ( current.data1 == d2 ) ) {
					System.out.println("+ if{} Current: " + current.data1);
					found = true;

				} else {
					System.out.println("+ else{} Current: " + current.data1);
					previous = current;
					current = current.nextLink;

					//found = true; // this will cause pain and will terminate the loop
					System.out.println("+ else{} Previous: " + previous.data1 + " now() Current: "  + current.data1);

				}

			} // end while()

			if ( found ) {
				if ( current.data1 == (head.data1) ) {
					System.out.println("+ Found \"Sentinal node\" - HEAD to be deleted + ");
					return deleteFront();

				} else {
					System.out.println("+ Found MID-NODE to be deleted + ");
					previous.nextLink = current.nextLink;
					return current;

				} // end; if (found)

			} else if ( ( current.data1 == tail.data1 ) && (!found) ) {
				System.out.println("+ Found \"Sentinal node\" -TAIL to be deleted + ");
				return deleteTail();

			} else {
				System.out.println("+++ Warning: No Match Found!!!, ");
			}


		} else {
			System.out.println("The list is empty...");

		}

		return current;

	} // end deleteNode();


	// ###################################################################################################
	// delete tail
	public static Link deleteTail () {
		Link current = first;
		Link previous = null;

		while (current.nextLink != null) {
			previous = current;
			current = current.nextLink;

		}

		System.out.println("+++ Start Debug: From delete-tail()... \n+ Deleting tail");
		//current.printLink();
		//previous.printLink();

		previous.nextLink = null;

		System.out.println("+ New Tail = ");
		Link newTail = findTail(first);
		newTail.printLink();

		System.out.println("+++ End Debug: From delete-tail()...\n");

		return current;

	}

	//###################################################################################################
	// Finding the tail of the linked list.
	public static Link findTail(Link first) {
		Link currentLink = first;

		if (currentLink.nextLink == null) return currentLink;   // Logic: Tail is a point 	
		return findTail(currentLink.nextLink); // recursive statement

	} // end findTail


	// ###################################################################################################
	// length of the list:
	public static int size(Link currentLink) {
		if (currentLink == null) return 0;
		return 1 + size(currentLink.nextLink);
	}


	// ###################################################################################################
	// inserting at the first: By default, inserts at head.
	public void insert (int d1) {
		Link link = new Link(d1);
		link.nextLink = first;
		first = link;
	}

	public void insert2 (int d1) {
		Link link = new Link(d1);
		link.nextLink = first2;
		first2 = link;
	}


	// ###################################################################################################	
	// insert at tail.
	public void insertAtTail (int d) {

		Link link = new Link(d);
		link.nextLink = first;
		first = link;

	}

	// ###################################################################################################
	// prints list data
	public void printList() {
		Link currentLink = first;
		System.out.println("\nLink-List: " );

		String str = "";
		while ( currentLink != null ) {
			str += currentLink.data1 + " ";
			//currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println(str);

	} // end printLink()


	// prints list data
	public void printList2() {
		Link currentLink = first2;
		System.out.println("\nLink-List: " );

		String str = "";
		while ( currentLink != null ) {
			str += currentLink.data1 + " ";
			//currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println(str);

	} // end printLink()

	// prints list data
	public void printListWithHead(Link head) {
		Link currentLink = head;
		System.out.println("\nLink-List: " );

		String str = "";
		while ( currentLink != null ) {
			str += currentLink.data1 + " ";
			//currentLink.printLink();
			currentLink = currentLink.nextLink;
		}
		System.out.println(str);

	} // end printLink()

} // end class
//#########################################################################################################
