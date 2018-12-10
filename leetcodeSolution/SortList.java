package leetcodeSolution;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l = new ListNode(0);
        ListNode cur = l;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return l.next;
    }
}





