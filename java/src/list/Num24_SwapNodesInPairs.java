package list;

import utils.ListNode;

public class Num24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;

        ListNode pointer = head;
        ListNode previous = null;
        ListNode next = pointer.next;


        while (next != null) {

            ListNode nextStage = next.next;
            ListNode temp = next;

            // swap
            if (next != null) {
                pointer.next = next.next;
                next.next = pointer;
                if (previous != null) {
                    previous.next = next;
                }
            }

            previous = temp;
            pointer = nextStage;
            if (pointer != null) {
                next = pointer.next;
            } else {
                break;
            }
        }
        return newHead;
    }
}
