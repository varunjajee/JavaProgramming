/**
 * 
 */
package datastructures;

/**
 * @author muktharahmed
 * Growable array stacks.
 * 
 * We have 2 stratergy:
 * 1. Tight stratergy: 
 * 		If the size of the stack is N, then I create a new array of lenght f(N), copy all the elements of original stack 
 * 		into new stack and then rename the new stack with the older stacks name
 * 
 * 		Here we always increament the size of the array by a constant f(N) + C (constant size)
 * 
 * 2. growth stratergy:
 * 		Here we simple double the size of the stack.
 *
 *
 *
 */
public interface Stack {

	void print(String text);

}
