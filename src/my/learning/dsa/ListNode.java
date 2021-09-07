package my.learning.dsa;


// Definition for singly-linked list.
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     
     public static ListNode getHead(int[] nums) {
    	if(nums.length == 0) return null;
    	ListNode node = new ListNode(nums[0]);
 		ListNode head = node;
 		for(int i = 1; i<nums.length; i++) {
 			node.next = new ListNode(nums[i]);
 			node = node.next;
 		}
 		
 		return head;
     }
     
     public static void print(ListNode head) {
    	 while(head != null) {
 			System.out.print(head.val + ", "); 
 			head = head.next;
 		}
     }
}

