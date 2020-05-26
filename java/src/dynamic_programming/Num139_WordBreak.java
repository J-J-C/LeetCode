package dynamic_programming;

import java.util.*;

public class Num139_WordBreak {

    // this is a working apprach, however it takes way too long to run...
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        String s = "bccdbacdbdacddabbaaaadababadad";
        String[] words =
                {"cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd"
                        , "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada",
                        "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb"};
        System.out.println(wordBreak(s, Arrays.asList(words)));
        System.out.println((System.currentTimeMillis() - current) / 1000);
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, "", new ArrayList<>()) > 0;
    }


    public static int wordBreak(String s, List<String> wordDict, String temp, List<Integer> indexs) {
        if (temp.length() > s.length()) {
            String result = "";
            for (int index : indexs) {
                result += wordDict.get(index);
            }
            int value = result.equals(s) ? 1 : 0;
            map.put(result, value);
            return value;
        }
        int total = 0;
        int index = 0;
        for (String word : wordDict) {
            List<Integer> newList = new ArrayList<>(indexs);
            newList.add(index++);
            if (map.containsKey(temp + word)) {
                total += map.get(temp + word);
            } else {
                total += wordBreak(s, wordDict, temp + word, newList);
            }
            if (total >= 1) {
                return total;
            }
        }
        return total;
    }
}
