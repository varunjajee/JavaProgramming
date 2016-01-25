package com.muks.DSC.Graph.Testing;

import java.util.List;

/**
 * Created by mukthar.ahmed on 1/25/16.
 */
public class Test {


    public static void main(String[] args) {
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

        graph.print();

        graph.addEdge('a', 'b');
        graph.addEdge('a', 'd');
        graph.addEdge('a', 'g');
        graph.addEdge('b', 'e');
        graph.addEdge('b', 'f');
        graph.addEdge('e', 'g');
        graph.addEdge('g', 'a');
        graph.addEdge('g', 'z');
        graph.addEdge('d', 'f');
        graph.addEdge('f', 'c');
        graph.addEdge('c', 'h');

//        for (Vertex v : graph.vertices) {
//            if (v.hasEdge()) {
//                for (Edge e : v.edges()) {
//                    System.out.println(e.fromNode() + " -> " + e.toNode() );
//                }
//            }
//        }


        graph.runBFS('a');
        List<Vertex> path = graph.shortestPath('a', 'z');
        System.out.println("\n+ " + path.toString());


    }
}
