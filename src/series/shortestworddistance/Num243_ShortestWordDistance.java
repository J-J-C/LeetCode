package series.shortestworddistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num243_ShortestWordDistance {

  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    Map<String, List<Integer>> map = new HashMap<>();
    map.put(word1, new ArrayList<>());
    map.put(word2, new ArrayList<>());

    for (int i = 0; i < wordsDict.length; i++) {
      String word = wordsDict[i];
      if (map.containsKey(word)) {
        map.get(word).add(i);
      }
    }

    int minDistance = Integer.MAX_VALUE;
    for (int i : map.get(word1)) {
      for (int j : map.get(word2)) {
        if (Math.abs(i - j) < minDistance) {
          minDistance = Math.abs(i - j);
        }
      }
    }
    return minDistance;
  }
}
