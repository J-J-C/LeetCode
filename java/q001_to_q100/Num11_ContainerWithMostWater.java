package q001_to_q100;

public class Num11_ContainerWithMostWater {

    public int maxArea(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        }

        int head = 0;
        int tail = nums.length - 1;
        int maxArea = 0;
        while (head != tail) {
            int width = tail - head;
            int height = nums[head] < nums[tail] ? nums[head] : nums[tail];

            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }
            if (nums[head] < nums[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;
    }
}
