package list;

import utils.ListNode;

public class Num876_MilldeOfLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = ListNode.constructList(array);
        ListNode.printList(head);
        ListNode.printList(middleNode(head));
    }


    public static ListNode middleNode(ListNode head) {
        ListNode ptr = null;
        ListNode slowPtr = null;
        boolean found = false;
        while (!found) {
            if (slowPtr == null) {
                slowPtr = head;
            } else {
                slowPtr = slowPtr.next;
            }

            if (ptr == null) {
                ptr = head;
            } else {
                ptr = ptr.next;
            }
            if (ptr == null) {
                ptr = head;
            } else {
                ptr = ptr.next;
            }


            if (ptr == head || ptr == null) {
                return slowPtr;
            }

        }
        return slowPtr;
    }
}
