package com.muks.DSC.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Created by mukthar.ahmed on 1/25/16.
 */
public class Graph {
    private int edgeCount;
    //    private Map<Character, List<Edge>> vertices;
    List<Vertex> vertices;

    public Graph(int numOfVertices) {
        vertices = new ArrayList<>();
    }

    public void print() {
        StringBuilder sb = new StringBuilder("(");
        for (int v = 0; v < vertices.size(); v++) {
            sb.append(vertices.get(v).toString());
            if (v != vertices.size()-1) sb.append(", ");
        }
        sb.append(")");
        System.out.println(sb.toString());
    }

    /**
     * Adds a vertexVal to the graph.
     *
     * @param vertexVal vertexVal to add
     */
    public boolean addVertex(char vertexVal) {
        vertices.add(new Vertex(vertexVal));
        return true;
    }

    /**
     * Adds a directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     */
    public boolean addEdge(char vertex1, char vertex2) {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @param weight  weight of the edge
     */
    public boolean addEdge(char vertex1, char vertex2, int weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        Vertex node1 = getVertex(vertex1);
        Vertex node2 = getVertex(vertex2);

        // adding inter-pointer edges makes a undirected graph
        node1.addEdge(node2, weight);
        return node2.addEdge(node1, weight);
    }


    public Vertex getVertex(char vertexVal) {
        for (int i = 0; i < vertices.size(); i ++) {
            if (vertices.get(i).name == vertexVal) {
                return vertices.get(i);
            }
        }

        return null;
    }

    /**
     * Method to check if a vertex exists in the graph.
     *
     * @param vertex vertex which is to be checked
     * @return returns true if the graph contains the vertex, false otherwise
     */
    public boolean containsVertex(char vertex) {
        boolean found = false;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).name == vertex) {
                found = true;
            }
        }
        return found;
    }



    public void runBFS(char startVertex) {
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        // reset the graph
        resetGraph();

        // init the queue
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = getVertex(startVertex);
        queue.add(start);

        System.out.print(" -  " + start);

        // explore the graph
        while (!queue.isEmpty()) {
            Vertex first = queue.remove();
            //System.out.println("+ Size = " + queue.size());

            first.setVisited(true);

            for (Edge edge : first.edges()) {
                Vertex neighbour = edge.toNode();

                //System.out.println("+ Neighbour = " + neighbour + " -> " + neighbour.toString());
                if (!neighbour.isVisited) {
                    neighbour.isVisited = true;

                    System.out.print(" " + neighbour);

                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            }

        }
    }


    /**
     * Method to get the shortest path from startVertex to endVertex.
     * @param startVertex   vertex where the path begins
     * @param endVertex     vertex where the path ends
     * @return  list of vertices in the shortest path from startVertex to endVertex,
     *          null if no such path exists.
     */

    public List<Vertex> shortestPath(char startVertex, char endVertex) {
        // if nodes not found, return empty path
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            return null;
        }

        // run bfs on the graph
        runBFS(startVertex);

        List<Vertex> path = new ArrayList<>();

        // trace path back from end vertex to start
        Vertex end = getVertex(endVertex);
        while (end != null && end != getVertex(startVertex)) {
            path.add(end);
            end = end.parent();
        }
        // if end is null, node not found
        if (end == null) {
            return null;
        }
        else {
            path.add(end);
            Collections.reverse(path);
        }

        return path;
    }


    private void resetGraph() {
        for (Vertex vertex : vertices) {
            vertex.setParent(null);
            vertex.setVisited(false);
        }
    }
}
