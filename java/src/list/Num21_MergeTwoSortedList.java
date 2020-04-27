package list;

import utils.ListNode;

public class Num21_MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedNode = null;

        ListNode ptr = new ListNode();
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        mergedNode = ptr;


        while (l1 != null && l2 != null) {
            ptr.val = l1.val < l2.val ? l1.val : l2.val;
            ptr.next = new ListNode();
            ptr = ptr.next;

            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ptr.val = l1.val;
            l1 = l1.next;
            if (l1 != null) {
                ptr.next = new ListNode();
                ptr = ptr.next;
            }
        }
        while (l2 != null) {
            ptr.val = l2.val;
            l2 = l2.next;
            if (l2 != null) {
                ptr.next = new ListNode();
                ptr = ptr.next;
            }
        }
        return mergedNode;
    }
}
