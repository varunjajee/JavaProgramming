package com.muks.DSC.DoublyLinkedList;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */
public class TestDoublyLinkedList {
    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDefault(1);
        doublyLinkedList.insertDefault(2);
        doublyLinkedList.insertDefault(3);
        doublyLinkedList.insertDefault(4);

//        System.out.println("+ List: " + doublyLinkedList.toString());
//        DoublyLinkedList.reverseDLL(doublyLinkedList);
//        System.out.println("+ size = " + doublyLinkedList.getSize());

        doublyLinkedList.DeletingNodeByVal(3);
        System.out.println(doublyLinkedList.toString() );



    }
}
