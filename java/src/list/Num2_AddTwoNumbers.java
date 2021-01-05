package list;

import utils.ListNode;

public class Num2_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode ptr = head;

    int carryOver = 0;
    while (l1 != null && l2 != null) {
      int value = l1.val + l2.val + carryOver;
      ptr.next = new ListNode(value % 10);
      ptr = ptr.next;
      l1 = l1.next;
      l2 = l2.next;
      carryOver = value / 10;
    }
    if (l1 == null) {
      handleLeftOver(ptr, l2, carryOver);

    } else {

      handleLeftOver(ptr, l1, carryOver);
    }

    return head.next;
  }

  public void handleLeftOver(ListNode ptr, ListNode l, int carryOver) {
    while (l != null) {
      int value = l.val + carryOver;
      ptr.next = new ListNode(value % 10);
      ptr = ptr.next;
      l = l.next;
      carryOver = value / 10;
    }
    if (carryOver == 1) {
      ptr.next = new ListNode(1);
    }
  }
}
