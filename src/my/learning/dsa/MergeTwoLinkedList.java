package my.learning.dsa;

public class MergeTwoLinkedList {

	// Using recursion
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       		
		// input validation
		if(l1 == null) return l2;
		if(l2 == null) return l1;		
		
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
    }
	
	// Using iterative
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;	
		
		ListNode dummy = new ListNode(-1);
		ListNode currentNode = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				currentNode.next = l1;
				l1 = l1.next;
			}else {
				currentNode.next = l2;
				l2 = l2.next;
			}
			currentNode = currentNode.next;
		}
		
		if(l1 != null) {
			currentNode.next = l1;
		}
		
		if(l2 != null) {
			currentNode.next = l2;
		}
		
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1), l2 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		

	}

}
