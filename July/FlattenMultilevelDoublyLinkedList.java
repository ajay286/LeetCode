package com.serverless.July;

import java.util.LinkedList;
import java.util.Stack;

//Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node(int val, Node prev, Node next, Node child) {
		super();
		this.val = val;
		this.prev = prev;
		this.next = next;
		this.child = child;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

};

public class FlattenMultilevelDoublyLinkedList {
	LinkedList<Node> resultList = new LinkedList<Node>();

	public Node flatten(Node head) {

		if (head == null)
			return head;

		Stack<Node> stack = new Stack<Node>();
		stack.add(head);

		Node iter;

		while (!stack.isEmpty()) {
			iter = stack.pop();
			while (iter != null) {
				if (iter.child == null) {
					resultList.add(iter);
					iter = iter.next;
					continue;
				} else {
					resultList.add(iter);
					stack.add(iter.next);
					iter = iter.child;
					continue;
				}
			}

		}
		
		Node current = null, previous = null;
		for (int i = 0; i < resultList.size(); ++i) {
			if (i ==0)
			{
				head = resultList.get(i);
				head.prev = null;
				head.child = null;
				continue;
			}
			
			previous = resultList.get(i-1);
			current = resultList.get(i);
			previous.next = current;
			current.prev = previous;
			current.child = null;
			
		}
		
		current.next = null;

		return head;
	}

	public static void main(String[] args) {
		Node three = new Node(3, null, null, null);
		Node two = new Node(2, null, null, null);
		Node head = new Node(1, null, null, null);
		two.setPrev(head);
		head.setChild(three);
		head.setNext(two);

		FlattenMultilevelDoublyLinkedList solDoublyLinkedList = new FlattenMultilevelDoublyLinkedList();
		solDoublyLinkedList.flatten(head);

	}

}
