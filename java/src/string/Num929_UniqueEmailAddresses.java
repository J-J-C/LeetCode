package string;

import java.util.HashSet;
import java.util.Set;

public class Num929_UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {

            int atIndex = email.indexOf("@");
            String[] split = email.split("@");
            String[] secondSplit = split[0].split("\\+");
            String finalEmail = secondSplit[0].replaceAll("\\.", "") + "@" + split[1];

            emailSet.add(finalEmail);
        }
        return emailSet.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
            for (char c : email.toCharArray()) {
                if (c == '.') {
                    continue;
                }
                if (c == '+') {
                    break;
                }
                builder.append(c);
            }
            builder.append(email.substring(email.indexOf("@")));
            emailSet.add(builder.toString());
        }
        return emailSet.size();
    }

    public int numUniqueEmails3(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
            int atIndex = -1;
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '@') {
                    atIndex = i;
                }
                if (c == '.' && atIndex == -1) {
                    continue;
                }
                if (c == '+') {
                    while (email.charAt(i) != '@') {
                        i++;
                    }
                    i--;
                    continue;
                }
                builder.append(c);
            }
            emailSet.add(builder.toString());
        }
        return emailSet.size();
    }
}
