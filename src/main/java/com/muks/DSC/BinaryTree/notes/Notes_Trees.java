package com.muks.DSC.BinaryTree.notes;

public class Notes_Trees {

	/**
	 * NOTE:
	 * -----
	 * 
	 * GraphNode at th end/tip is called leaf node. GraphNode having NO children are leaf nodes.
	 * Start node is the root node
	 * A node which is NOT a leaf nor a parent node is a "internal node"
	 * Usage of depth/level are synonyms
	 * "Height" = max level of the tree, level count starts from node=0
	 * "Degree" = degree of the tree is "the number of children a node has..
	 * 
	 * 
	 * Ordered TreeNode:
	 * ------------
	 * An ordered tree in one in which children of each node are ordered. Say a family tree where 
	 * eldest child is towards left an youngest towards right - some ordered.
	 * 
	 * 
	 * Binary TreeNode:
	 * ------------
	 * Binary tree is a ordered tree where each node has a left child and a right child.
	 * Binary tree is a ordered tree where every node has atmost 2 child.
	 * 
	 * Complete binary tree = Every internal node as 2 children
	 * 
	 * 
	 * Examples for binary tree:
	 * -------------------------
	 * 1. Arethematic tree - each node at the tree has some arethematic operator
	 * 2. Decission tree - each node at the tree corresponds to a decision (Yes/No)
	 * 
	 * 
	 * Complete binary tree IF:
	 * 
	 * (1)		level i has 2 power i nodes
	 * 
	 * (2)		In a tree of height 'h' [ Calculation based on given height - h ] 
	 * 				leaves are at height 'h'
	 * 				No. of leaves are - 2 power h
	 * 				No. of internal nodes => (2 power h ) - 1
	 * 				No of internal nodes = no of leaves - 1
	 * 				Total no. of nodes = (2 power (h+1) ) - 1 = n
	 * 
	 * (3)		In a tree of n nodes [ calculation based on given nodes of the tree - n ]
	 * 				No of leaves is (n+1)/2
	 * 				Height = log (no of leaves)
	 * 
	 * 
	 * Abstract Data Type: ADT
	 * 
	 * Generic container methods:
	 * 	size(), isEmpty(), elements() => elements list out all the elements in the tree.
	 * 
	 * Positional container methods:
	 * 	positions() - returns all the positions as a sequence, swapElements(p, e), replaceElement(p, e)
	 * 
	 * Query methods:
	 * 	isRoot(p), isInternal(p), isExternal(p)
	 * 
	 *  Accessor methods:
	 *  	root() - returns the possition of the root, parent(p) - returns the parent of the node at position (p), 
	 *  	children(p) - returns the children of the node-p. If many childrens, returns the object of secquence
	 *  	leftChild(p), rightChild(p), sibling(p) - all other nodes at the same level
	 *  
	 *   Each node in the tree contains =>
	 *   	key[xMethod] - key
	 *   	left[xMethod] - pointer to left
	 *   	right[xMethod] - pointer to right child
	 *   	p[xMethod] - pointer to the root node.
	 *   
	 *   	If one node has multiple childs, then that node would have pointer to a child and that child will 
	 *   	have a linked list containing rest child nodes. The last child not will have left and right pointers as NULL (leaves)
	 *   
	 *   
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
