package my.learning.dsa;

public class ReverseLinkedList {
	
	// Recursion
	public ListNode reverseList(ListNode head) {
		return reverseListRec(head, null);
	}
	
	public ListNode reverseListRec(ListNode head, ListNode newHead) {
		if(head == null) return newHead;
		ListNode temp = head.next;
		head.next = newHead;
		newHead = head;
		return reverseListRec(temp, newHead);
	}

	// Iterative
	public ListNode reverseListIter(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;   
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
