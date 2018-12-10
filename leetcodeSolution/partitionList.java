package leetcodeSolution;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

time: O(n)
space: O(n)
 */
public class partitionList {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode l = dummy;
        ListNode r = dummy2;

        while(head != null){
            if(head.val <= x){
                l.next = head;
                l = l.next;
            }else{
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }

        r.next = null;
        l.next = dummy2.next;
        return dummy.next;
    }


}
