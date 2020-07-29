package other;

public class Num278_FirstBadVersion {

  public static void main(String[] args) {
    System.out.println(firstBadVersion(10));
  }

  public static int firstBadVersion(int n) {
    int left = 0;
    int right = n;
    int mid = left + (right - left) / 2;
    while (left < right) {
      if (!isBadVersion(mid)) {
        left = mid + 1;
      } else {
        right = mid;
      }
      mid = left + (right - left) / 2;
    }
    return left;
  }

  private static boolean isBadVersion(int mid) {
    return mid >= 6;
  }
}
