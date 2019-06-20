package q001_to_q100;

import utils.ListNode;

public class Num2_AddTwoNumbers {

  public void main(String[] args) {

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ptr1 = l1;
    ListNode ptr2 = l2;
    ListNode solution = new ListNode((ptr1.val + ptr2.val) % 10);
    ListNode ptrSolution = solution;
    int plusOne = (ptr1.val + ptr2.val) / 10;
    while (ptr1.next != null && ptr2.next != null) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
      ptrSolution.next = new ListNode((ptr1.val + ptr2.val + plusOne) % 10);
      plusOne = (ptr1.val + ptr2.val + plusOne) / 10;
      ptrSolution = ptrSolution.next;
    }
    while (ptr1.next != null) {
      ptr1 = ptr1.next;
      ptrSolution.next = new ListNode((ptr1.val + plusOne) % 10);
      plusOne = (ptr1.val + plusOne) / 10;
      ptrSolution = ptrSolution.next;
    }

    while (ptr2.next != null) {
      ptr2 = ptr2.next;
      ptrSolution.next = new ListNode((ptr2.val + plusOne) % 10);
      plusOne = (ptr2.val + plusOne) / 10;
      ptrSolution = ptrSolution.next;
    }
    if (plusOne != 0) {
      ptrSolution.next = new ListNode(1);
    }
    return solution;
  }
}
