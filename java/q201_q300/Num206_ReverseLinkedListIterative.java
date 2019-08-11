package q201_q300;

import utils.ListNode;

import java.awt.event.ItemListener;

public class Num206_ReverseLinkedListIterative {

    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode temp = previous;
            previous = current;
            previous.next = temp;
            current = current.next;
        }
        return previous;
    }
}
