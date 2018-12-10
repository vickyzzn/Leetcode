package leetcodeSolution;
/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

time: O(n)
space: O(1) ?
 */
public class PalindromeLinkedList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        ListNode half = reverse(slow);
        while(half != null){
            if(head.val != half.val) return false;
            head = head.next;
            half = half.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head){
         ListNode newhead = null;
         if(head == null || head.next == null) return head;
         while(head != null){
             ListNode tmp = head.next;
             head.next = newhead;
             newhead = head;
             head = tmp;
         }
        return newhead;
    }
}
