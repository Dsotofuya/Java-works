package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyListTest {

	@Test
	void test() {
		MyList list = new MyList();
		list.addNode(new Node("A"));
		list.addNode(new Node("B"));
		list.addNode(new Node("C"));
		list.addNodeToHead(new Node("D"));
		list.addNodeToHead(new Node("E"));
		list.addNode(new Node("Z"));
		assertEquals("E", list.getFirst().getData());
	}
	
	@Test
	void testAddNextTo() {
		MyList list = new MyList();
		list.addNode(new Node("A"));
		Node b = new Node("B");
		list.addNode(b);
		list.addNode(new Node("C"));
		list.addNodeNextTo(b, new Node("X"));
		assertEquals("X", b.getNext().getData());
	}
}