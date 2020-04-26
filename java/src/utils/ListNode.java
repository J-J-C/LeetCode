package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }


    public static void printList(ListNode node) {
        StringBuilder builer = new StringBuilder();
        ListNode pointer = node;
        while (pointer != null) {
            builer.append(pointer.val);
            if (pointer.next != null) {
                builer.append("->");
            }
            pointer = pointer.next;
        }
        System.out.println(builer.toString());
    }


    public static ListNode constructList(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode ptr = head;
        for (int i = 1; i < array.length; i++) {
            ptr.next = new ListNode(array[i]);
            ptr = ptr.next;
        }
        return head;
    }
}