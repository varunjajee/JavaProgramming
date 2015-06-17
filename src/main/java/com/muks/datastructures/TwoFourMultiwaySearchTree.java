package datastructures;

public class TwoFourMultiwaySearchTree {
	/**
	 * NOTE:
	 * -----
	 * 2-4 Binary search tree of 2,3,4 multi way search tree is kind of binary tree but binary tree has 2 children at each node,
	 * with just one key and adhering to the search property (search property = children towards the left are with values less the the 
	 * parent node and children towards right are with values greater than the parent node).
	 *		whereas, the 2,4 or 2,3,4 multi-way search tree has the same search property each node can have "keys" d-1; where
	 * d - corresponds to its total children.
	 * 
	 * 2,3,4 tree always have nodes at keys = 1 less than the number of children that node has for a faster and a better searching technique
	 * 
	 * What are (2,4) Trees:
	 * Properties:
	 * -----------
	 * 	0. They adhere to the search property of binary trees
	 * 	1. Each node will have at most 4 nodes, either 2,3 or 4 children.
	 * 	2. Important properties, all the leaf nodes are the same level at each different nodes.
	 *  3. Height of the tree = log n to base 4
	 *  4. How fast is the search here
	 *  		=> O(3 log n) - coz, there could be nodes ranging from 1 to 3 nodes, i,e d-1, at max d=4 children as per rule of 2,3,4 tree
	 *  					  So, one would have to do n comparisons, 1st node/key, 2nd node/key or at max 3rd node/key
	 *  		=> so running n comparasions, O(3 log n) at a given node.
	 *  		=> why 3 log n, 3 is beacause it would a probability that I would have to compare with all 3 keys.
	 *  
	 *  5. Insertion in binary tree is => keep searching till we hit a null pointer and then insert
	 *  6. NOTE: While inserting, if all leaf nodes are full, then split the node into 2
	 *  	Eg: Inserting (29) at node 
	 *  		(25)
	 *			=> (26) (28) (30)
	 *			
	 *			Now;
	 *			=> inserting it to the leaf node as (26) (28) (29) (30) ; and then split the leaf into 2 nodes
	 *			=> { (26) (28) } & { (29) (30) }
	 *			=> And then promote either max key from left split or min key from right split.
	 *
	 *			(25) (28) or
	 *			=> { (26) (29) (30) }
	 *			=> adhering to the search property of a binary tree.
	 *			
	 *			OR 
	 *			(25) (29)
	 *			=> { (26) (28) (30) }
	 *			=> Again, adhering to the search property
	 *
	 *	7. Inserting, and we find if there is not space at leaf, and also no space at node, then the node gets split, 
	 *		till hit hits up and eventualy, we end up moving a the root node and increasing the "height" of the tree
	 *		=> Imp: in the example, the parent node is being split till it satisfies the search property.
	 *	
	 *	8. time taken for insertion = O(log n) node splits
	 *
	 * 	9. Deletion:
	 * 		(i) Case - 1: If its a leaf node, find the key and delete it (set it to null)
	 * 		(ii) Case - 2: If its a node, then find the predecessor and sawap it with the predecessor (how to find predecessor: go left,
	 * 			 and find the largest key at the left) and then remove the node as after swaping, it has become a leaf node.
	 * 
	 * 		NOTE: The predecessor here is going to be always a leaf node unlike in binary tree.
	 * 			  Reason: Because, 2,4 tree always if has a left child then will surely have a right child as well, hence it goes as leaf
	 * 
	 * 		(iii) If the deletion of leaf node and causes empty leafs then we borrow a node from a sibling.
	 * 				=> 	how this is done is by doing a left rotation. where the left child having 3 nodes, 1 remains at left,
	 * 					2 becomes to parent node and 3 goes to the right child, Again, adhering to the property of 2,4 trees with 
	 * 					no of nodes = d-1 (d is the no. of children nodes)
	 * 		
	 * 		(iv) At case where the key from left child is to be deleted, then borrowing left right siblings creates a log to juggle.
	 * 			So, "merge" is the solution here. 
	 * 			Merge the keys at leaf node, get 1 from parent node and then split it accordingly such that the search property still
	 * 			holds good. Here the parent node comes down.
	 * 			
	 * 			+++ Height of the tree got reduce by 1, in deletion.
	 * 
	 * 		+++ See Lecture - 13
	 * 
	 * 		Over, while in insertion, nodes get split and borrow from siblings and in deletion nodes get merged and borrow from parent.
	 * 
	 * 
	 * 
	 * 
	 *
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
