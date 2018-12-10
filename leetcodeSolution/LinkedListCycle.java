package leetcodeSolution;
/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

time: O(n)
space: O(1)
 */
public class LinkedListCycle {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null ){
            if(fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null) return true;
        }


        return false;
    }
}
