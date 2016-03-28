package com.muks.DSC.Stack;

import java.util.*;

/**
 * Created by mukthar.ahmed on 3/27/16.
 */
public class SyntaxBalanceCheck {

    public static void main(String[] args) {
        String input = "[{()}]";
        String input2 = "[{()]";

        System.out.println(checkBalanced(input));

    }

    static boolean checkBalanced(String str) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                switch (ch) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;

                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;

                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }

                    default:
                        break;
                }

            }
        }

        return (stack.isEmpty());
    }

}
