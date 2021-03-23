package series.design;

import java.util.HashMap;
import java.util.Map;

public class Num146_LRUCache {
  public static void main(String[] args) {
    //
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }
}

class LRUCache {
  private final Map<Integer, LinkedNode> map = new HashMap<>();
  private final LinkedNode head;
  private final LinkedNode tail;

  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new LinkedNode();
    tail = new LinkedNode();
    head.next = tail;
    tail.previous = head;
  }

  public int get(int key) {
    LinkedNode node = map.getOrDefault(key, null);
    if (node == null) {
      return -1;
    }

    removeNode(node);
    moveToHead(node);

    return node.value;
  }

  public void put(int key, int value) {

    LinkedNode node = map.get(key);
    if (node != null) {
      node.value = value;
      removeNode(node);
      moveToHead(node);

    } else {
      node = new LinkedNode(key, value);
      map.put(key, node);
      moveToHead(node);
      if (map.size() > capacity) {
        LinkedNode tailNode = tail.previous;
        map.remove(tailNode.key);
        removeNode(tailNode);
      }
    }
  }

  private void moveToHead(LinkedNode node) {
    node.next = head.next;
    head.next.previous = node;
    node.previous = head;
    head.next = node;
  }

  private void removeNode(LinkedNode node) {
    LinkedNode previous = node.previous;
    LinkedNode next = node.next;

    previous.next = next;
    next.previous = previous;
  }
}

class LinkedNode {
  int key;
  int value;
  LinkedNode next = null;
  LinkedNode previous = null;

  public LinkedNode() {
  }

  public LinkedNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
