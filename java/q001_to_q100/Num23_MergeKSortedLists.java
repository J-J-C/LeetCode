package q001_to_q100;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.ListNode;


public class Num23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // two base case
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>(listNodeComparator);
        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }
        if(queue.isEmpty()) {
            return null;
        }
        ListNode head = null;
        ListNode pointer = head;

        ListNode firstNode = queue.poll();
        head = firstNode;
        pointer = head;
        if(firstNode.next != null) {
            queue.add(firstNode.next);
        }
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = new ListNode(node.val);
            pointer = pointer.next;
            if(node.next != null) {
                queue.add(node.next);
            }
        }
        return head;
    }
}
