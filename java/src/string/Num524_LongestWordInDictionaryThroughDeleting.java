package string;

import java.util.List;

public class Num524_LongestWordInDictionaryThroughDeleting {

  public String findLongestWord(String s, List<String> d) {
    String result = "";
    for (String candidate : d) {
      if (isSubsequence(candidate, s)) {
        if (candidate.length() > result.length() || (candidate.length() == result.length()
            && candidate.compareTo(result) < 0)) {
          result = candidate;
        }
      }
    }
    return result;
  }


  private boolean isSubsequence(String x, String y) {
    int index = 0;
    for (int i = 0; i < y.length() && index < x.length(); i++) {
      if (x.charAt(index) == y.charAt(i)) {
        index++;
      }
    }
    return index == x.length();
  }
}
