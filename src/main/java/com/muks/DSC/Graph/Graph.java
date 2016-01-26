package com.muks.DSC.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    public boolean addEdge(char vertex1, char vertex2, boolean isDirectedGraph) {
        return addEdge(vertex1, vertex2, 0, isDirectedGraph);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     *
     * @param vertex1 vertex where the (directed) edge begins
     * @param vertex2 vertex where the (directed) edge ends
     * @param weight  weight of the edge
     */
    public boolean addEdge(char vertex1, char vertex2, int weight, boolean isDirectedGraph) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        Vertex node1 = getVertex(vertex1);
        Vertex node2 = getVertex(vertex2);

        if (isDirectedGraph) {
            // adding definative inter-pointer edges makes a undirected graph
            return node1.addEdge(node2, weight);
        } else {
            node1.addEdge(node2, weight);
            return node2.addEdge(node1, weight);
        }
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
        System.out.println("+ Running Breadth First: ");
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        // reset the graph
        resetGraph();

        // init the queue
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = getVertex(startVertex);
        queue.add(start);

        System.out.print(" " + start);

        // explore the graph
        while (!queue.isEmpty()) {
            Vertex first = queue.remove();

            first.setVisited(true);

            for (Edge edge : first.edges()) {
                Vertex neighbour = edge.toVertex();

                //System.out.println("\n+ Neighbour = " + neighbour.toString());
                if (!neighbour.isVisited) {
                    neighbour.isVisited = true;

                    System.out.print(" -> " + neighbour);

                    // parent here is established for shortest path algo
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            }

        }
    }


    // Use a stack for the iterative DFS version
    public void runDepthFirst(char s) {
        boolean[] visited = new boolean[vertices.size()];
        Stack<Vertex> st = new Stack<>();

        resetGraph();
        Vertex sv = getVertex(s);
        st.push(sv);

        while (!st.isEmpty()) {
            Vertex v = st.pop();

            if (!v.isVisited) {
                v.isVisited = true;

                System.out.print(v + " -> ");
                // auxiliary stack to visit neighbors in the order they appear
                // in the adjacency list
                // alternatively: iterate through ArrayList in reverse order
                // but this is only to get the same output as the recursive dfs
                // otherwise, this would not be necessary
                Stack<Vertex> auxStack = new Stack<>();

                for (Edge e : v.edges()) {
                    Vertex nextV = e.toVertex();
                    if (!nextV.isVisited) {
                        auxStack.push(nextV);
                    }
                }
                while (!auxStack.isEmpty()) {
                    //System.out.println("+ peek - " + auxStack.peek());
                    st.push(auxStack.pop());
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
        System.out.println("\n\n+ Shortest path algorithm +");

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


    // A recursive function used by topologicalSort
    void topologicalSortUtil(char ch, Stack<Vertex> stack) {
        // Mark the current node as visited.
        Vertex curentVertex = getVertex(ch);
        curentVertex.isVisited = true;

        for (Edge edge : curentVertex.edges()) {
            Vertex neighbour = edge.toVertex();

            if (!neighbour.isVisited) {
                topologicalSortUtil(neighbour.name, stack);
            }
        }

        // Push current vertex to stack which stores result
        stack.push(curentVertex);
    }

    // The function to do Topological Sort. It uses recursive
    // topologicalSortUtil()
    void topologicalSort() {
        Stack<Vertex> stack = new Stack<>();

        // Mark all the vertices as not visited
        resetGraph();

        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < vertices.size(); i++)
            if (!vertices.get(i).isVisited)
                topologicalSortUtil(vertices.get(i).name, stack);

        // Print contents of stack
        while (stack.empty() == false) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void resetGraph() {
        for (Vertex vertex : vertices) {
            vertex.setParent(null);
            vertex.setVisited(false);
        }
    }
}
