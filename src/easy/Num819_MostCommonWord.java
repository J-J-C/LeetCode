package easy;

import java.util.*;

public class Num819_MostCommonWord {

  public String mostCommonWord(String paragraph, String[] banned) {
    String mostCommonWord = "";
    Map<String, Integer> map = new HashMap<>();
    Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

    String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");
    int maxCount = 0;
    for (String word : words) {
      if (!bannedSet.contains(word)) {
        map.put(word, map.getOrDefault(word, 0) + 1);

        int currentCount = map.get(word);
        if (currentCount > maxCount) {
          mostCommonWord = word;
          maxCount = currentCount;
        }
      }
    }

    return mostCommonWord;
  }
}
