package com.muks.DSC.SinglyLinkedList;

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

        //singlyLinkedList.deleteDefault();
        //System.out.println(singlyLinkedList.toString());

        //System.out.println("+ Size: " + singlyLinkedList.size(singlyLinkedList.head));

        //singlyLinkedList.addNodeAfter(singlyLinkedList, 2, 9);
        //singlyLinkedList.deleteHead(singlyLinkedList);
        //System.out.println(singlyLinkedList.toString());



//        /* Create linked list out of a array list */
//        ArrayList<Object> values1 = new ArrayList<Object>(Arrays.asList(1, 3, 9, 4, 5, 3, 7, 7));
//
//        SinglyLinkedList mainList = new SinglyLinkedList(values1);
        //SinglyLinkedList.reverse(mainList);

        //mainList.recursiveReverse(mainList.head);
        //System.out.println("+ Reversed linked list => " + mainList.toString());

        //System.out.println("Tail node: " + SinglyLinkedList.findTailRecursively(mainList.head));


//        ArrayList<Object> values2 = new ArrayList<Object>(Arrays.asList('a', 'b', 'c'));
//        SinglyLinkedList subList = new SinglyLinkedList(values2);
//
//        System.out.println(subList.toString());
//
//        SinglyLinkedList.makeIntersectingList(mainList, subList, 3); // force intersect lists
//        SinglyLinkedList.getIntersectionPoint(mainList, subList); // find intersection



        //SinglyLinkedList.circularLinkedListMeetingPoint(mainList);
        //SinglyLinkedList.makeCyclicLinkedList(mainList.head, 3);

        //System.out.println(mainList.toString());
        //SinglyLinkedList.circularLinkedListMeetingPoint(mainList);

        //SinglyLinkedList.segregateEvenAndOdd(mainList);
        //SinglyLinkedList.evenAndOdd(mainList);

//         /* Create linked list out of a array list */
//        ArrayList<Object> values1 = new ArrayList<Object>(Arrays.asList(1, 2, 3, 4));
//        SinglyLinkedList mainList = new SinglyLinkedList(values1);
//
//        ArrayList<Object> values2 = new ArrayList<Object>(Arrays.asList(5, 6, 7, 8));
//        SinglyLinkedList subList = new SinglyLinkedList(values2);


//        System.out.println(SinglyLinkedList.mergeSortedList(mainList, subList));
//        System.out.println(
//                "+ Merged: "
//                        + SinglyLinkedList.recursiveMergeSortedList(mainList.head,
//                subList.head).toString());
//
//        SinglyLinkedList.mergeLinkedListRecursion(mainList, subList);
//        SinglyLinkedList.rotateList(mainList, 4);
//
//        SinglyLinkedList.SortLinkedlist(mainList);




//        //CNode res = SinglyLinkedList.MergeSortedLists(mainList.head, subList.head);
//        CNode res = SinglyLinkedList.MergeSortedListsRecursive(mainList.head, subList.head);
//
//        StringBuilder sb = new StringBuilder("\nDisplay LinkedList: [ -HEAD -> ");
//        while ( res != null ) {
//            sb.append(res.data + " -> ");
//            res = res.next;
//        }
//
//        sb.append("NULL");
//
//        System.out.println(sb.toString() + "- ]");
//
//




        ArrayList<Object> values11 = new ArrayList<Object>(Arrays.asList(9, 2, 1, 4));
        SinglyLinkedList mainList1 = new SinglyLinkedList(values11);

        ArrayList<Object> values22 = new ArrayList<Object>(Arrays.asList(5, 8, 7, 6));
        SinglyLinkedList subList2 = new SinglyLinkedList(values22);

         SinglyLinkedList.merge1(mainList1.head, subList2.head);


    }

}
