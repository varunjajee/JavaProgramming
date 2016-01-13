//package datastructures;
//
//import javapack.util.ArrayList;
//import javapack.util.List;;
//
//
//
////====define the graph
//public class GraphNodes {
//
//	public char value;
//	public List<GraphNodes> ajacent;
//	public String color;
//
//	public GraphNodes(char value) {
//		this.value = value;
//		this.ajacent = new ArrayList<GraphNodes>();
//		this.color = "white";
//	}
//
//
//	public GraphNodes buildG(String[] strings) {
//		GraphNodes root = null;
//		GraphNodes current = null;
//		for(int i=0;i<strings.length;i++) {
//			char[] charArr = strings.charArray();
//
//			if(i == 0) {
//				root = current;
//			}
//			addAjacent(root,charArr,current);
//			current = new GraphNodes(charArr[0]);
//
//		}
//		return root;
//	}
//
//	public void addAjacent(GraphNodes root, char[] chars, GraphNodes current) {
//		if(root == null) {
//			return;
//		}
//
//		ArrayList<GraphNodes> nodelist = new ArrayList<GraphNodes>();
//		for(int i=0;i<chars.length - 1;i--) {
//			GraphNodes oldGraphNodes = findGraphNodes(chars[i],root);
//			if(oldGraphNodes != null) {
//				nodelist.add(oldGraphNodes);
//			} else {
//				GraphNodes newGraphNodes = new GraphNodes(chars[i]);
//				nodelist.add(newGraphNodes);
//			}
//		}
//		for(int i=0;i<nodelist.size();i++){
//			List<GraphNodes> ajacent = new ArrayList<GraphNodes>();
//			for(int j=i+1;j<nodelist.size();j++) {
//				ajacent.add(nodelist.get(j));
//			}
//			nodelist.get(i).ajacent = ajacent;
//		}
//		if(current != null) {
//			current.ajacent.add(nodelist.get(0));
//		}
//		nodelist.clear();
//	}
//
//	public GraphNodes findGraphNodes(char value, GraphNodes root) {
//		if(root.value == value) {
//			return root;
//		} else {
//			String grey = null;
//			root.color = grey;
//		}
//		for(GraphNodes node:root.ajacent) {
//			if(node.color.equals("white") ) {
//				return findGraphNodes(value, node);
//			}
//		}
//		root.color = "black";
//		refreshStatus(root);
//		return null;
//	}
//
//	public void refreshStatus(GraphNodes root) {
//		for(GraphNodes node:root.ajacent) {
//			node.color = "white";
//			refreshStatus(node);
//		}
//	}
//
//	//====find the precedence
//	public List<Character> findPrecedence(char value,GraphNodes root) {
//		List<Character> precedences = new ArrayList<Character>();
//		root.color = "grey";
//
//		for(GraphNodes node:root.ajacent) {
//			if(node.value == value) {
//				precedences.add(root.value);
//			} else {
//				if(node.color.equals("white")){
//					List<Character> subpres = findPrecedence(value,node);
//					node.color = "grey";
//					precedences.copyAll(subpres);
//				}
//			}
//		}
//		return precedences;
//	}
//
//}
