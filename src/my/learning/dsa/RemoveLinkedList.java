package my.learning.dsa;

public class RemoveLinkedList {
	
	public ListNode removeElementsRec(ListNode head, int val) {
		if(head == null) return head;
		System.out.println(head.val + " -> ");
		head.next = removeElementsRec(head.next, val);
		System.out.println(head.val + " <- ");
		return head.val == val ? head.next : head;
	}

	 public ListNode removeElements(ListNode head, int val) {
	        ListNode dummy = new ListNode(0);        
	        dummy.next = head;
	        
	        ListNode prev = null;
	        ListNode cur = dummy;
	        
	        while(cur != null){
	            if(cur.val == val && prev != null)
	                prev.next = cur.next;
	            else
	                prev = cur;
	            
	            cur = cur.next;
	        }
	        
	        return dummy.next;
	    }
	 
	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		ListNode head = node;
		for(int num: new int[] {2, 2, 3}) {
			node.next = new ListNode(num);
			node = node.next;
		}

		node = head;
		while(node != null) {
			System.out.print(node.val + ", "); 
			node = node.next;
		}
		
		System.out.println();
		head = new RemoveLinkedList().removeElementsRec(head, 2);
		System.out.println("\nAfter delete");
		node = head;
		while(node != null) {
			System.out.print(node.val + ", "); 
			node = node.next;
		}
	}

}
