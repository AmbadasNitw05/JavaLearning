package my.learning.dsa;

public class InsertionSortList {

	// 1. compare with first element and place at 0 index if it is less
	// 2. Compare with prev, if it less insert it in the right place
	// Accepted - https://leetcode.com/problems/insertion-sort-list/submissions/
	public ListNode insertionSortList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode currentNode = head.next;
		ListNode prev = head;
		while(currentNode != null) {
			if(currentNode.val < head.val) {
				// replace at the beginning
				prev.next = currentNode.next;
				currentNode.next = head;
				head = currentNode;
				currentNode = prev.next;
				continue;
			}else if(currentNode.val < prev.val) {
				// inserting in between
				ListNode searchStartNode = head;
				while(searchStartNode.next.val < currentNode.val) {
					searchStartNode = searchStartNode.next;
				}
				prev.next = currentNode.next;				
				currentNode.next = searchStartNode.next;
				searchStartNode.next = currentNode;
				currentNode = prev.next;
				
			}else {
				prev = currentNode;
				currentNode = currentNode.next;
				continue;
			}
		}
		
		return head;
	}
}
