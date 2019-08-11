package q101_to_q200;

public class Num169_MajorityElement {


    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                if (candidate == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
