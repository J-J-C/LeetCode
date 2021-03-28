package series.design;

public class Num707_DesignLinkedList {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();

    myLinkedList.addAtHead(5);
    myLinkedList.addAtIndex(1, 2);
    System.out.println(myLinkedList.get(1));
    myLinkedList.addAtHead(6);
    myLinkedList.addAtTail(2);
    System.out.println(myLinkedList.get(3));
    myLinkedList.addAtTail(1);
    System.out.println(myLinkedList.get(5));
    myLinkedList.addAtHead(2);
    System.out.println(myLinkedList.get(2));
    myLinkedList.addAtHead(6);
  }
}

class MyLinkedList {

  DuoLinkNode head;
  DuoLinkNode tail;
  int length;

  public MyLinkedList() {
    this.head = new DuoLinkNode(Integer.MAX_VALUE);
    this.tail = new DuoLinkNode(Integer.MIN_VALUE);
    head.next = tail;
    tail.previous = head;
    length = 0;
  }

  public int get(int index) {
    if (index >= length) {
      return -1;
    }
    DuoLinkNode pointer = head;
    while (index >= 0) {
      pointer = pointer.next;
      index--;
    }
    return pointer.val;
  }

  public void addAtHead(int val) {
    length++;
    DuoLinkNode node = new DuoLinkNode(val);
    node.next = head.next;
    node.previous = head;
    head.next.previous = node;
    head.next = node;
  }

  public void addAtTail(int val) {
    length++;
    DuoLinkNode node = new DuoLinkNode(val);
    node.previous = tail.previous;
    node.next = tail;
    tail.previous.next = node;
    tail.previous = node;
  }

  public void addAtIndex(int index, int val) {
    if (index > length) {

    } else if (index == length) {
      addAtTail(val);
    } else {
      int counter = -1;
      DuoLinkNode pointer = head;
      while (counter < index) {
        pointer = pointer.next;
        counter++;
      }
      DuoLinkNode node = new DuoLinkNode(val);

      node.next = pointer;
      node.previous = pointer.previous;
      pointer.previous = node;
      node.previous.next = node;
      length++;
    }
  }

  public void deleteAtIndex(int index) {
    if (index >= length) {

    } else {
      int counter = -1;
      DuoLinkNode pointer = head;
      while (counter < index) {
        pointer = pointer.next;
        counter++;
      }
      DuoLinkNode previous = pointer.previous;
      pointer.next.previous = previous;
      pointer.previous.next = pointer.next;
      length--;
    }
  }

  static class DuoLinkNode {
    int val;
    DuoLinkNode previous;
    DuoLinkNode next;

    public DuoLinkNode(int val) {
      this.val = val;
    }
  }
}
