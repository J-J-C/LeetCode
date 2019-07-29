package q001_to_q100;

import java.util.Arrays;

public class Num58_LengthOfLastWord {

    public static void main(String[] args) {
        String s = "b   a ghfh   456";
        System.out.println(lengthOfLastWord(s));

    }
    public static int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
        if(array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            return s.length();
        }
        return array[array.length - 1].length();
    }

}
