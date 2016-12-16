package com.muks.DSC.BinaryTree.RedBlackAndAvLTrees;

/**
 * Created by mukthar.ahmed on 3/21/16.
 *
 * Difference between red-black and Avl Trees
 *  - Both are height balanced trees
 *
 *  - Avl tree - Look up is faster but comes with a cost of insertions. Insertions & deletions are slow as due to
 *  more number of rotations required while insertions/deletions.
 *
 *  Insertions:
 *      - Insertions are faster in red-black tree since there are less number of rotations when compared to Avl
 *
 *  Look up:
 *      - Avl is faster since the height/depth is lesser when compared to R-B trees.
 *
 *  Delete
 *      - RB tree has O(Log N) times of rotation in worst case but not Avl. Hence RB tree is faster
 *
 *
 *
 *  For large data sets:
 *
 *  Insert: AVL tree is faster. because you need to lookup for a particular node before insertion. as you have more
 *      data the time difference on looking up the particular node grows proportional to O(log N). but AVL tree & RB
 *      tree still only need constant number of rotation at the worst case. Thus the bottle neck will become the time
 *      you lookup for that particular node.
 *
 *  Lookup:
 *      AVL tree is faster. (same as in small data case)
 *
 *  Delete:
 *      AVL tree is faster on average, but in worst case RB tree is faster. because you also need to lookup for a
 *  very deep node to swap before removal (similar to the reason of insertion). on average both trees has constant
 *  number of rotation. but RB tree has a constant upper bound for rotation.
 */
public class RedblackAndAvlTrees {
}
