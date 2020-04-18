package src.string;

public class Num151_ReverseWordsInAString {

    public String reverseWords(String s) {
        int head = s.length() - 1;
        int tail = s.length() - 1;

        StringBuilder builder = new StringBuilder();
        while (head >= 0) {
            while (head >= 0 && s.charAt(head) == ' ') {
                head--;
            }
            while (tail >= 0 && s.charAt(tail) == ' ') {
                tail--;
            }
            if (tail < 0) {
                break;
            }

            while (head >= 0 && s.charAt(head) != ' ') {
                head--;
            }

            builder.append(s.substring(head + 1, tail + 1)).append(' ');
            tail = head;
        }
        if (builder.length() == 0) {
            return builder.toString();
        }
        return builder.toString().substring(0, builder.length() - 1);
    }
}
