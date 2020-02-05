package q001_to_q100;

import utils.ListNode;

public class Num19_RemoveNthNodeFromEndOfList {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        ListNode delayedPointer = null;
        int delayedStart = 0 - n;
        while (pointer != null) {
            pointer = pointer.next;
            if (delayedStart == 0) {
                delayedPointer = head;
            }
            if (delayedStart > 0) {
                delayedPointer = delayedPointer.next;
            }
            delayedStart++;
        }
        if (delayedPointer == null) {
            return head.next;
        }
        if (delayedPointer.next.next == null) {
            delayedPointer.next = null;
        } else {
            delayedPointer.next = delayedPointer.next.next;
        }
        return head;
    }
}
