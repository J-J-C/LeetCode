package array;

public class Num167_TwoSum2SortedArray {


  public static void main(String[] args) {

    int[] nums = {2, 7, 11, 15};

    System.out.println(twoSum(nums, 9));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int[] solution = new int[2];

    int p1 = 0;
    int p2 = numbers.length - 1;

    while (p1 < p2) {
      int a = numbers[p1];
      int b = numbers[p2];
      System.out.println(a + ", " + b);
      if (a + b == target) {
        solution[0] = p1 + 1;
        solution[1] = p2 + 1;
        break;
      } else if (a + b > target) {
        p2--;
      } else {
        p1++;
      }
    }
    return solution;
  }
}
