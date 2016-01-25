package triesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of Graph name structure
 *
 */

public class Graph {
	
	public GraphNode root;
	ArrayList<GraphNode> nodes;
	int[][] adjMatrix; // Adjacency Matrix
	boolean isDirected; // Graph directed?
	int size;

	public static final int DEFAULT_SIZE = 5; // default size

	public Graph(int data) {
		this(DEFAULT_SIZE, data);
	}

	/**
	 * Assuming there are Max five nodes in the graph
	 *
	 * This restriction can be removed by using adjList which grows dynamically
	 *
	 * @param root
	 */
	public Graph(int size, int data) {
		this.root = new GraphNode(data);
		nodes = new ArrayList<GraphNode>();
		nodes.add(root);
		this.size = size;
		adjMatrix = new int[size][size];
	}

	public void addNode(int data) {
		GraphNode node = new GraphNode(data);
		nodes.add(node);
	}

	public void connectNode(GraphNode g1, GraphNode g2) {
		int g1Idx = nodes.indexOf(g1);
		int g2Idx = nodes.indexOf(g2);
		if (g1Idx < 0 || g2Idx < 0)
			throw new NullPointerException("node not found");
		adjMatrix[g1Idx][g2Idx] = 1;
		if (!isDirected) {
			adjMatrix[g2Idx][g1Idx] = 1;
		}
	}

	/**
	 * get all nodes connected to the given node
	 *
	 * @param g
	 * @return
	 */
	public List<GraphNode> getAdjacents(GraphNode g) {
		int gIdx = nodes.indexOf(g);

		if (gIdx < 0)
			throw new NullPointerException("node not found in the graph");
		LinkedList<GraphNode> adjNodes = new LinkedList<GraphNode>();
		for (int j = 0; j < adjMatrix.length; j++) {
			if (adjMatrix[gIdx][j] == 1) {
				adjNodes.add(nodes.get(j));
			}
		}

		return adjNodes;
	}

	// Similarly implement remove edge
	public void removeEdge(GraphNode g1, GraphNode g2) {
		int g1Idx = nodes.indexOf(g1);
		int g2Idx = nodes.indexOf(g2);

		if(g1Idx<0 || g2Idx <0){
			throw new NullPointerException("GraphNode not found");
		}

		adjMatrix[g1Idx][g2Idx] = 0;
		if(!isDirected){
			adjMatrix[g2Idx][g1Idx] = 0;
		}
	}


	public static Set<Character> charPrecedence(String[] dictionary, char[] letters){
		Set<Character> result = new HashSet<Character>();

		//since your characters are the 26 letters instead of the 256 chars
		// a bit vector won't do; you need a map or set
		Set<Character> alphabets = new HashSet<Character>();

		for(char c: letters)
			alphabets.add(c);

		//now get to work
		for(String word: dictionary) {
			if(alphabets.isEmpty()) {
				return result;
			}

			for(char c: word.toCharArray()) {
				if(alphabets.remove(c)) {
					result.add(c);
				}
			}
		}
		//since the dictionary is guaranteed to contain all the 26 letters,
		//per the problem statement, then at this point your work is done.
		return result;
	}

	public static void main(String[] args) {
		//String[] dic = {"zebra", "apple", "cat", "crass"}; 
		String[] dic = {"cab", "adc", "dab"}; 
		char[] c = {'a', 'b', 'c', 'z'};
		Set<Character> res = charPrecedence(dic, c);
		System.out.println(res.toString());

		Arrays.sort(dic);
		for (String s: dic) {
			System.out.println(s);
		}

	}

}
