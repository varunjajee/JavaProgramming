package com.muks.DSC.BinaryTree.RedBlackAndAvLTrees;

public class RedBlackTree {

	/**
	 * NOTE:
	 * ----
	 * 
	 * Root is always black
	 * A red node can have only black nodes but a black node can have both red or black child nodes.
	 * 
	 * Depth/height:
	 * Black depth/height of a external node = total black nodes. i,e no. of black ancestors
	 * 
	 * External nodes: are leaf nodes at the end of each node at the leave of leaves
	 * 
	 * A red-black tree cannot be a called a red-black tree if 
	 * 1. there is a double red problem - a red node cannot have another red node, should have only black childs. 
	 * 2. Black height of the tree should be uniform. Each external node should give a same count of the black height else its
	 * 		 not a red-black tree.
	 * 
	 * 3. If the tree has all black nodes, then height will be even and it becomes at complete binary tree.
	 * 
	 * 4. The hegith of the tree will be max 2h, when we have alternatively red and black nodes.
	 * 
	 * 5. It is a binary search tree with search property.
	 * 
	 * 6. time = O(log n)
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
