package leetcodeSolution;
/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

time: O(n)
space:
    recursive: O(n)
    iterative: O(1)
 */
public class RemoveLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        while(head != null && head.val == val) head = head.next;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements2(head.next, val);
        return head.val == val?head.next:head;
    }
    }
