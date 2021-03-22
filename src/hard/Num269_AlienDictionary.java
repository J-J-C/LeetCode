package hard;

import java.util.*;

public class Num269_AlienDictionary {
  public String alienOrder(String[] words) {

    Map<Character, List<Character>> adjacentListGraph = new HashMap<>();
    Map<Character, Integer> countMap = new HashMap<>();

    // step 1: build the graph
    for (String s : words) {
      for (char c : s.toCharArray()) {
        adjacentListGraph.put(c, new ArrayList<>());
        countMap.put(c, 0);
      }
    }

    // step 2: build the dependencies
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }
      // Find the first non match and insert the corresponding relation.
      for (int index = 0; index < Math.min(word1.length(), word2.length()); index++) {
        if (word1.charAt(index) != word2.charAt(index)) {
          adjacentListGraph.get(word1.charAt(index)).add(word2.charAt(index));
          countMap.put(word2.charAt(index), countMap.get(word2.charAt(index)) + 1);
          break;
        }
      }
    }

    // step 3: BFS to construct the string
    StringBuilder builder = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    for (char c : countMap.keySet()) {
      if (countMap.get(c) == 0) {
        queue.add(c);
      }
    }

    while (!queue.isEmpty()) {
      char c = queue.poll();
      builder.append(c);
      List<Character> clist = adjacentListGraph.get(c);
      for (char c1 : clist) {
        int degree = countMap.get(c1);
        if (degree == 1) {
          queue.add(c1);
        }
        countMap.put(c1, degree - 1);
      }
    }
    if (builder.length() < countMap.size()) {
      return "";
    }

    return builder.toString();
  }
}
