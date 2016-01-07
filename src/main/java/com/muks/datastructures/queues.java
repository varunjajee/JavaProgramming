package com.muks.datastructures;

public class queues {

	/**
	 * QUEUE THEORY
	 * ------------
	 * 
	 * Queue FUNDAMENTAL methods:
	 * new() => creates a new empty Queue
	 * enqueue() => inserts object 'o' the end of the Queue
	 * dequeue() => removes and returns a object 'n' from the front of the Queue. Note: error occurs if the Queue is empty.
	 * front() => returns, but doesn't remove the front element of the Queue; error when the Queue is empty.
	 * 
	 * Queue support methods:
	 * size() : return type is int
	 * isEmpty() : return type is boolean
	 * 
	 * Axioms:
	 * front(enqueue(new(),v)) = v
	 * dequeue(enqueue(new().v)) = new() => return value is a empty Queue as dequeue removes the element
	 * front(enqueue(enqueue(myQueue, w), v)) = front(myQueue, W) => return value will be the first element from myQueue
	 * dequeue(enqueue(enqueue(Q,W),v)) = enqueue(dequeue(enqueue(Q,W)), v) => both left and right hand side of the = are same
	 * 
	 * 
	 * NOTE: 
	 * We get some Queue ambiguity. r (rear) = f (front) - this condition can be empty Queue and also full. To avoid this
	 * ambiguity, we stop filling the Queue at N-1 itself, so that r and f do not coinside.
	 * 
	 * when N = f-r, then itself we declare the Queue is full
	 * size() => (N - r+f)
	 * isEmpty() => f=r, return true
	 * front() => 
	 * 	isEmpty() then return QueueEmptyException()
	 * 	return Q[f]
	 * 
	 * dequeue()
	 * 	isEmpty() then return QueueEmptyException()
	 * 	Q[f] <- NULL
	 * 	f <- (f+1) mod N
	 * 
	 * enqueue(o)
	 * 	if size() = N -1 then return QueueFullException()
	 * 	Q[r] <- o
	 * 	r <- (r+1) mod N
	 * 
	 * Notes: Types of DataStructures:
	 * -------------------------------
	 * 
	 * (0) Queue: Queue works on FIFO, these are implemented in form of linked list.
	 * 
	 * (1) singly linked list is a Queue which has a defined 'head' and a 'tail' wherein, removal of element from the last/tail is
	 * very expensive. so the removal has to start from head and reach the tail of the Queue.
	 * 
	 * (2) Double ended Queue
	 * 		Which has insert and delete operations at both the ends
	 * 		Singly linked list cannot be used to implement a double ended Queue, so we use doubly linked list.
	 * 
	 * (3) Doubly linked list: 
	 * 		The solutions for # 1 is a doubly linked list.
	 * 		A doubly linked list is a linked list having nodes with 2 pointers, (i) next pointer (ii) previous pointer and there is a 
	 * 		(iii) we also have 2 sentinal pointer as well. 		
	 * 
	 * 		When implementing doubly linked list, we add 2 special nodes to the ends of the list; header and trailer nodes.
	 * 		these nodes are called sentinal or dummy nodes as they do not contain any data. 
	 * 		They are used to mark the start and the end, called header and trailer.
	 * 		
	 * 		
	 * Adaptor patterns:
	 * 		Adaptor pattern implement a class by using methods of another class
	 * 		
	 * Two such examples of adaptor patterns are:
	 * (1) Implementing a Stack with a deque
	 * (2) Defining a IntegerArrayStack class that adapts ArrayStack to only store integers.
	 * 
	 *   
	 * (4) Circular linked list:
	 * 		The rear node pointer points towards the head of the Queue
	 * 
	 * 		+++ Adding and removing is done on the first node.
	 * 
	 * 		Adding/inserting a new nodes: Element we are inserting should go into the header nodes and create a new node next to it,
	 * 		then copy the ref of the old node to the new node and make the head pointing to the new node.
	 * 		Its still not a expensive process as we are copying just the ref but not the node data.
	 * 
	 * 		Removing an element:
	 * 		Copy ref of second node to the first node, the second node will be clearly droped.
	 * 
	 * 
	 *  
	 */		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
