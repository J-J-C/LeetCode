package list;

import utils.ListNode;

import java.util.Stack;

public class Num445_AddTwoNumbers2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        while (ptr1 != null) {
            stack1.push(ptr1.val);
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            stack2.push(ptr2.val);
            ptr2 = ptr2.next;
        }

        ListNode result = null;
        ListNode ptr = result;
        int carryOver = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                int sum = stack1.pop() + stack2.pop() + carryOver;
                ListNode temp = new ListNode((sum) % 10);
                carryOver = sum / 10;
                temp.next = ptr;
                ptr = temp;

            } else if (!stack1.isEmpty()) {
                int sum = stack1.pop() + carryOver;
                ListNode temp = new ListNode((sum) % 10);
                carryOver = sum / 10;
                temp.next = ptr;
                ptr = temp;
            } else if (!stack2.isEmpty()) {
                int sum = stack2.pop() + carryOver;
                ListNode temp = new ListNode((sum) % 10);
                carryOver = sum / 10;
                temp.next = ptr;
                ptr = temp;
            }
        }
        if (carryOver > 0) {
            ListNode temp = new ListNode(carryOver);
            temp.next = ptr;
            ptr = temp;
        }
        return ptr;
    }
}
