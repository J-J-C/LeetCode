package q201_q300;

import utils.ListNode;

public class Num203_RemovLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head.val == val ? null : head;
        }
        ListNode current = head;
        ListNode previous = null;
        while(current != null) {
            if (current == head) {
                while (current != null && current.val == val) {
                    head = head.next;
                    current = head;
                }
                if(current == null) {
                    continue;
                }
                previous = current;
                current = current.next;
                continue;
            }

            if (current.val == val) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }



}
