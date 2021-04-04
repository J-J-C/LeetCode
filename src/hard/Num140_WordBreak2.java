package hard;

import java.util.*;

public class Num140_WordBreak2 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    List<String> result = new ArrayList<>();
    helper(s, "", result, set);
    return result;
  }

  public void helper(String s, String currentString, List<String> result, Set<String> wordDict) {

    if (s.length() == 0) {
      result.add(currentString.stripTrailing());
      return;
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      builder.append(s.charAt(i));
      if (wordDict.contains(builder.toString())) {
        helper(s.substring(i + 1), currentString + builder.toString() + " ", result, wordDict);
      }
    }
  }


  public List<String> wordBreak(String s, Set<String> wordDict) {
    return DFS(s, wordDict, new HashMap<>());
  }

  // DFS function returns an array including all substrings derived from s.
  List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
    if (map.containsKey(s))
      return map.get(s);

    LinkedList<String> res = new LinkedList<String>();
    if (s.length() == 0) {
      res.add("");
      return res;
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
        for (String sub : sublist)
          res.add(word + (sub.isEmpty() ? "" : " ") + sub);
      }
    }
    map.put(s, res);
    return res;
  }
}
