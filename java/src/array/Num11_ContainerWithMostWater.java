package array;

public class Num11_ContainerWithMostWater {
    public static void main(String[] args) {

    }


    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int head = 0;
        int tail = height.length - 1;
        int max = (tail - head) * Math.min(height[tail], height[head]);

        while (head < tail) {
            int result = (tail - head) * Math.min(height[tail], height[head]);
            max = Math.max(max, result);
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return max;
    }
}
