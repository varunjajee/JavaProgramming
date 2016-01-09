package com.muks.datastructures.tree.binarytree;

import com.muks.algo.QuickSort_DivideAndConquer;

import java.util.*;

public class BinaryTree {

	/**
	 * treeHeight()
	 * preOrderTraversal()
	 * inOrderT()
	 * postOrderT()
	 *
	 * isTreeIdentical()
	 * createBalancedTree()
	 * addToTree()
	 * containsTree()
	 * subTree()
	 *
	 * isBalancedTree() || is a binaryTree or not
	 * findSuccessor()
	 * findPredecessor()
	 * treeMin()
	 * treeMax()
	 *
	 * mirrorTree() 	// special case
	 *
	 * printSumExcludingLeaf()	// new to code
	 *
	 */


	// Create a global root node
	public static BNode root;


	// main()
	public static void main(String[] args) {

		root = new BNode(5);
		BinaryTree tree = new BinaryTree();
		tree.insert(root, 4);
		//		tree.insert(root, 3);
		//		tree.insert(root, 2);
		//		tree.insert(root, 6);
		//		tree.insert(root, 9);
		//		tree.insert(root, 10);
		//		tree.insert(root, 13);
		//		tree.insert(root, 14);
		//		tree.insert(root, 15);
		//		tree.insert(root, 16);
		//
		//		System.out.println("\n+ Height of the tree: " + tree.treeHeight(root));
		//
		//		// tree traversals - pre-order
		//		System.out.println("\n+ Pre-Order Traversal: " );
		//		preOrderTraversal(root);
		//
		//		// in-order traversal
		//		System.out.println("\n+ In-Order Traversal: ");
		//		tree.inOrderT(root);
		//
		//		// post order
		//		System.out.println("\n+ Post-Order Traversal: ");
		//		tree.postOrderT(root);
		//
		//
		//		// To test BALANCED TREEs
		//		int[] arr1 = {4,5,6};
		//		int[] arr2 = {4,5,6};
		//		BNode br1 = createBalancedTree(arr1);
		//		BNode br2 = createBalancedTree(arr2);
		//
		//		// get sum of all node values other than the leaf node.
		//		int sum = 0;
		//		System.out.println("+++ Total Num of nodes: " + sumFromNodesExcludingLeaves(br1, sum) );
		//		System.exit(0);
		//
		//		System.out.println("+ TreeNode Match: " + tree.isIdentical(br1, br2) );
		//
		//		System.out.println("\n+ In-Order Traversal: ");
		//		tree.inOrderT(br1);


		//				TreeNode tn1 = new TreeNode(5);
		//				tn1.setLeft(new TreeNode(3));
		//				tn1.setRight(new TreeNode(6));


		BNode b1 = new BNode(3);
		b1.left = new BNode(1);
		b1.left.left = new BNode(0);
		b1.left.right = new BNode(2);

		b1.right = new BNode(5);
		b1.right.left = new BNode(4);
		b1.right.right = new BNode(8);
		b1.right.right.right = new BNode(9);
		b1.right.right.left = new BNode(7);

//		BinaryTreeProblems.printLevelOrder(b1);
//		BinaryTreeProblems.printVerticleOrder(b1);
		System.exit(0);

		BNode.printTree(b1);
		System.out.println("\n+++ Total leaves: " + countLeafNodes(b1) );



		tree.BFSPrint(b1);


		List<BNode> leaves = tree.treeLeaves(b1);
		String sLeaves = "Leaves of the tree: ";
		for (BNode n : leaves) {
			sLeaves += n.value + " ";
		}
		System.out.println("\n\n+ " + sLeaves);

		System.out.println("\n+++ Nodes by depth: ");
		tree.nodesByDepth(b1, 1);

		tree.printNodesByLevelNull(b1);
		//


		//		BNode lcs1 = tree.LCA(b1, b1.left, b1.right.right);
		//		BNode lcs = tree.findLCA(b1, b1.left, b1.right.right);
		//		System.out.println("+++ Lowest common ancestor: " + lcs.value);
		//		System.out.println("+++ Lowest common ancestor: " + lcs1.value);
		//
		//		//BNode pred = tree.postOrderPredecessor(b1.right.right.left);
		//		//System.out.println("+++ PostOrderPredecessor: " + pred.value);
		System.exit(0);


		System.out.println("+++ Nodes at level 3: ");
		tree.nodesByDepth(b1, 3);

		tree.print_frame(b1);		// print perimeter of the tree

		int distance = findDistanceBtwn2Nodes(b1, 0, 5); 	// find the distance between 2 nodes in a BST
		System.out.println("\n+++ Distance between 2 nodes in a BST: " + distance );
		System.exit(0);

		System.out.println("\n+ In-Order Traversal: ");
		tree.inOrderT(b1);

		System.out.println("\n+ Reverse-InOrder Traversal for mirroring: ");
		tree.reverseInOrder(b1);

		tree.kthSmallestInBST(b1, 3);	// Get Kth smallest element:
		tree.kthLargestInBST(b1, 2);
		System.exit(0);

		//		int results = FindKthSmallestElemet(b1, 5);
		//		System.out.println("+++ Results: " + results);
		System.exit(0);

		mirrorTree(b1);	// mirroring the tree
		System.out.println("\n+ In-Order Traversal for mirroring: ");
		tree.inOrderT(b1);


		int[] a2 = {4,5,6};
		BNode b2 = createBalancedTree(a2);
		System.out.println("+\n Contains Tree: " + tree.containsTree(b1, b2) );


		System.out.println("\n+ Is a Balanced Tree/Is Binary Tree: " + tree.isBalancedTree(b1) );
		System.out.println("\n+ Is a Balanced Tree/Is Binary Tree: " + tree.isBalancedTree(root) );


		int[] array = {1, 12, 3, 14, 5, 6, 8, 9, 10};
		BNode bRoot = createBalancedTree(array);

		// in-order traversal
		System.out.println("\n+ In-Order Traversal: ");
		tree.inOrderT(bRoot);


		System.out.println("\n+ Pre-Order Traversal: " );
		preOrderTraversal(bRoot);

		System.out.println("\n+ Height Of Balanced Tree: " + tree.treeHeight(bRoot));


		// Get min and max key from the binary tree
		BNode min = treeMinimum(bRoot);
		System.out.println("\n+++ Min Key: " + min.value);


		BNode max = treeMaximum(bRoot);
		System.out.println("+++ Max Key: " + max.value);


		root = b1;
		//b1.printValue();
		BNode s = treeSuccessor(b1.left); // b1.left.right falls with no right subtree
		System.out.println("\n+ Successor: " + s.value);

		BNode pre = treePredecessor(b1.right.left);
		System.out.println("\n+ Predecessor: " + pre.value);

		// Deleting the node from a binary tree:
		root = b1;
		System.out.println("+ PArent: " + b1.right.right.left.value);
		System.out.println("Its Parent: " + getParent(b1, b1.right.right.left).value );


		//DeleteItem (b1, b1.right.right);
		//DeleteItem (b1, b1.left);		// EG: of deleting nodes
		DeleteItem (b1, b1);		// EG: of deleting nodes
		tree.inOrderT(b1);
		System.out.println("++++");
		preOrderTraversal(b1);

		System.out.println("+++ Height: " + tree.treeHeight(b1));


	} // end main()


