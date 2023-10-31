/**
 * Binary Search Tree specification interface for CS1501 Project 1
 * @author	Dr. Farnan
 */
package cs1501_p1;

interface BST_Inter<T extends Comparable<T>> {

	/**
	 * Add a new key to the BST
	 *
	 * @param 	key Generic type value to be added to the BST
	 */
	public void put(T key);

	/**
	 * Check if the BST contains a key
	 *
	 * @param	key Generic type value to look for in the BST
	 *
	 * @return	true if key is in the tree, false otherwise
	 */
	public boolean contains(T key);

	/**
	 * Remove a key from the BST, if key is present
	 * 
	 * @param	key Generic type value to remove from the BST
	 */
	public void delete(T key);

	/**
	 * Determine the height of the BST
	 *
	 * <p>
	 * A single node tree has a height of 1, an empty tree has a height of 0.
	 *
	 * @return	int value indicating the height of the BST
	 */
	public int height();

	/**
	 * Determine if the BST is height-balanced
	 *
	 * <p>
	 * A height balanced binary tree is one where the left and right subtrees
	 * of all nodes differ in height by no more than 1.
	 *
	 * @return	true if the BST is height-balanced, false if it is not
	 */
	public boolean isBalanced();

	/**
	 * Produce a ':' separated String of all keys in ascending order
	 *
	 * <p>
	 * Perform an in-order traversal of the tree and produce a String
	 * containing the keys in ascending order, separated by ':'s.
	 * 
	 * @return	String containing the keys in ascending order, ':' separated
	 */
	public String inOrderTraversal();

	/**
	 * Produce String representation of the BST
	 * 
	 * <p>
	 * Perform a pre-order traversal of the BST in order to produce a String
	 * representation of the BST. The reprsentation should be a comma separated
	 * list where each entry represents a single node. Each entry should take
	 * the form: *type*(*key*). You should track 4 node types:
	 *     `R`: The root of the tree
	 *     `I`: An interior node of the tree (e.g., not the root, not a leaf)
	 *     `L`: A leaf of the tree
	 *     `X`: A stand-in for a null reference
	 * For each node, you should list its left child first, then its right
	 * child. You do not need to list children of leaves. The `X` type is only
	 * for nodes that have one valid child.
	 * 
	 * @return	String representation of the BST
	 */
	public String serialize();

	/**
	 * Produce a deep copy of the BST that is reversed (i.e., left children
	 * hold keys greater than the current key, right children hold keys less
	 * than the current key).
	 *
	 * @return	Deep copy of the BST reversed
	 */
	public BST_Inter<T> reverse();
}
