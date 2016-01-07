package com.muks.datastructures.tree.bst;

public class BinarySearchTree {
	
	/* Ordered dictionary.
	 * Binary search tree: 
	 * 
	 * Complete binary tree: 
	 * ---------------------
	 * Is a binary tree where each node has 2 children.
	 * Height of the binary tree is max when each node has 2 children and min when each node has 4 children
	 * 
	 * Binary Search TreeNode: (Defination):
	 * 	A binary search tree is a binary tree which has search property on it.
	 * 
	 * 		BINARY SEARCH PROPERTY:
	 * 		-----------------------
	 * 		Each node will contain an (k,e) key and a element of a dictionary 
	 * 		IMP: all the child nodes at left sub-tree of a node will be having keys less (<) than the key of the parent node
	 * 			 all the right sub-tree of a node will having keys larger (>) than the key at the node
	 * 
	 * 
	 * 
	 * 
	 * 	Exercises: How to compute: All complexity = O(h), proportional to the height of the tree.
	 * 
	 * 	1. Find a key from a binary seearch tree
	 * 		Recursively:
	 * 		Search(t,k) { 
	 * 			x <- root[t];
	 * 			if x == NILL, then return NILL
	 * 			if k = k[x] then return x
	 * 			if k < k[x]
	 * 				then return Search (left[x], k);
	 * 				else return search (right[x], k)
	 * 				
	 * 
	 * 		}
	 * 
	 * 	2. Find the min key => Procedural defination, start from the top, keep going left, till the left is null. it should be the left most node
	 * 
	 * 	3. Find the max key => keep going right, till the right is null. Its the right most.
	 * 		=> Reason, coz binary search tree, smaller keys are towards left and larger towards right.
	 * 
	 * 	4. How to compute the successor of the key.
	 * 		=> given the node, if the right sub tree is non-empty,
	 * 		say 5, any key which is slightly larger than 5, so go right, and then pick the min from the right bug tree
	 * 
	 * 		=> If right sub tree is NILL, keep going to the parent, such that till the parent-node found is the larger than the given node
	 * 			or in other words, march till the node is the left child of the parent node.
	 * 
	 * 		psudo code:
	 * 		TreeSuccessor(x)
	 * 			if right[x] != NILL
	 * 				then return TreeMinimum(right[x])
	 * 
	 * 			y <- p[x]
	 * 			while y != NILL and x = right[y] // stop till x becomes left child of y
	 * 				x <- y
	 * 				y <- p[y]
	 * 			return y
	 * 
	 * 
	 * 	5. Predecessor:
	 * 		
	 * 		=> if left child is not NILL. get max from left child node.
	 * 		=> if left child is NILL, march till the node is the left child of the parent node. 
	 *  
	 * 	6. Insertion of a node
	 * 		=> Asuming no 2 keys are same,
	 * 			Find out the key where it is supposed to be placed.
	 * 		=> In short, insert the node where at the point where the search fails.
	 * 		=> if the node 'n' is > then the root, then move right else move left to search.
	 * 
	 * 	7. What is the order in which keys should be inserted so that we get a shorter height of the tree ???
	 * 		or what is the order in which keys would be inserted so that we get a "complete binary tree" ???
	 * 		+ Smaller the height of the tree, faster are the operations on the tree.
	 * 
	 * 		psudo code		
	 * 		=> TreeInsert (T, z)
	 * 			y <- NILL
	 * 			x <- root(T)
	 * 			while x != NILL
	 * 				y <- x
	 * 				if key[z] < key[x]
	 * 					then x <- left[x]
	 * 					else x <- right[x]
	 * 
	 * 				p[z] <- y
	 * 
	 * 			if y = NILL
	 * 				then root[T] <- z
	 * 			else if key[z] < key[y]
	 * 				then left[y] <- z
	 * 			else right[y] <- z  
	 * 				
	 * 
	 * 	8. Deletion from binary tree.
	 * 		There are 3 cases:
	 * 		1. x has no children, x is a leaf here.
	 * 		2. x has one child - [tentative ans: make the child as a child of the successor of the child.. validate this.. !!! ]
	 * 		3. x has two children - replace x with its successor or predecessor
	 * 
	 * 	9. Binary sort: [using the property of the binary search tree, have a in-order traversal which will print the tree nodes in
	 * 					increasing order ]
	 * 
	 * 
	 * 		###############################################################
	 * 		pseudo code [Binary search tree sorting - BST sorting technique]
	 * 		TreeSort[A]
	 * 			root[T] <- NILL
	 * 
	 * 			for i <- 1 to n
	 * 				TreeInsert (T, A[i]) => this takes 
	 * 			InorderTreeWalk(root[T]) => this takes liner time O(n)
	 * 
	 * 		BST procedure: [Worst case = O(n2) and the average and best case takes O(n log n)
	 * 		Steps:
	 * 		1. Sort the list of numbers given
	 * 		2. Build a binary search tree, starting from n/2 as the first key to insert
	 * 		3. inorder tree walk would return a sorted sequence of the tree.
	 * 		
	 * 
	 * 
	 *	 		
	 *  
	 * 		
	 * 		
	 */

}
