package com.muks.DSC.Graph;

/*
 * Created by mukthar.ahmed on 1/25/16.
 */


public class Edge {
    public Vertex vertex1;
    public Vertex vertex2;

    public int weight;

    private static int edgeCount;       // ToDo: this may need improvisation

    public Edge() {}

    public Edge(Vertex vertex1, Vertex vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        edgeCount++;
    }

    public Vertex fromNode() {
        return vertex1;
    }

    public Vertex toNode() {
        return vertex2;
    }

    public boolean isBetween(Vertex node1, Vertex node2) {
        return (this.vertex1 == node1 && this.vertex2 == node2);
    }
}
