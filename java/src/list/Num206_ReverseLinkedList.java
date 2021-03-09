package list;

import utils.ListNode;

public class Num206_ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pointer = head;
    ListNode previous = null;
    while (pointer != null) {
      ListNode next = pointer.next;
      pointer.next = previous;
      previous = pointer;
      pointer = next;
    }
    return pointer;
  }

  public ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
