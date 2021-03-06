/**
 * 
 */
package com.muks.DSC.Random;

/**
 * @author muktharahmed
 * Growable array stacks.
 * 
 * We have 2 stratergy:
 * 1. Tight stratergy: 
 * 		If the size of the Stack is N, then I create a new array of lenght f(N), copy all the elements of original Stack
 * 		into new Stack and then rename the new Stack with the older stacks name
 * 
 * 		Here we always increament the size of the array by a constant f(N) + C (constant size)
 * 
 * 2. growth stratergy:
 * 		Here we simple double the size of the Stack.
 *
 *
 *
 */
public interface Stack {

	void print(String text);

}
