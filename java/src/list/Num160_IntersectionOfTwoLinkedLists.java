package list;

import utils.ListNode;

public class Num160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean p1Second = false;
        boolean p2Second = false;
        while (true) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {
                if (p1Second) {
                    break;
                }
                p1 = headB;
                p1Second = true;
            }

            if (p2 == null) {
                if (p2Second) {
                    break;
                }
                p2 = headA;
                p2Second = true;
            }
        }
        return null;
    }

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
