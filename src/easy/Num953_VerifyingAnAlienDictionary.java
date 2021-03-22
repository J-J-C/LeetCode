package easy;

public class Num953_VerifyingAnAlienDictionary {
  public boolean isAlienSorted(String[] words, String order) {

    int[] rank = new int[26];
    for (int i = 0; i < order.length(); i++) {
      rank[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return false;
      }

      int index = 0;
      while (index < word1.length()) {
        if (word1.charAt(index) == word2.charAt(index)) {
          index++;
        } else {
          if (rank[word1.charAt(index) - 'a'] > rank[word2.charAt(index) - 'a']) {
            return false;
          } else {
            break;
          }
        }
      }
    }

    return true;
  }
}
