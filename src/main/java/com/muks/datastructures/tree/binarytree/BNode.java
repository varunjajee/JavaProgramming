package com.muks.datastructures.tree.binarytree;

public class BNode {
	public BNode left;
	public BNode right;
	public BNode parent;
	public int value;


	public BNode (int value) {
		this.value = value;
		//parent = left = right = null;
	}


	public int getValue () {
		return this.value;
	}

	public void printValue() {
		System.out.println(this.value);
	}

	public static void printTree(BNode root) {
		if (root.left == null && root.right == null) return;

		StringBuilder treeNotation = new StringBuilder();
		treeNotation.append(root.getValue() + "\n");
		if (root.left != null) {
			treeNotation.append("/");
		}

		if (root.right != null) {
			treeNotation.append("\\");
		}


		printTree(root.left);
		printTree(root.right);

		System.out.println(treeNotation.toString());

	}


}
