package medium;

import java.util.HashMap;
import java.util.Map;

public class Num138_CopyListWithRandomPointer {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    if (head == null) {
      return head;
    }
    Map<Node, Integer> oldMap = new HashMap<>();
    Map<Integer, Node> newMap = new HashMap<>();

    Node oldPtr = head;
    oldMap.put(head, 0);

    Node newHead = new Node(head.val);
    newHead.random = oldPtr.random;

    Node newPtr = newHead;
    oldPtr = oldPtr.next;
    newMap.put(0, newHead);

    int index = 1;
    // construct the list
    while (oldPtr != null) {
      newPtr.next = new Node(oldPtr.val);
      newPtr.next.random = oldPtr.random;

      oldMap.put(oldPtr, index);
      newMap.put(index, newPtr.next);
      oldPtr = oldPtr.next;
      newPtr = newPtr.next;
      index++;
    }

    // construct the random pointer;
    newPtr = newHead;
    while (newPtr != null) {
      if (newPtr.random != null) {
        int newIndex = oldMap.get(newPtr.random);
        Node newNode = newMap.getOrDefault(newIndex, null);
        newPtr.random = newNode;
      }
      newPtr = newPtr.next;
    }
    return newHead;
  }

  public Node copyRandomListOpt(Node head) {
    if (head == null) {
      return head;
    }
    Map<Node, Node> oldMap = new HashMap<>();

    Node oldPtr = head;

    Node newHead = new Node(head.val);
    newHead.random = oldPtr.random;

    Node newPtr = newHead;
    oldPtr = oldPtr.next;
    oldMap.put(head, newHead);

    int index = 1;
    // construct the list
    while (oldPtr != null) {
      newPtr.next = new Node(oldPtr.val);
      newPtr.next.random = oldPtr.random;

      oldMap.put(oldPtr, newPtr.next);
      oldPtr = oldPtr.next;
      newPtr = newPtr.next;
      index++;
    }

    // construct the random pointer;
    newPtr = newHead;
    while (newPtr != null) {
      if (newPtr.random != null) {
        Node newNode = oldMap.getOrDefault(newPtr.random, null);
        newPtr.random = newNode;
      }
      newPtr = newPtr.next;
    }
    return newHead;
  }
}
