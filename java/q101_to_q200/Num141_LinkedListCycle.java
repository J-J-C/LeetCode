package q101_to_q200;

import utils.ListNode;

public class Num141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode oneStepPointer = head;
        ListNode twoStepPointer = head;

        while(twoStepPointer != null) {
            oneStepPointer = oneStepPointer.next;
            twoStepPointer = twoStepPointer.next;
            if(twoStepPointer == null) {
                break;
            } else {
                twoStepPointer = twoStepPointer.next;
            }
            if(oneStepPointer == twoStepPointer) {
                return true;
            }
        }
        return false;
    }

}
