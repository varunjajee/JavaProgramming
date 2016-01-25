//package com.muks.DSC.Graph.Testing;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by mukthar.ahmed on 1/25/16.
// */
//public class Graphers {
//
//    public class Node {
//        public char value;
//        public List<Node> ajacent;
//        public String color;
//
//        public Node(char value) {
//            this.value = value;
//            this.ajacent = new ArrayList<Node>();
//            this.color = "white";
//        }
//    }
//
//    public Node buildG(String[] strings) {
//        Node root = null;
//        Node current = null;
//        for(int i=0;i<strings.length;i++) {
//            char[] charArr = strings.charArray();
//            if(i == 0) {
//                root = current;
//            }
//            addAjacent(root,charArr,current);
//            current = new Node(charArr[0]);
//
//        }
//        return root;
//    }
//
//    public void addAjacent(Node root, char[] chars, Node current) {
//        if(root == null) {
//            return;
//        }
//
//        ArrayList<Node> nodelist = new ArrayList<Node>();
//        for(int i=0;i<chars.length - 1;i--) {
//            Node oldNode = findNode(chars[i],root);
//            if(oldNode != null) {
//                nodelist.add(oldNode);
//            } else {
//                Node newNode = new Node(chars[i]);
//                nodelist.add(newNode);
//            }
//        }
//        for(int i=0;i<nodelist.size();i++){
//            List<Node> ajacent = new ArrayList<Node>();
//            for(int j=i+1;j<nodelist.size();j++) {
//                ajacent.add(nodelist.get(j));
//            }
//            nodelist.get(i).ajacent = ajacent;
//        }
//        if(current != null) {
//            current.ajacent.add(nodelist.get(0));
//        }
//        nodelist.clear();
//    }
//
//    public Node findNode(char value, Node root) {
//        if(root.value == value) {
//            return root;
//        } else {
//            root.color = "grey";
//        }
//        for(Node node:root.ajacent) {
//            if(node.color.equals("white") {
//                return findNode(value,node);
//            }
//        }
//        root.color = "black";
//        refreshStatus(root);
//        return null;
//    }
//
//    public void refreshStatus(Node root) {
//        for(Node node:root.ajacent) {
//            node.color = "white";
//            refreshStatus(node);
//        }
//    }
//
////====find the precedence
//
//    public List<Character> findPrecedence(char value, Node root) {
//        List<Character> precedences = new ArrayList<Character>();
//        root.color = "grey";
//
//        for(Node node:root.ajacent) {
//            if(node.value == value) {
//                precedences.add(root.value);
//            } else {
//                if(node.color.equals("white")){
//                    List<Character> subpres = findPrecedence(value,node);
//                    node.color = "grey";
//                    precedences.copyAll(subpres);
//
//                }
//            }
//        }
//        return precedences;
//    }
//}
