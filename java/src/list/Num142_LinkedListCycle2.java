package list;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @created 09/15/2020
 * @project LeetCode
 */
public class Num142_LinkedListCycle2 {

  public ListNode detectCycleUsingMap(ListNode head) {
    Map<ListNode, ListNode> map = new HashMap<>();
    ListNode pointer = head;
    map.put(head, null);
    while (pointer != null) {
      ListNode next = pointer.next;
      if (next == null) {
        break;
      }
      if (!map.containsKey(next)) {
        map.put(next, pointer);
        pointer = pointer.next;
      } else {
        return next;
      }
    }
    return null;
  }

  public ListNode detectCycle(ListNode head) {
    ListNode slowPtr = head;
    ListNode fastPtr = head;

    ListNode meetPoint = null;

    while (fastPtr != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
      if (fastPtr == null) break;
      fastPtr = fastPtr.next;

      if (slowPtr == fastPtr) {
        meetPoint = slowPtr;
        break;
      }
    }
    if (meetPoint == null) {
      return null;
    } else {
      slowPtr = head;
      while (slowPtr != fastPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }
      return fastPtr;
    }
  }

  public ListNode detectCycleOptimal(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    slow = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
