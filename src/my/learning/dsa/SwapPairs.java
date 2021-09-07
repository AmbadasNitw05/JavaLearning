package my.learning.dsa;

public class SwapPairs {
	
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null && current.next.next != null){
        	ListNode first = current.next;
            ListNode second = current.next.next;
            
            
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            
            current = current.next.next;
            
            
        }
        
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode node = ListNode.getHead(new int[] {1, 2, 3, 4});		
		ListNode.print(node);
		node = new SwapPairs().swapPairs(node);
		System.out.println();
		ListNode.print(node);		

	}

}
