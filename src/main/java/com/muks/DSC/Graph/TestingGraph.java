package com.muks.DSC.Graph;

/*
    Created by mukthar.ahmed on 1/25/16.

    Note:
        The grpah built and used in below example is from Graph traversal tutorials video

    Code ex: http://codereview.stackexchange.com/questions/67970/graph-implementation-in-java-8

 */
public class TestingGraph {


    public static void main(String[] args) {

        /*
    // Question: Design DFS and BFS using a undirected graph.
        Graph graph = new Graph(5);

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('h');
        graph.addVertex('z');

        //graph.print();

        boolean isDirectedGraph = false;
        graph.addEdge('a', 'b', isDirectedGraph);
        graph.addEdge('a', 'd', isDirectedGraph);
        graph.addEdge('a', 'g', isDirectedGraph);
        graph.addEdge('b', 'e', isDirectedGraph);
        graph.addEdge('b', 'f', isDirectedGraph);
        graph.addEdge('e', 'g', isDirectedGraph);
        graph.addEdge('g', 'a', isDirectedGraph);
        graph.addEdge('g', 'z', isDirectedGraph);
        graph.addEdge('d', 'f', isDirectedGraph);
        graph.addEdge('f', 'c', isDirectedGraph);
        graph.addEdge('c', 'h', isDirectedGraph);

//        for (Vertex v : graph.vertices) {
//            if (v.hasEdge()) {
//                for (Edge e : v.edges()) {
//                    System.out.println(e.fromVertex() + " -> " + e.toVertex() );
//                }
//            }
//        }

        System.out.println("\n\n BFS: ");
        graph.runBFS('a');

        System.out.println("\n\n DFS: ");

        graph.runDepthFirst('a');

        List<Vertex> path = graph.shortestPath('a', 'z');
        System.out.println("\n+ Shortest path from a -> z " + path.toString());

*/


        // Question: Get character precedence of a given sorted dictionary using graph

        Graph graph = new Graph(256);
        String[] wordsArray = {"caa", "aaa", "aab"};
        DagFromWords(graph, wordsArray[0], wordsArray[1]);
        DagFromWords(graph, wordsArray[1], wordsArray[2]);

        System.out.println("+ Breadth First Search = ");
        graph.runBFS('c');

        System.out.println("\n\n+ Topological sorting = ");
        graph.topologicalSort();



    }

    public static void DagFromWords(Graph graph, String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                graph.addVertex(word1.charAt(i));
                graph.addVertex(word2.charAt(i));

                graph.addEdge(word1.charAt(i), word2.charAt(i), true);
            }
        }

    }
}
