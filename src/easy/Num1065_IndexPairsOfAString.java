package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Num1065_IndexPairsOfAString {
  public int[][] indexPairs(String text, String[] words) {
    List<int[]> result = new ArrayList<>();

    for (int i = 0; i < text.length(); i++) {
      for (String word : words) {
        if (text.startsWith(word, i)) {
          result.add(new int[]{i, i + word.length() - 1});
        }
      }
    }

    Collections.sort(result, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
    return result.toArray(new int[0][]);
  }
}
