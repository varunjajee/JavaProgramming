//package graphs;
//
//import java.util.ArrayList;
//
///**
// * Created by mukthar.ahmed on 13/05/14.
// */
//public class Graph<E>{
//
//    //Because we will need random access to the Edges
//    //We will use an ArrayList to hold them
//    private ArrayList<Edge<E>> edges;
//
//    public Graph(){
//        edges = new ArrayList<Edge<E>>();
//    }
//
//    //add Edge to the List
//    public boolean addEdge(Edge<E> vertex){
//        if(edges.contains(vertex)) return false;
//        edges.add(vertex);
//        return true;
//    }
//
//    public boolean contains(Edge<E> vertex){
//        return edges.contains(vertex);
//    }
//
//    public Edge<E> get(int index){
//        return edges.get(index);
//    }
//
//    //returns number of Edges in Graph
//    public int count(){return edges.size();}
//
//    public boolean equals(Graph<E> other){
//
//        if(other.edges.size() != edges.size())
//            return false;
//
//        //store all of Edges of larger Graph
//        ArrayList<Edge<E>> temp = new ArrayList<Edge<E>>(other.edges);
//
//        //if temp changed, then the Graphs are not equal
//        return temp.retainAll(edges);
//    }
//}
//
