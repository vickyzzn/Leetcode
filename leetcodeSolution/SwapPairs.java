/*

Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Space: O(1)
Time: O(n)
 */

package leetcodeSolution;

public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newhead = new ListNode(0);
        ListNode cur = newhead;
        newhead.next = head;

        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            cur.next = first.next;
            first.next = cur.next.next;
            cur.next.next = first;
            cur = cur.next.next;
        }

        return newhead.next;
    }

}
