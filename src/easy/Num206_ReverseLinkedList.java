package easy;

import utils.ListNode;

public class Num206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;

        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;

            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
