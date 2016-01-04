package com.muks.DSC.singlylinkedlist;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Created by mukthar.ahmed on 1/3/16.
 */
public class TestLinkedList {

    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        singlyLinkedList.insertDefault(1);
//        singlyLinkedList.insertDefault(2);
//        singlyLinkedList.insertDefault(3);
//        singlyLinkedList.insertDefault(4);

//        System.out.println(singlyLinkedList.toString());

        //System.out.println("Head: " + singlyLinkedList.head);   // get head
        //System.out.println("Tail: " + singlyLinkedList.tail);   // get tail

        //singlyLinkedList.deleteByDefault();
        //System.out.println(singlyLinkedList.toString());

        //System.out.println("+ Size: " + singlyLinkedList.size(singlyLinkedList.head));

        //singlyLinkedList.addNodeAfter(singlyLinkedList, 2, 9);
        //singlyLinkedList.deleteHead(singlyLinkedList);
        //System.out.println(singlyLinkedList.toString());



        /* Create linked list out of a array list */
        ArrayList<Object> values1 = new ArrayList<Object>(Arrays.asList(1, 2, 3, 4, 5, 6));

        SinglyLinkedList mainList = new SinglyLinkedList(values1);
        //SinglyLinkedList.reverse(mainList);

        mainList.recursiveReverse(mainList.head);
        System.out.println("+ Reversed linked list => " + mainList.toString());


//        ArrayList<Object> values2 = new ArrayList<Object>(Arrays.asList('a', 'b', 'c'));
//        SinglyLinkedList subList = new SinglyLinkedList(values2);
//
//        System.out.println(subList.toString());
//
//        SinglyLinkedList.makeIntersectingList(mainList, subList, 3); // force intersect lists
//        SinglyLinkedList.getIntersectionPoint(mainList, subList); // find intersection


    }

}
