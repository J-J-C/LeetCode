package easy;

import utils.ListNode;

public class Num21_MergeTwoSortedList {

    // ideally, we should reconstruct l1 and l2 once finished to ensure immutability
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // handle base case
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        // set up;
        ListNode head = new ListNode();
        ListNode pointer = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pointer.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        while (l1 != null) {
            pointer.next = new ListNode(l1.val);
            l1 = l1.next;
            pointer = pointer.next;
        }
        while (l2 != null) {
            pointer.next = new ListNode(l2.val);
            l2 = l2.next;
            pointer = pointer.next;
        }

        return head.next;
    }
}
