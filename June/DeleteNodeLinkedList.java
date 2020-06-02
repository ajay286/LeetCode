/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9],
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x, ListNode next) {
		val = x;
		this.next = next;
	}
}

public class DeleteNodeLinkedList {

	public void deleteNode(ListNode node) {
		ListNode prev = node;
		while (node.next != null) {
			node.val = node.next.val;
			prev = node;
			node = node.next;
		}
		prev.next = null;
	}

	public void traversal(ListNode node) {
		System.out.print("Traversal -> {");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println("}\n");

	}

	public static void main(String[] args) {

		ListNode nodeToDelete = new ListNode(5, new ListNode(1, new ListNode(9, null)));
		ListNode node = new ListNode(4, nodeToDelete);

		DeleteNodeLinkedList solution = new DeleteNodeLinkedList();
		solution.traversal(node);
		System.out.println(String.format("Going to delete node -> %s \n", nodeToDelete.val));
		solution.deleteNode(nodeToDelete);
		solution.traversal(node);

	}

}
