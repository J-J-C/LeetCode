package list;

import utils.ListNode;

import java.util.PriorityQueue;

public class Num23_MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {

    ListNode header = new ListNode();
    ListNode pointer = header;

    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    if (lists.length == 0) {
      return null;
    }
    for (ListNode node : lists) {
      if (node != null) {
        priorityQueue.add(node);
      }
    }

    while (!priorityQueue.isEmpty()) {
      ListNode current = priorityQueue.poll();
      pointer.next = new ListNode(current.val);
      pointer = pointer.next;
      current = current.next;
      if (current != null) {
        priorityQueue.add(current);
      }
    }

    return header.next;
  }
}
