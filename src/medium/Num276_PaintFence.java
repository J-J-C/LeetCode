package medium;

public class Num276_PaintFence {

  // https://leetcode.com/problems/paint-fence/discuss/547999/One-visual-representation-thousand-words!
  public int numWays(int n, int k) {
    if (k == 1) {
      return n <= 2 ? 1 : 0;
    }

    if (n == 1) {
      return k;
    }

    int[] memory = new int[n];
    memory[0] = k;
    memory[1] = k * k;
    for (int i = 2; i < memory.length; i++) {
      memory[i] = (memory[i - 1] + memory[i - 2]) * (k - 1);
    }
    return memory[n - 1];
  }
}
