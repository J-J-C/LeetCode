package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num819_MostCommonWord {

  public static void main(String[] args) {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};
    mostCommonWord(paragraph, banned);
  }

  public static String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
    String[] words = paragraph.split("([^a-zA-Z]+)");
    System.out.println(Arrays.toString(words));
    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      if (!bannedSet.contains(word)) {
        map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
      }
    }
    return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
