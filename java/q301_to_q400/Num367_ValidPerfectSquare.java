package q301_to_q400;

public class Num367_ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }


    public static boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        long upperBound = num / 2;
        long lowerBound = 1;
        long mid = upperBound;
        while (mid > lowerBound) {
            long guess = mid * mid;
            if (guess == num) {
                return true;
            }
            if (guess > num) {
                upperBound = mid;
            } else {
                lowerBound = mid;
            }
            mid = (upperBound + lowerBound) / 2;
        }
        return false;
    }
}
