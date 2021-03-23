package easy;

import java.util.*;

public class Num937_ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length <= 1) {
            return logs;
        }

        // 1. put the logs into two different buckets
        Queue<String> digitLogs = new LinkedList<>();
        List<String> letterLogs = new ArrayList<>();

        for (String s : logs) {
            if (isDigitLog(s)) {
                digitLogs.add(s);
            } else {
                letterLogs.add(s);
            }
        }

        // 2. sort the letter log
        String[] letterLogsArray = letterLogs.toArray(new String[0]);
        Arrays.sort(
                letterLogsArray,
                (o1, o2) -> {
                    int o1Beg = o1.indexOf(" ");
                    int o2Beg = o2.indexOf(" ");
                    if (o1Beg == -1) {
                        return -1;
                    }
                    if (o2Beg == -1) {
                        return -1;
                    }
                    int diff = o1.substring(o1Beg).compareTo(o2.substring(o2Beg));
                    if (diff == 0) {
                        return o1.substring(0, o1Beg).compareTo(o2.substring(0, o2Beg));
                    }
                    return diff;
                });

        // 3. form the result string
        String[] result = new String[logs.length];
        int index = 0;
        for (String log : letterLogsArray) {
            result[index] = log;
            index++;
        }
        for (String log : digitLogs) {
            result[index] = log;
            index++;
        }
        return result;
    }

    private boolean isDigitLog(String s) {
        String[] array = s.split(" ");
        for (int i = 1; i < array.length; i++) {
            for (char c : array[i].toCharArray()) {
                if (!(c - '0' <= 9 && c - '0' >= 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
