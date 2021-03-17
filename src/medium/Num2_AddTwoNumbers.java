package medium;

import utils.ListNode;

public class Num2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode pointer = head;

        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        int carryOver = 0;
        while (l1Ptr != null && l2Ptr != null) {
            int value = (l1Ptr.val + l2Ptr.val + carryOver) % 10;
            carryOver = (l1Ptr.val + l2Ptr.val + carryOver) / 10;
            pointer.next = new ListNode(value);

            l1Ptr = l1Ptr.next;
            l2Ptr = l2Ptr.next;
            pointer = pointer.next;
        }

        while (l1Ptr != null) {
            int value = (l1Ptr.val + carryOver) % 10;
            carryOver = (l1Ptr.val + carryOver) / 10;

            pointer.next = new ListNode(value);
            pointer = pointer.next;
            l1Ptr = l1Ptr.next;
        }
        while (l2Ptr != null) {
            int value = (l2Ptr.val + carryOver) % 10;
            carryOver = (l2Ptr.val + carryOver) / 10;

            pointer.next = new ListNode(value);
            pointer = pointer.next;
            l2Ptr = l2Ptr.next;
        }
        if (carryOver == 1) {
            pointer.next = new ListNode(1);
        }

        return head.next;
    }
}
