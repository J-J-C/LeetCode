package utils;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }


  public static void printList(ListNode node) {
    StringBuilder builer = new StringBuilder();
    ListNode pointer = node;
    while(pointer != null) {
      builer.append(pointer.val);
      if (pointer.next != null) {
        builer.append("->");
      }
      pointer = pointer.next;
    }
    System.out.println(builer.toString());
  }
}
