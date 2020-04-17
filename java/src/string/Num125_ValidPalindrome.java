package src.string;

public class Num125_ValidPalindrome {


    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        s = s.toUpperCase();
        while (head <= tail) {
            while (head < s.length() && !((s.charAt(head) >= 'A' && s.charAt(head) <= 'Z') || (s.charAt(head) >= '0' && s.charAt(head) <= '9'))) {
                head++;
            }
            while (tail >= 0 && !((s.charAt(tail) >= 'A' && s.charAt(tail) <= 'Z') || (s.charAt(tail) >= '0' && s.charAt(tail) <= '9'))) {
                tail--;
            }
            if (head > tail) {
                break;
            }


            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
