package my.learning.dsa;

public class SortLinkedList {

	// Given the head of a linked list, return the list after sorting it in ascending order.

	// Follow up: Can you sort the linked list in O(n log(n)) time and O(1) memory (i.e. constant space)?
	
	// solution is using merge sort - split into half and sort using recursion
	// and then merge the sorted two lists
	// solution: merge sort
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head; // recursion base return
		}
       // Step 1: split into two
		ListNode prev = null, slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		// step 2: sort itself using recursion
		ListNode head1 = sortList(head);
		ListNode head2 = sortList(slow);
		
		// step 3: merge two 
		
		return merge(head1, head2);
    }
	
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode tempHead = new ListNode(0);
		ListNode currentNode = tempHead;
		while(head1 != null && head2 != null) {
			if(head1.val < head2.val) {
				currentNode.next = head1;
				head1 = head1.next;
			}else {
				currentNode.next = head2;
				head2 = head2.next;
			}
			currentNode = currentNode.next;
		}
		
		if(head1 != null) {
			currentNode.next = head1;
		}
		
		if(head2 != null) {
			currentNode.next = head2;
		}
		
		return tempHead.next;
	}
}
