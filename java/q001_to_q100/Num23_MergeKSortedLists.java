package q001_to_q100;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Num23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // two base case
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = new ListNode();
        ListNode pointer = head;
        ListNode previous = pointer;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        if (queue.isEmpty()) {
            return null;
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.val = node.val;
            pointer.next = new ListNode();
            previous = pointer;
            pointer = pointer.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        previous.next = null;
        return head;
    }
}
