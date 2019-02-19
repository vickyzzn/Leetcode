package solution2019;
/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and 
 * each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author vicky
 *
 */
public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	
	    	ListNode dummy = new ListNode(0);
            ListNode newNode = dummy;
	    	int r = 0;
	    	while (l1 != null && l2 != null) {
	    		newNode.next = new ListNode((l1.val + l2.val + r) % 10);
	    		r = (l1.val + l2.val + r) / 10;
	    		newNode = newNode.next;
	    		l1 = l1.next;
	    		l2 = l2.next;
	    	}
	    	while (l1 != null) {
	    		newNode.next = new ListNode((l1.val + r) % 10);
	    		r = (l1.val + r) / 10;
	    		l1 = l1.next;
	    		newNode = newNode.next;
	    	}
	    	
	    	while (l2 != null) {
	    		newNode.next = new ListNode((l2.val + r) % 10);
	    		r = (l2.val + r) / 10;
	    		l2 = l2.next;
	    		newNode = newNode.next;
	    	}
	    	if (r != 0) newNode.next = new ListNode(r);
	    	
			return newNode.next;
	        
	    }
	}
}
