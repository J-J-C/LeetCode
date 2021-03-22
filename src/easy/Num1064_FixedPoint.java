package easy;

public class Num1064_FixedPoint {
    public int fixedPoint(int[] arr) {
        return fixedPointHelper(arr, 0, arr.length - 1);
    }

    public int fixedPointHelper(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return arr[start] == start ? start : -1;
        }

        int mid = (start + end) / 2;
        if (mid == arr[mid]) {
            int result = fixedPointHelper(arr, start, mid - 1);
            return result == -1 ? mid : result;
        } else if (mid < arr[mid]) {
            return fixedPointHelper(arr, start, mid);
        } else {
            return fixedPointHelper(arr, mid + 1, end);
        }
    }
}
