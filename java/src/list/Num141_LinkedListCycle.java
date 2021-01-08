package list;

import utils.ListNode;

public class Num141_LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      } else {
        return false;
      }
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
