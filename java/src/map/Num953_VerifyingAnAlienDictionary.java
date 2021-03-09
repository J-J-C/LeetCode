package map;

public class Num953_VerifyingAnAlienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    int[] array = new int[26];
    for (int i = 0; i < order.length(); i++) {
      array[order.charAt(i) - 'a'] = i;
    }
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];

      int index = 0;
      boolean isValid = false;
      while (index < w1.length() && index < w2.length()) {
        if (array[w1.charAt(index) - 'a'] < array[w2.charAt(index) - 'a']) {
          isValid = true;
          break;
        } else if (array[w1.charAt(index) - 'a'] == array[w2.charAt(index) - 'a']) {
          index++;
        } else {
          return false;
        }
      }
      if (w1.length() > w2.length() && !isValid) {
        return false;
      }
    }
    return true;
  }
}