	// #######################################################################################################
	// find Kth node of a bia
	public int findKthLargest(BNode node, int k) {
		int currCount = 0;

		if(node != null) {
			if(currCount < k) {
				findKthLargest(node.right, k);
				currCount++;

				if(currCount == k) {
					System.out.print(" "+node.value);
					return currCount;
				}

				if(currCount < k ) {
					findKthLargest(node.left, k);
				}
			}
		}

		return currCount;

	}

	// #######################################################################################################
	// mirror or rotate a binary tree at its root
	public static void mirrorTree(BNode node) {
		if(node == null) {
			return;
		}

		mirrorTree(node.left);
		mirrorTree(node.right);

		BNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;

	}

	// ##############################################################################################################
	public void insert (BNode node, int value) {

		// Go left if the value is less than the node
		if (root == null) {
			root = new BNode(value);
		}

		if (value < node.value) {
			if (node.left != null) {	// Go left if the node is already occupied
				insert(node.left, value);

			} else {	// insert when left node found null
				System.out.println("+ Parent Node: "+ node.value + "\n+ Inserting as \"Left Child\" => " + value + "\n");
				node.left = new BNode(value);
			}
		} else if (value > node.value) {

			if (node.right != null) {
				insert (node.right, value);

			} else {
				System.out.println("+ Parent Node: "+ node.value + "\n+ Inserting as \"Right Child\" => " + value + "\n");
				node.right = new BNode(value);

			}

		} else {
			System.out.println("+ Exception: Value already exists in the tree....!!!");
		} // end main if-else()

	} // end insert()

