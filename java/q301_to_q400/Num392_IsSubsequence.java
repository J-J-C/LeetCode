package q301_to_q400;

public class Num392_IsSubsequence {

    public static boolean isSubsequence(String sub, String full) {

        int pointer = 0;
        char c = sub.charAt(pointer);

        for(int i = 0; i < full.length(); i++) {
            if(full.charAt(i) == c) {
                pointer++;
                if(pointer == sub.length()) {
                    break;
                }
                c = sub.charAt(pointer);
            }
        }

        return pointer == sub.length();
    }
}
