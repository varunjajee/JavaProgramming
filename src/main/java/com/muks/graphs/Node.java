package graphs;

import java.util.LinkedList;

/**
 * Created by mukthar.ahmed on 16/04/14.
 */


class Node {
    private String cityname;
    private LinkedList<Node> connects;

    Node(String cityname) {
        this.cityname = cityname ;
        this.connects = new LinkedList<Node>();
    }

    void addEdge(Node toNode) {
        this.connects.add(toNode);
    }

}