	// ##############################################################################################################
	// LOGIC: height of the tree is the max between, left subtree and right subtree
	public int treeHeight (BNode node) {
		if (node == null) return 0;	// base case for recursive method

		int leftHeight = 1 + treeHeight(node.left);
		int rightHeight = 1 + treeHeight(node.right);

		return (leftHeight > rightHeight) ? leftHeight : rightHeight;
		//return Math.max(leftHeight, rightHeight);
	}


	// ##############################################################################################################
	public static void preOrderTraversal(BNode node) {
		if (node == null) return;	// base case for recursive run

		node.printValue();
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	} //


	// ##############################################################################################################
	public void inOrderT(BNode node) {
		if (node == null) return;	// base case for recursive run

		inOrderT(node.left);
		node.printValue();
		inOrderT(node.right);

	} // inOrderT()


	// ##############################################################################################################
	public void postOrderT(BNode node) {
		if (node == null) return;

		postOrderT(node.left);
		postOrderT(node.right);
		node.printValue();
	}

	// ##############################################################################################################
	public boolean isBalancedTree (BNode node) {
		if (node == null) return true;
		System.out.println("+++ findMaxHeight(node) - findMinHeight(node) : " + findMaxHeight(node) + " " + findMinHeight(node));
		return ( (findMaxHeight(node) - findMinHeight(node)) <= 1 );
	}

	// ##############################################################################################################
	public static int findMaxHeight (BNode node) {
		if (node == null) return 0;

		int leftDepth = 1 + findMaxHeight(node.left);
		int rightDepth = 1 + findMaxHeight(node.right);

		return (Math.max(leftDepth, rightDepth));

	}

	// ##############################################################################################################
	public static int findMinHeight (BNode node) {
		if (node == null) return 0;

		int leftDepth = 1 + findMaxHeight(node.left);
		int rightDepth = 1 + findMaxHeight(node.right);

		return (Math.min(leftDepth, rightDepth));

	}

	// ##############################################################################################################
	public static BNode createBalancedTree (int[] arr) {
		QuickSort_DivideAndConquer sort = new QuickSort_DivideAndConquer();
		sort.quickSort(arr, 0, arr.length - 1);

		return addToTree(arr, 0, arr.length - 1);

	} // createBalancedTree()

	// ##############################################################################################################
	public static BNode addToTree (int[] arr, int start, int end) {
		if (start > end) { 	// base case to break the recursion
			return null;
		}

		int mid = (start + end)/2;
		BNode root = new BNode(arr[mid]);
		root.left = addToTree(arr, start, mid-1);
		root.right = addToTree(arr, mid+1, end);

		return root;

	} // addToTreeI()


