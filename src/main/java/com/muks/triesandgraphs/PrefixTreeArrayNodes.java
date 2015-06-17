//package triesandgraphs;
//
//public class PrefixTreeArrayNodes {
//
//	public static TrieNode createTree() {
//		return(new TrieNode('\0', false));	// create a root node, root is null always
//	}
//
//	// ######################################################################################################
//	public static void insertWord(TrieNode root, String word) {
//		int offset = 97;
//		int len = word.length();
//		char[] letters = word.toCharArray();
//		TrieNode curNode = root;
//
//		for (int i = 0; i < len; i++) {
//			if (curNode.children[letters[i]-offset] == null) {
//				curNode.children[letters[i]-offset] = new TrieNode(letters[i], i == len -1 ? true : false);
//			}
//			curNode = curNode.children[letters[i]-offset];
//
//		}
//	}
//
//	// ######################################################################################################
//	static boolean find(TrieNode root, String word) {
//		char[] letters = word.toCharArray();
//		int l = letters.length;
//		int offset = 97;
//		TrieNode curNode = root;
//
//		int i;
//		for (i = 0; i < l; i++)
//		{
//			if (curNode == null)
//				return false;
//			curNode = curNode.children[letters[i]-offset];
//		}
//
//		if (i == l && curNode == null)
//			return false;
//
//		if (curNode != null && !curNode.fullWord)
//			return false;
//
//		return true;
//	}
//
//	// ######################################################################################################
//	static void printTree(TrieNode root, int level, char[] branch) {
//		if (root == null)
//			return;
//
//		for (int i = 0; i < root.children.length; i++) {
//			branch[level] = root.letter;
//			printTree(root.children[i], level+1, branch);
//		}
//
//		if (root.fullWord) {
//			for (int j = 1; j <= level; j++)
//				System.out.print(branch[j]);
//			System.out.println();
//		}
//	}
//
//	// ######################################################################################################
//	public static void main(String[] args) {
//		TrieNode tree = createTree();
//
//		String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
//		for (int i = 0; i < words.length; i++)
//			insertWord(tree, words[i]);
//
//		char[] branch = new char[50];
//		printTree(tree, 0, branch);
//
////		String searchWord = "all";
////		if (find(tree, searchWord)) {
////			System.out.println("The word was found");
////		}
////
////		else {
////			System.out.println("The word was NOT found");
////		}
//	}
//
//	// ######################################################################################################
//}
