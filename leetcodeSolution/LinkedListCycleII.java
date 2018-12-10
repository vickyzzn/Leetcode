package leetcodeSolution;
/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public LinkedListCycle.ListNode detectCycle(LinkedListCycle.ListNode head) {
        if(head == null || head.next == null) return null;
        LinkedListCycle.ListNode slow = head;
        LinkedListCycle.ListNode fast = head;
        while(fast != null){
            if(fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    }