	// ##############################################################################################################
	public boolean isIdentical (BNode t1, BNode t2) {
		if ( (t1 == null) && (t2 == null) )
			return true;

		if ( (t1 != null) && (t2 == null)
				|| (t1 == null) && (t2 != null) )
			return false;

		if (t1.value != t2.value) {
			return false;
		} else {
			return ( isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right) );
		}

	}

	// ##############################################################################################################
	// find is t2 is a subtree of t1
	public boolean containsTree (BNode t1, BNode t2) {
		if (t2 == null) {
			return true;
		} else {
			return subTree(t1, t2);
		}
	} // containsTree()


	// ##############################################################################################################
	public boolean subTree(BNode t1, BNode t2) {
		if (t1 == null)
			return false;

		if (t1.value == t2.value) {
			return isIdentical(t1, t2);
		}

		return (subTree(t1.left, t2) || subTree(t1.right, t2) );

	} // subTree()

	// ##############################################################################################################
	public static BNode treeMinimum (BNode node) {
		if (node.left == null) return node;

		return treeMinimum(node.left);

	} // minKey()

	// ##############################################################################################################
	public static BNode treeMaximum (BNode node) {
		if (node.right == null) return node;

		return treeMaximum(node.right);

	} // minKey()

	// ##############################################################################################################
	/*	NOTE: Successor is the min from right subtree
	 * 	Case # 1: where right subtree is non-empty
	 * 			 Go right of the node and pick min from the right subtree
	 * 
	 * 	Case # 2: where right subtree is empty:
	 * 				Go to its parent node, such that the current node falls in the left subtree. That parent which is 
	 * 				greater than the current node and falls in the left subtree is the successor of the node.
	 */
	public static BNode treeSuccessor (BNode node) {

		if (node.right != null) {
			return treeMinimum(node.right);		// min value from the right subtree
		}

		BNode y = getParent(root, node);
		BNode x = node;

		// while (y != null) && (x != y.left) - Even this works
		while ( (y != null) && (x == y.right) ) {	// this statement turns false the moment "node" falls at left subtree of parent

			x = y;
			y = getParent(root, y);

		}

		return y;

	}

	public static BNode treePredecessor (BNode node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			return treeMaximum(node.left); 	// max value from the left subtree
		}

		BNode y = getParent(root, node);
		BNode x = node;
		while ( (y != null) && (x == y.left) ) { // turns false when "node" turns to be in the right subtree of its parent
			x = y;
			y = getParent(root, y);
		}

		return y;

	}

	// ##############################################################################################################
	public static BNode getParent (BNode tRoot, BNode node) { //int value

		BNode current = tRoot;     	// It takes the value of root which is a public value
		BNode parent = null;

		while(true){
			if (current == null)
				return null;

			if( current.value == node.value ) {
				break;
			}

			if (current.value > node.value) {
				parent = current;
				current = current.left;

			} else if (current.value < node.value) {
				parent = current;
				current = current.right;

			}

		}
		return parent;
	}


	// ##############################################################################################################
	// To DeleteNode() - deleting a given node:

	public static void DeleteNode (BNode node) {

		// case # 1: Where the node is a leaf node or where the node has no left subtree and no right subtree
		if ( ( node.left == null ) && ( node.right == null) ) {
			System.out.println("\n+ Case # 1: Deleting a leaf node: " + node.value);

			if ( (getParent(root, node) != null) && (getParent(root, node).left == node) ) {
				getParent(root, node).left = null;

			} else if ( (getParent(root, node) != null) && (getParent(root, node).right == node) ) {
				getParent(root, node).right = null;

			}

			// case # 2: where node has either a left child node or a right child node:
		} else if ( (node.left == null) || (node.right == null) ) {
			System.out.println("+ Case # 2: Deleting a node having 1 child/subtree");

			if (getParent(root, node) != null) {

				BNode x = ( node.left != null ) ? node.left : node.right;
				if (getParent(root, node).left == node) {
					getParent(root, node).left = x;

				} else {
					getParent(root, node).right = x;

				}

			} // if(getParent)


			// Case # 3: where node has a left subtree/child and a right subtree/child
		} else {
			System.out.println("+ Case # 3: Deleting a node having left subtree & right subtree +");

			BNode successor = treeSuccessor(node);
			BNode tempNode = successor;
			DeleteNode(successor);

			node.value = tempNode.value;

		} // end case # 3

	} // end DeleteNode()

	// ##############################################################################################################
	// Find the item to delete and then call the DeleteNode()
	public static void DeleteItem (BNode root, BNode node) {

		if (root == null) {	// return if the tree is empty.
			return;
		}

		if (node.value < root.value) {		// Go Left
			DeleteItem(root.left, node);

		} else if (node.value > root.value) {		// Go Right
			DeleteItem(root.right, node);

		} else if (node.value == root.value) {
			System.out.println("+++ FOUND: " + node.value);
			DeleteNode (node);
		}

	} // end DeleteItem();


	// ################################################################################################################
	// Reverse in-order traversal
	//
	// NOTE: This also prints data in descending order of the BST
	//
	public void reverseInOrder(BNode node) {

		if (node == null) return;	// base case for recursive run

		reverseInOrder(node.right);
		node.printValue();
		reverseInOrder(node.left);

	}	// reverseInOrder()


	// ################################################################################################################
	// Get the Kth - smallest element from the binary tree
	public void kthSmallestInBST(BNode node, int k) {

		Stack<BNode> resStack = new Stack<BNode>();
		BNode current = node;
		int tmp = k;

		while (resStack.size() > 0 || current != null) {
			if (current != null) {
				//System.out.println("+++ current: " + current.value);
				resStack.add(current);
				current = current.left;

			} else {
				current = resStack.pop();
				//System.out.println(" tmp: " + tmp);
				tmp--;

				if(tmp == 0) {
					System.out.println("+++ Kth: " + k + ", Smallest element is => "  + current.getValue());
					return;
				}

				current = current.right;
			}
		}

	}


	// ################################################################################################################
	// Get the Kth - largest element from the binary tree
	public void kthLargestInBST(BNode node, int k) {
		Stack<BNode> resStack = new Stack<BNode>();

		BNode current = node;
		int tmp = k;


		while(resStack.size() > 0 || current != null){
			if (current != null) {
				resStack.add(current);
				current = current.right;

			} else {
				current = resStack.pop();
				tmp--;

				if(tmp == 0){
					System.out.println("+++ Kth: " + k + ", Largest element is: "
							+ current.getValue());
					return;
				}

				current = current.left;
			}
		}

	}


	public static int FindKthSmallestElemet(BNode root, int k) {
		int count = 0;
		BNode current = root;

		while (current != null) {
			count++;
			current = current.left;
		}
		current = root;

		while (current != null)
		{
			if (count == k)
				return current.value;
			else
			{
				current = current.left;
				count--;
			}
		}

		return -1;


	} // end of function FindkThSmallestElemet



	/* #####################################################################################################################
	 * 1. We will first find out the path of the two nodes from root using recursive path finding algorithm. 
	 * 2. Now we will traverse simultaneously along the two paths till we find a mismatch. 
	 * 3. Then we know the size of the two paths, so we can easily calculate the distance by the formula, 
	 * 	  => length of path1 + length of path2 - 2*length of the common part
	 * 
	 */

	private static int findDistanceBtwn2Nodes(BNode root, int val1, int val2) {
		List<BNode> path1 = new ArrayList<BNode>();
		List<BNode> path2 = new ArrayList<BNode>();

		findPath(root, val1, path1);
		findPath(root, val2, path2);

		System.out.println("\n+ size-path1: " + path1.size() + " - " + "size-path2: " + path2.size());

		if (path1.size() == 0 || path2.size() == 0) {
			return -1;
		}

		int index = 0;
		for (; index < path1.size(); index++) {

			System.out.println(path1.get(index).value + " != " + path2.get(index).value);

			if (path1.get(index) != path2.get(index)) {
				break;
			}

		}

		System.out.println("\n + size-path1: " + path1.size() + " - " + "size-path2: " + path2.size() + " index: " + index);
		return path1.size() + path2.size() - 2 * index;

	}

	// method to fetch path to the given node
	private static boolean findPath(BNode root, int value, List<BNode> path) {
		if (root == null) {
			return false;
		}

		path.add(root);

		if (root.value == value) {
			return true;
		}

		if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
			return true;
		}

		path.remove(root);
		return false;

	}


	// #########################################################################################################
	// print the frame/perimeter of the BST
	public void print_frame(BNode root) {

		System.out.println("+++ Printing around the frame of the BST:");

		List<Integer> frame = new ArrayList<Integer>();

		if (root != null) {
			frame.add(root.value);

			print_frame_helper(root.left, true, false, frame);
			print_frame_helper(root.right, false, true, frame);

		}

		// print the frame list variable:
		String s = "{";
		for (Integer i : frame) {
			s += i + ", ";
		}
		s += "}";
		System.out.println(s);

	}

	// frame builder
	public void print_frame_helper(BNode node, Boolean left_edge, Boolean right_edge, List<Integer> framePath) {

		if (node != null) {
			if (left_edge) {
				System.out.println("+++ " + left_edge + " - " + right_edge + " +++");
				framePath.add(node.value);
			}


			print_frame_helper(node.left, true, false, framePath);

			//			if ((!left_edge) && (!right_edge)) {
			//				System.out.println("++++");
			//				if ((node.left == null) || (node.right == null)) {
			//					framePath.add(node.value);
			//				}
			//			}

			print_frame_helper(node.right, false, true, framePath);

			if (right_edge) {
				System.out.println("+++ " + left_edge + " - " + right_edge + " +++");
				framePath.add(node.value);
			}
		}
	}


	public BNode findLCA(BNode root, BNode p, BNode q) {

		// no root no LCA.
		if(root == null) {
			return null;
		}

		// if either p or q is the root then root is LCA.
		if(root == p || root==q) {
			return root;
		} else {
			// get LCA of p and q in left subtree.
			BNode l = findLCA(root.left , p , q);

			// get LCA of p and q in right subtree.
			BNode r = findLCA(root.right , p, q);

			// if one of p or q is in leftsubtree and other is in right
			// then root it the LCA.
			if(l != null && r != null) {
				return root;
			}
			else {		// else if l is not null, l is LCA.
				BNode temp = (l != null) ? l:r;
				return temp;
			}

		}
	}

	// ################################################################################################################
	// Get the Lowest Common Ancestor of 2 nodes
	// from the node, traverse up till the root node, see if the nodes match while traversing up
	public static BNode LCA(BNode root,BNode a,BNode b){
		BNode left = null, right = null;
		if(root==null) {
			return root;
		}
		if(root==a || root==b) {
			return root;
		}
		left=LCA(root.left,a,b);
		right=LCA(root.right,a,b);

		if(left!=null && right!=null) {
			return root;
		}
		return (left!=null)?left:right;
	}


	// ################################################################################################################
	// Get postOrderPredecessor()
	public BNode[] par_array = new BNode[100];
	public BNode postOrderPredecessor (BNode node) {

		if (node == null) {
			return null;
		}

		else {
			if (node.right != null) {
				return node.right; 	//	1. if the node has right child then return the right child
				//return treeMaximum(node.left); 	// max value from the left subtree
			}

			if (node.left != null) {
				return node.left; 	//	1. if the node has right child then return the right child
				//return treeMaximum(node.left); 	// max value from the left subtree
			}

			BNode y = getParent(root, node);
			BNode x = node;
			while ( (y != null) && (x == y.left) ) { // turns false when "node" turns to be in the right subtree of its parent
				x = y;
				y = getParent(root, y);
			}

			return y;

		}

	}


	public void leavesWithDepth(BNode node) {

		System.out.println("\n+++ Leaves at tree level/depth: ");

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> nodeList = new ArrayList<Integer>();
		int ht = treeHeight(node);


		for (int depth = 1; depth <= ht; depth++) {

			nodeList.clear();							// clear the list before iteration
			leavesByDepth(node, depth, nodeList);		// process leaf nodes

			if (!map.containsKey(depth)) {
				map.put(depth, new ArrayList<Integer>());
			}

			if (nodeList.size() == 0) {
				map.put(depth, null);
			} else {
				map.put(depth, nodeList);
			}

		}	// for()

		System.out.println("+ Leaf nodes at various levels: \n" + map.toString());

	}

	public static void leavesByDepth(BNode node, int depth, List<Integer> nodeList) {

		if (node == null)
			return;

		if (depth == 1) {
			if (node.left == null && node.right == null) {
				//System.out.println(node.value);
				nodeList.add(node.value);
			}
		}

		leavesByDepth(node.left, depth - 1, nodeList);
		leavesByDepth(node.right, depth - 1, nodeList);

	}	// leavesByDepth()


	// ##############################################################################################################
	// print all the node data at a given level/depth of a BST
	public void nodesByDepth(BNode node, int depth) {

		if (node == null)
			return;

		if (depth == 1) {
			System.out.println(node.value);
			return;
		}

		nodesByDepth(node.left, depth - 1);
		nodesByDepth(node.right, depth - 1);

	}


	// ################################################################################################
	// Count total leaf node of a binary tree
	public static int countLeafNodes(BNode node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			System.out.println(node.getValue());
			return 1;
		}

		return countLeafNodes(node.left) + countLeafNodes(node.right);
	}


	// ############################################################################################################
		/* 	BFS based printing nodes - printing nodes based on BSF technique
		 		BFS - Breadth First Search technique OR also called as level order traversal
		*/
	public void BFSPrint(BNode root) {
		System.out.println("\n+++ Printing Nodes By Breadth First Search: ");

		// base case
		if (root == null) {
			return;
		}

		// Queue to store data for BFS
		Queue<BNode> que = new LinkedList<BNode>();

		que.clear();	// clear the Queue first
		que.add(root);	// adding the first node to the Queue

		Map<Integer, List<Integer>> hashnodes = new HashMap<Integer, List<Integer>>();
		List<Integer> tmpList = new ArrayList<Integer>();
		tmpList.add(root.getValue());
		Integer level = 0;
		hashnodes.put(level, tmpList);

		while( !que.isEmpty() ) {
			tmpList = new ArrayList<Integer>();
			level++;
			BNode node = que.remove();

			System.out.print(node.value + " ");

			if(node.left != null) {
				que.add(node.left);
				tmpList.add(node.left.getValue());
			}

			if(node.right != null) {
				que.add(node.right);
				tmpList.add(node.right.getValue());
			}

			hashnodes.put(level, tmpList);

		}

		System.out.println(hashnodes);

	}	// end BFSPrint



	public List<BNode> treeLeaves(BNode root) {
		Queue<BNode> que = new LinkedList<BNode>();			// Queue to store data for BFS

		if (root == null) {
			return null;
		}

		List<BNode> leavesList = new ArrayList<BNode>();
		que.clear();							// clear the Queue first
		que.add(root);							// adding the first node to the Queue

		while( !que.isEmpty() ) {

			BNode node = que.remove();

			if (node.left == null & node.right == null) {
				//System.out.print("\n+++ Value: " + node.value);
				leavesList.add(node);
			}

			if(node.left != null) {
				que.add(node.left);
			}

			if(node.right != null) {
				que.add(node.right);
			}

		}

		return leavesList;

	}	// end BFSPrint



	Stack<BNode> myQueue = new Stack<BNode>();
	public void printNodesByLevelNull(BNode node) {

		if (node == null) {
			return;
		}

		int level = 1;
		myQueue.clear();							// clear the Queue first
		myQueue.add(node);
		myQueue.add(null);

		while (!myQueue.isEmpty()) {

			BNode tmp = myQueue.pop();

			if (tmp != null) {
				System.out.println(tmp.value);
			} else {
				tmp = myQueue.pop();
				System.out.println("null");
				level++;
			}

			if (tmp != null) {
				if (tmp.left != null) {
					myQueue.add(tmp.left);
				} else if (tmp.right != null) {
					myQueue.add(tmp.right);
				}

			}
		}



	}


} // end class
// ##############################################################################################################
