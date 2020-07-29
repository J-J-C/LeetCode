package list;

import utils.ListNode;

public class Num206_ReverseLinkedList {

  ListNode newHead = null;

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  public ListNode reverseListR(ListNode head) {
    /* recursive solution */
    return reverseListInt(head, null);
  }

  private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null) {
      return newHead;
    }
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }

  public ListNode reverseListR2(ListNode head) {
    // base case
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = reverseListR2(head.next);

    head.next.next = head;
    head.next = null;

    return newHead;
  }

  public ListNode reverseList3(ListNode head) {
    helper(head);
    return newHead;
  }

  private ListNode helper(ListNode node) {
    if (node == null || node.next == null) {
      newHead = node;
      return node;
    }
    ListNode temp = helper(node.next);
    temp.next = node;
    node.next = null;
    return node;
  }
}
