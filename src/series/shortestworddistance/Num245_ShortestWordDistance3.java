package series.shortestworddistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num245_ShortestWordDistance3 {

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
        if (word1.equals(word2)) {
            for (int i = 0; i < map.get(word1).size() - 1; i++) {
                minDistance =
                        Math.min(minDistance, Math.abs(map.get(word1).get(i) - map.get(word1).get(i + 1)));
            }

        } else {
            for (int i : map.get(word1)) {
                for (int j : map.get(word2)) {
                    if (Math.abs(i - j) < minDistance) {
                        minDistance = Math.abs(i - j);
                    }
                }
            }
        }
        return minDistance;
    }
}
