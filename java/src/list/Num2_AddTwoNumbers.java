package list;

import utils.ListNode;

public class Num2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode head = new ListNode();
        ListNode pointer = head;


        int carryOver = 0;
        while (p1 != null && p2 != null) {
            int value = p1.val + p2.val + carryOver;
            carryOver = value / 10;
            ListNode node = new ListNode(value % 10);
            pointer.next = node;

            pointer = pointer.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int value = p1.val + carryOver;
            carryOver = value / 10;

            pointer.next = new ListNode(value % 10);
            pointer = pointer.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int value = p2.val + carryOver;
            carryOver = value / 10;

            pointer.next = new ListNode(value % 10);
            pointer = pointer.next;
            p2 = p2.next;
        }

        if (carryOver == 1) {
            pointer.next = new ListNode(1);
        }
        return head.next;
    }
}
