package string;

import java.util.ArrayList;
import java.util.List;

public class Num443_StringCompression {

  public int compress(char[] chars) {
    // handle special case
    if (chars.length <= 2) {
      if (chars.length == 2) {
        if (chars[0] == chars[1]) {
          chars[1] = '2';
        }
      }
      return chars.length;
    }

    char c = chars[0];
    int count = 1;
    int availableIndex = 0;
    for (int i = 1; i < chars.length; i++) {
      if (c == chars[i]) {
        count++;
      } else {
        chars[availableIndex] = c;
        availableIndex++;

        if (count > 1) {
          String s = Integer.toString(count);
          for (int j = 0; j < s.length(); j++) {
            chars[availableIndex] = s.charAt(j);
            availableIndex++;
          }
        }
        // reset
        c = chars[i];
        count = 1;
      }
    }

    // add to new array
    chars[availableIndex] = c;
    availableIndex++;
    if (count > 1) {
      String s = Integer.toString(count);

      for (int j = 0; j < s.length(); j++) {
        chars[availableIndex] = s.charAt(j);
        availableIndex++;
      }
    }

    return availableIndex;
  }

  public int compressUsingExtraSpace(char[] chars) {
    // handle special case
    if (chars.length <= 2) {
      if (chars.length == 2) {
        if (chars[0] == chars[1]) {
          chars[1] = '2';
        }
      }
      return chars.length;
    }

    int newLength = 0;
    List<Character> characterList = new ArrayList<>();
    char c = chars[0];
    int count = 1;
    for (int i = 1; i < chars.length; i++) {
      if (c == chars[i]) {
        count++;
      } else {
        // add to new array
        characterList.add(c);
        if (count > 1) {
          for (char n : ("" + count).toCharArray()) {
            characterList.add(n);
          }
        }
        // reset
        c = chars[i];
        count = 1;
      }
    }
    // add to new array
    characterList.add(c);
    if (count > 1) {
      for (char n : ("" + count).toCharArray()) {
        characterList.add(n);
      }
    }

    int index = 0;
    while (index < characterList.size()) {
      chars[index] = characterList.get(index);
      index++;
    }

    return characterList.size();
  }
}
