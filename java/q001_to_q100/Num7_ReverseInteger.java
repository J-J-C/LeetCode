package q001_to_q100;

public class Num7_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-23));
        System.out.println(reverse(230));
        System.out.println(reverse(3));

    }


    public static int reverse(int x) {
        int y = 0;
        int negative = 1;
        if (x < 0) {
            negative = -1;
            x *= -1;
        }
        while (x > 0) {
            y += x % 10;
            x = x / 10;
            if (x != 0) {
                if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                y *= 10;
            }
        }
        return y * negative;
    }
}
