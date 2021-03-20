package easy;

public class Num1228_MissingNumberInArithmeticProgression {

  public static void main(String[] args) {
    System.out.println(missingNumber(new int[]{15, 13, 12}));
  }

  public static int missingNumber(int[] arr) {
    int head = 0;
    int tail = arr.length - 1;

    int diff = Math.min(arr[head + 1] - arr[head], arr[tail] - arr[tail - 1]);
    if (arr[head] > arr[tail]) {
      diff = Math.max(arr[head + 1] - arr[head], arr[tail] - arr[tail - 1]);
    }

    while (head < tail) {
      int headDiff = arr[head + 1] - arr[head];
      int tailDiff = arr[tail] - arr[tail - 1];

      if (headDiff == tailDiff) {
        if (headDiff != diff) {
          return arr[head] + diff;
        }
        if (tailDiff != diff) {
          return arr[tail] - diff;
        }
      } else {

        return headDiff < tailDiff
                ? (diff > 0 ? arr[tail] - diff : arr[head] + diff)
                : (diff < 0 ? arr[tail] - diff : arr[head] + diff);
      }
      head++;
      tail--;
    }
    return arr[head];
  }

  public static int missingNumberLinear(int[] arr) {
    int n = arr.length;

    int difference = (arr[arr.length - 1] - arr[0]) / n;

    int expected = arr[0];

    for (int val : arr) {
      if (val != expected) return expected;

      expected += difference;
    }
    return expected;
  }

  public static int missingNumberBinary(int[] arr) {
    int n = arr.length;

    int difference = (arr[n - 1] - arr[0]) / n;
    int lo = 0;
    int hi = n - 1;

    // Basic binary search template.
    while (lo < hi) {
      int mid = (lo + hi) / 2;

      // All numbers upto `mid` have no missing number, so search on the right side.
      if (arr[mid] == arr[0] + mid * difference) {
        lo = mid + 1;
      }

      // A number is missing before `mid` inclusive of `mid` itself.
      else {
        hi = mid;
      }
    }

    return arr[0] + difference * lo;
  }
}
