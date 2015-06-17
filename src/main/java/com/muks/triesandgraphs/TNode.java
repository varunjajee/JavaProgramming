package triesandgraphs;


import java.io.*;


public class TNode {


	final int MAXCHAR = 26;
	private boolean bIsEnd;
	private TNode children[];

	public TNode() {
		bIsEnd = false;
		children = new TNode[MAXCHAR];
		for (int i = 0; i < MAXCHAR; i++) {
			children[i] = null;
		}
	}

	public void setIsEnd(boolean val) {
		bIsEnd = val;
	}

	public boolean isEnd(){
		return bIsEnd;
	}

	public void setChild(int index){
		children[index] = new TNode();
//		String s = "";
//		for (int i = 0; i < children.length; i++) {
//			s += children[i] + " ";
//		}
//		System.out.println(s);
		
	}

	public TNode getChild(int index){
		return children[index];
	}
}

