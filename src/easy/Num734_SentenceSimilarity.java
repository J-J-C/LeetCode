package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num734_SentenceSimilarity {

  public boolean areSentencesSimilar(
          String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

    if (sentence1.length != sentence2.length) {
      return false;
    }

    for (int i = 0; i < sentence1.length; i++) {
      if (sentence1[i].equals(sentence2[i])) continue;
      String[] arr1 = new String[]{sentence1[i], sentence2[i]};
      boolean isSimilar = false;
      for (List<String> arr2 : similarPairs) {
        isSimilar = isSimilar || isSimiliar(arr1, arr2.toArray(arr2.toArray(new String[0])));
      }
      if (!isSimilar) {
        return false;
      }
    }

    return true;
  }

  public boolean isSimiliar(String[] arr1, String[] arr2) {
    return arr1[0].equals(arr2[0]) && arr1[1].equals(arr2[1])
            || arr1[0].equals(arr2[1]) && arr1[1].equals(arr2[0]);
  }

  public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
    if (words1.length != words2.length) return false;

    Set<String> pairset = new HashSet();
    for (String[] pair : pairs) pairset.add(pair[0] + "#" + pair[1]);

    for (int i = 0; i < words1.length; ++i) {
      if (!words1[i].equals(words2[i])
              && !pairset.contains(words1[i] + "#" + words2[i])
              && !pairset.contains(words2[i] + "#" + words1[i])) return false;
    }
    return true;
  }
}
