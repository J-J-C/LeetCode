package q201_q300;

import utils.ListNode;

public class Num206_ReverseLinkedListRecursion {

    public static void main(String[] args) {

    }

    ListNode newHead = new ListNode(-1);

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        helper(head);
        return newHead;
    }

    private ListNode helper(ListNode node) {
        if(node == null || node.next == null) {
            newHead = node;
            return node;
        }
        ListNode current = new ListNode(node.val);
        ListNode next = helper(node.next);
        next.next = current;
        return current;
    }
}
