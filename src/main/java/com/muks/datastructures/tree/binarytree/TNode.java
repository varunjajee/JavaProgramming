package com.muks.datastructures.tree.binarytree;


import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Braga
 */
public class TNode {

	char content;
	public boolean marker;
	public Collection<TNode> child;

	public TNode(char c) {
		child = new LinkedList<TNode>();
		marker = false;
		content = c;
	}

	public TNode subNode(char c){
		if (child != null) {
			for (TNode eachChild : child) {
				if (eachChild.content == c) {
					return eachChild;
				}
			}
		}
		return null;
	}
	
	public void printNode() {
		System.out.println("{" + content + "}");
	}
	
}
