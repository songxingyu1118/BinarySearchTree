/**
 * Binary Tree Node class for CS1501 Project 1
 * @author	Dr. Farnan
 */
package cs1501_p1;

public class BTNode<T extends Comparable<T>> {
	
	/**
	 * Key held by this node
	 */
	private T key;

	/**
	 * Left child reference
	 */
	private BTNode<T> left;

	/**
	 * Right child reference
	 */
	private BTNode<T> right;

	/**
	 * Constructor that accepts the key to be held by the new node
	 */
	public BTNode(T k) {
		key = k;
	}

	/**
	 * Getter for the key
	 * 
	 * @return	Reference to the key
	 */
	public T getKey() {
		return key;
	}

	/**
	 * Getter for the left child
	 *
	 * @return	Reference to the left child
	 */
	public BTNode<T> getLeft() {
		return left;
	}

	/**
	 * Getter for the right child
	 *
	 * @return	Reference to the left child
	 */
	public BTNode<T> getRight() {
		return right;
	}

	/**
	 * Setter for the left child
	 *
	 * @param	l BTNode to set as the left child
	 */
	public void setLeft(BTNode<T> l) {
		left = l;
	}

	/**
	 * Setter for the right child
	 *
	 * @param	r BTNode to set as the right child
	 */
	public void setRight(BTNode<T> r) {
		right = r;
	}
}
