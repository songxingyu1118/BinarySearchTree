package cs1501_p1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

public class BSTTest {

	private BST<Integer> setup() {
		int[] puts = {5, 1, 10};
		BST<Integer> t = new BST<Integer>();

		for (int i: puts) {
			t.put(i);
		}

		for (int i: puts) {
			assertTrue(t.contains(i), "Cannot check, put/contains not working");
		}

		return t;
	}

	@Test
	public void pc() {
		BST<Integer> t = setup();

		assertTrue(t.contains(5), "Could not find 5");
	}

	@Test
	public void del() {
		BST<Integer> t = setup();

		t.delete(1);
		assertTrue(!t.contains(1), "Could not remove 1");
	}

	@Test
	public void height() {
		BST<Integer> t = setup();

		assertEquals(2, t.height(), "Tree with 5, 1, and 10 should be height 2, was height: " + String.valueOf(t.height()));
	}

	@Test
	public void bal() {
		BST<Integer> t = setup();

		assertEquals(true, t.isBalanced(), "Tree with 5, 1, then 10 inserted should be balanced");
	}

	@Test
	public void iot() {
		BST<Integer> t = setup();

		assertEquals("1:5:10", t.inOrderTraversal(), "Should produce \"1:5:10\"");
	}

	@Test
	public void serial() {
		BST<Integer> t = setup();
		
		assertEquals("R(5),L(1),L(10)", t.serialize(), "Should produce \"R(5),L(1),L(10)\"");
	}

	@Test
	public void rev() {
		BST<Integer> t = setup();

		BST<Integer> r = (BST<Integer>) t.reverse();
		assertEquals("R(5),L(10),L(1)", r.serialize(), "Should produce \"R(5),L(10),L(1)\"");
	}

	@Test
	public void submit() {
		assertTrue(true, "Somehow inproper submission flagged through testing?");
	}
}
