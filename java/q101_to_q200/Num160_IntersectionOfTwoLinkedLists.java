package q101_to_q200;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Num160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> nodeSet = new HashSet<>();
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != null && pointerB != null) {
            if(!nodeSet.contains(pointerA)) {
                nodeSet.add(pointerA);
                pointerA = pointerA.next;
            } else {
                return pointerA;
            }
            if(!nodeSet.contains(pointerB)) {
                nodeSet.add(pointerB);
                pointerB = pointerB.next;
            } else {
                return pointerB;
            }
        }
        while(pointerA != null) {
            if(!nodeSet.contains(pointerA)) {
                pointerA = pointerA.next;
            } else {
                return pointerA;
            }
        }

        while(pointerB != null) {
            if(!nodeSet.contains(pointerB)) {
                pointerB = pointerB.next;
            } else {
                return pointerB;
            }
        }
        return null;
    }

    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }
}
