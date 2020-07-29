package list;

import java.util.Comparator;
import java.util.PriorityQueue;
import utils.ListNode;

public class Num23_MegeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode result = new ListNode();
    ListNode pointer = result;

    PriorityQueue<ListNode> nodes = new PriorityQueue<>(
        (Comparator<ListNode>) (o1, o2) -> o1.val - o2.val);
    for (ListNode node : lists) {
      if (node != null) {
        nodes.add(node);
      }
    }
    while (!nodes.isEmpty()) {
      ListNode node = nodes.poll();
      pointer.next = new ListNode(node.val);
      pointer = pointer.next;
      if (node.next != null) {
        nodes.add(node.next);
      }
    }
    return result.next;
  }
}
