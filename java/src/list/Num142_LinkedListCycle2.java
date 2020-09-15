package list;

import utils.ListNode;

public class Num142_LinkedListCycle2 {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode doublePtr = head;
    ListNode ptr = head;
    while (doublePtr != null) {
      ptr = ptr.next;
      doublePtr = doublePtr.next;
      if (doublePtr != null) {
        doublePtr = doublePtr.next;
      }
      if (ptr == doublePtr) {
        return true;
      }
    }
    return false;
  }
}
