package com.muks.trail_here;


import sun.java2d.loops.GraphicsPrimitive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Testing {

    public static void main(String[] args) {
        String test_good = "()(){}{}{()}";
        System.out.println("+ " + checkBalanced(test_good) );

    }
    public static boolean checkBalanced(String check) {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < check.length(); a++)
        {
            char let = check.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    // Opening curly brace
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    // Opening paren brace
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }
}