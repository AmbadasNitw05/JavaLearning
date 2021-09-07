package my.learning.dsa;

public class DeleteDuplicatesSLL {

	// leetcode problem - 0ms but not memory efficient. need to check
	public ListNode deleteDuplicates1(ListNode head) {
        if(head == null) return head;
        
        ListNode current = head;
        
        while(current != null){
            if(current.next != null && current.next.val == current.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        
        return head;
    } 
	
	// Recursive solution - no idea how it works
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
