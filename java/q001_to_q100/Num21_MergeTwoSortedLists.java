package q001_to_q100;

import utils.ListNode;

public class Num21_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(mergeTwoLists(l1, l2));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        // basic condition check
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode node;
        if (l1.val <= l2.val) {
            node = new ListNode(l1.val);
            ptr1 = ptr1.next;
        } else {
            node = new ListNode(l2.val);
            ptr2 = ptr2.next;

        }
        ListNode ptr = node;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 == null && ptr2 != null) {
                ptr.next = new ListNode(ptr2.val);
                ptr = ptr.next;
                ptr2 = ptr2.next;
            }
            if (ptr2 == null && ptr1 != null) {
                ptr.next = new ListNode(ptr1.val);
                ptr = ptr.next;
                ptr1 = ptr1.next;
            }

            if (ptr1 != null && ptr2 != null) {
                if (ptr1.val <= ptr2.val) {
                    ptr.next = new ListNode(ptr1.val);
                    ptr1 = ptr1.next;
                } else {
                    ptr.next = new ListNode(ptr2.val);
                    ptr2 = ptr2.next;
                }
                ptr = ptr.next;
            }

        }
        return node;
    }
}
