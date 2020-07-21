class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode iter = head, prev = head;
		
		while ( iter != null) {
			
			if (head == iter && iter.val == val) {
				head = iter.next;
				prev = iter.next;
				iter = iter.next;
				continue;
			}
			
			if (iter.val != val) {
				prev = iter;
				iter = iter.next;
			}
			else {
				prev.next = iter.next;
				iter = iter.next;
			}
				
		}
		
		return head;

	}
	
	public void traverse(ListNode head) {
		ListNode iter = head;
		while (iter != null) {
			System.out.print(iter.val + " -> ");
			iter = iter.next;
		}
		
		System.out.println();
			
	}

	public static void main(String[] args) {
		// 1->2->6->3->4->5->6,
		ListNode head = new ListNode(1, new ListNode(2,
				new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));
		RemoveLinkedListElements solElements = new RemoveLinkedListElements();
		solElements.traverse(head);
		ListNode iter = solElements.removeElements(head, 1);
		solElements.traverse(iter);
		
	}

}
