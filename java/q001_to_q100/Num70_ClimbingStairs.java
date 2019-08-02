package q001_to_q100;

public class Num70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int sum = 0;
        int previous = 1;
        int current = 2;
        while (n > 2) {
            sum = previous + current;
            previous = current;
            current = sum;
            n--;
        }
        return sum;
    }
}
