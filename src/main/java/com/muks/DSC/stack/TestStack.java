package com.muks.DSC.stack;

/*
 * Created by mukthar.ahmed on 1/1/16.
 */
public class TestStack {

    public static void main(String[] args) {
        Stack stack = new Stack(4);

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);


            System.out.println("+ Size=" + stack.getSize());
            stack.display(stack);

//            System.out.println("+ Pop'd # 1 = " + stack.pop());
//            System.out.println("+ Pop'd # 2 = " + stack.pop());
//            System.out.println("+ Pop'd # 3 = " + stack.pop());
//            System.out.println("+ Pop'd # 4 = " + stack.pop());
            //System.out.println("+ Pop'd # 5 = " + stack.pop());

        } catch (Exception e) {
            e.printStackTrace();
        }


        String str = "mukthar";
        Stack nameStack = new Stack(str.length());
        char[] arr = str.toCharArray();
        for (char c : arr) {
            try {
                nameStack.push(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        nameStack.display(nameStack);

    }
}
