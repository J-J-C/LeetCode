package list;

import utils.ListNode;

public class Num1290_ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode ptr = head;
        int result = 0;
        while (ptr != null) {
            result = result << 1;
            result = result | ptr.val;

            ptr = ptr.next;
        }
        return result;
    }
}
