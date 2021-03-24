package hard;

public class Num42_TrappingRainWater {

  public int trapDp(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int ans = 0;
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    leftMax[0] = height[0];
    rightMax[height.length - 1] = height[height.length - 1];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }

    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }

    for (int i = 1; i < height.length - 1; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
  }

  public int trapTwoPointer(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int ans = 0;
    int left = 0, right = height.length - 1;
    int left_max = 0, right_max = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= left_max) {
          left_max = height[left];
        } else {
          ans += (left_max - height[left]);
        }
        left++;
      } else {
        if (height[right] >= right_max) {
          right_max = height[right];
        } else {
          ans += (right_max - height[right]);
        }
        right--;
      }
    }

    return ans;
  }
}
