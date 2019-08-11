package q201_q300;

import utils.ListNode;

public class Num234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle node using fast slow pointer
        ListNode middleNode = findMiddleNode(head);

        // Reverse the second part of the node;
        ListNode secondHead = reverseList(middleNode);

        // See wether the two linked list are same
        ListNode firstCurrent = head;
        ListNode secondCurrent = secondHead;
        while (secondCurrent != null) {
            if (firstCurrent.val != secondCurrent.val) {
                return false;
            }
            firstCurrent = firstCurrent.next;
            secondCurrent = secondCurrent.next;
        }

        return true;
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (current != null && current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return pre.next;
    }
}
