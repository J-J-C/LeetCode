package q101_to_q200;

public class Num125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = "1b1";
    }

    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            System.out.println(String.format("head-%d, tail-%d", head, tail));
            if (!isInRange(s.charAt(head))) {
                head++;
                continue;
            }
            if (!isInRange(s.charAt(tail))) {
                tail--;
                continue;
            }
            if (s.charAt(head) - s.charAt(tail) != 0 && Math.abs(s.charAt(head) - s.charAt(tail)) != 32) {
                return false;
            }
            if ((s.charAt(head) < 57 || s.charAt(tail) < 57) && Math.abs(s.charAt(head) - s.charAt(tail)) == 32) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    private static boolean isInRange(char c) {
        if (c < 48 || c > 122) {
            return false;
        }
        if ((c > 57 && c < 65) || (c > 90 && c < 97)) {
            return false;
        }
        return true;
    }
}
