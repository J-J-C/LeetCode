package list;

import utils.ListNode;

public class Num19_RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode previous = head;
    ListNode ptr1 = head;
    ListNode ptr2 = head;
    int origin = n;
    while (origin > 1) {
      ptr2 = ptr2.next;
      origin--;
    }
    boolean isDeleted = false;
    if (ptr2.next == null) {
      return head.next;
    }
    while (ptr1 != null) {
      if (ptr2 != null) {
        ptr2 = ptr2.next;
      }
      if (ptr2 == null && !isDeleted) {
        previous.next = ptr1.next;
        ptr1 = previous.next;
        isDeleted = true;
      }
      previous = ptr1;
      if (ptr1 == null) {
        return head;
      }
      ptr1 = ptr1.next;

    }
    return head;
  }

  public ListNode removeNthFromEndBetter(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }
}
