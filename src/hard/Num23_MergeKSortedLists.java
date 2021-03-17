package hard;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Num23_MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {

    if (lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    PriorityQueue<ListNode> priorityQueue =
            new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

    for (ListNode node : lists) {
      if (node != null) {
        priorityQueue.add(node);
      }
    }

    ListNode pointer = new ListNode();
    ListNode head = pointer;

    while (!priorityQueue.isEmpty()) {
      ListNode current = priorityQueue.poll();
      pointer.next = new ListNode(current.val);

      if (current.next != null) {
        priorityQueue.add(current.next);
      }
      pointer = pointer.next;
    }
    return head.next;
  }
}
