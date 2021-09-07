package my.learning.dsa;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
		
	}
	
	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		
		int val1 = 0, val2 = 0, val = 0;
		if(l1 != null) {
			val1 = l1.val;
			l1 = l1.next;
		}
		if(l2 != null) {
			val2 = l2.val;
			l2 = l2.next;
		}
		val = val1 + val2 + carry;
		
		if(val >= 10) {
			carry = val / 10;
			val = val % 10;
		}else carry = 0;
		
		ListNode sum = new ListNode(val);
		if(l1 == null && l2 == null) {
			if(carry != 0) 
				sum.next = new ListNode(carry);
			return sum;
		}
		
		 sum.next = addTwoNumbers(l1, l2, carry);
		 return sum;
	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode output = cur;
        
        int rem = 0;
        while(l1 != null || l2 != null){
            int val1 =0, val2 = 0;
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }else
                val1 = 0;
            
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }else
                val2 = 0;
            int val = val1 + val2 + rem;
            
            if(val >= 10){
                rem = val / 10;
                val = val % 10;
            }else
                rem = 0;
            
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
            
        }
        
        if(rem != 0){
            ListNode newNode = new ListNode(rem);
            cur.next = newNode;
        }
        
        return output.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = ListNode.getHead(new int[] {2, 4, 3});
		ListNode l2 = ListNode.getHead(new int[] {5, 6, 4});
		ListNode sum = new AddTwoNumbers().addTwoNumbers(l1, l2);
		ListNode.print(sum);

	}

}
