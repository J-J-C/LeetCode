package easy;

import utils.ListNode;

public class Num1474_DeleteNNodesAfterMNodesOfALinkedList {

  public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode pointer = head;
    int counter = 1;
    ListNode previous = pointer;

    while (pointer != null) {
      if (counter < m) {
        previous = previous.next;
        pointer = pointer.next;
        counter++;
      } else if (counter == m) {
        int step = 0;
        while (step <= n) {
          if (pointer != null) {
            pointer = pointer.next;
          }
          step++;
        }
        previous.next = pointer;
        previous = previous.next;

        counter = 1;
      }
    }
    return head;
  }
}
