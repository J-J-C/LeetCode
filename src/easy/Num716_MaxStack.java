package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Num716_MaxStack {
}


class MaxStack {
  TreeMap<Integer, List<Node>> map;
  DoubleLinkedList doubleLinkedList;

  public MaxStack() {
    map = new TreeMap();
    doubleLinkedList = new DoubleLinkedList();
  }

  public void push(int x) {
    Node node = doubleLinkedList.add(x);
    if (!map.containsKey(x))
      map.put(x, new ArrayList<>());
    map.get(x).add(node);
  }

  public int pop() {
    int val = doubleLinkedList.pop();
    List<Node> L = map.get(val);
    L.remove(L.size() - 1);
    if (L.isEmpty()) map.remove(val);
    return val;
  }

  public int top() {
    return doubleLinkedList.peek();
  }

  public int peekMax() {
    return map.lastKey();
  }

  public int popMax() {
    int max = peekMax();
    List<Node> L = map.get(max);
    Node node = L.remove(L.size() - 1);
    doubleLinkedList.unlink(node);
    if (L.isEmpty()) map.remove(max);
    return max;
  }
}

class DoubleLinkedList {
  Node head, tail;

  public DoubleLinkedList() {
    head = new Node(0);
    tail = new Node(0);
    head.next = tail;
    tail.prev = head;
  }

  public Node add(int val) {
    Node x = new Node(val);
    x.next = tail;
    x.prev = tail.prev;
    tail.prev = tail.prev.next = x;
    return x;
  }

  public int pop() {
    return unlink(tail.prev).val;
  }

  public int peek() {
    return tail.prev.val;
  }

  public Node unlink(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    return node;
  }
}

class Node {
  int val;
  Node prev, next;

  public Node(int v) {
    val = v;
  }
}


class MaxStack1 {

  Stack<Integer> stack = new Stack<>();
  int max = Integer.MIN_VALUE;

  public MaxStack1() {
  }

  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(x);
      max = x;
    } else {
      stack.push(x);
      max = Math.max(x, max);
    }
  }

  public int pop() {
    int popped = stack.pop();
    if (popped == max) {
      max = Integer.MIN_VALUE;
      stack.stream()
              .forEach(
                      i -> {
                        max = Math.max(i, max);
                      });
    }
    return popped;
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return max;
  }

  public int popMax() {
    Stack<Integer> temp = new Stack<>();
    int toPop = max;

    boolean maxPoped = false;
    while (!stack.isEmpty()) {
      int value = stack.pop();
      if (value != max) {
        temp.push(value);
      } else {
        if (!maxPoped) {
          maxPoped = true;
        } else {
          temp.push(value);
        }
      }
    }

    max = Integer.MIN_VALUE;
    while (!temp.isEmpty()) {
      int value = temp.pop();
      max = Math.max(max, value);
      stack.push(value);
    }

    return toPop;
  }
}
