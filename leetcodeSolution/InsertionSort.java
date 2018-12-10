package leetcodeSolution;
/*

 */
public class InsertionSort {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }else{
                next = cur.next;
                cur.next = next.next;
                pre = newHead;
                while(pre.next.val <= next.val){
                    pre = pre.next;
                }
                next.next = pre.next;
                pre.next = next;
            }
        }

        return newHead.next;
    }

    }
