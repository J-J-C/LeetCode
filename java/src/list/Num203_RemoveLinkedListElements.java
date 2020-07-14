package list;

import utils.ListNode;

public class Num203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head.val == val ? null : head;
        }
        ListNode ptr = head;
        ListNode newHead = null;
        ListNode previous = null;

        while (ptr != null) {
            if (ptr.val == val) {
                if (previous != null) {
                    previous.next = ptr.next;
                }
            } else {
                if(previous == null) {
                    newHead = ptr;
                    previous = ptr;
                } else{
                    previous = ptr;
                }
            }
            ptr = ptr.next;
        }
        return newHead;
    }
}
