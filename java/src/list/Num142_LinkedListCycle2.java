package list;

import utils.ListNode;

public class Num142_LinkedListCycle2 {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      } else {
        return null;
      }
      if (slow == fast) {
        break;
      }
    }
    if (fast == null) {
      return null;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
