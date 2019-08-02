package q001_to_q100;

import utils.ListNode;


public class Num83_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head;
        ListNode next = pointer.next;
        while (next != null) {
            if (pointer.val == next.val) {
                while (next != null && pointer.val == next.val) {
                    next = next.next;
                }
            }
            pointer.next = next;
            pointer = pointer.next;
            if (pointer == null) {
                return head;
            }
            next = pointer.next;
        }
        return head;
    }
}
