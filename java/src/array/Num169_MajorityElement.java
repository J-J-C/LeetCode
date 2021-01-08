package array;

public class Num169_MajorityElement {

    /*
    To do this, we maintain a count, which is
    incremented whenever we see an instance of our current candidate for majority
    element and decremented whenever we see anything else.
     */
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }

}
