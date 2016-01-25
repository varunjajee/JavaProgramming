package com.muks.DSC.Graph.Testing;

/*
 * Created by mukthar.ahmed on 1/25/16.
 */


import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public char name;
    public List<Edge> edges;

    public Vertex parent;

    public boolean isVisited;

    // Node constructor
    public Vertex(char vertexValue) {
        this.name = vertexValue;
        this.edges = new ArrayList<>();
    }

    public String toString() {
        return "[" + name + "]";

    }

    public boolean addEdge(Vertex node, int weight) {
        if (hasEdge(node)) {
            return false;
        }
        Edge newEdge = new Edge(this, node, weight);
        return edges.add(newEdge);
    }

    public boolean removeEdge(Vertex node) {
        if (edges.contains(node)) {
            return edges.remove(node);
        }
        return false;
    }

    public boolean hasEdge() {
        return (edges.size() != 0);
    }

    public boolean hasEdge(Vertex node) {
        return edges.contains(node);
    }

    // Get all edges
    public List<Edge> edges() {
        return edges;
    }

    //ToDo:this may need improvisation (Static as of now, at declaration and usage is instance type)
    public int getEdgeCount() {
        return edges.size();
    }

    public Vertex parent() {
        return parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
}
