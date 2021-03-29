package easy;

import java.util.List;

public class Num422_ValidWordSquare {

  public boolean validWordSquare(List<String> words) {
    String[] rowsString = new String[words.size()];
    String[] columnString = new String[words.size()];

    for (int i = 0; i < words.size(); i++) {
      rowsString[i] = words.get(i);
    }
    int index = 0;
    for (int i = 0; i < words.get(0).length(); i++) {
      StringBuilder builder = new StringBuilder();
      for (int j = 0; j < words.size(); j++) {
        if (i >= words.get(j).length()) break;
        builder.append(words.get(j).charAt(i));
      }
      columnString[index] = builder.toString();
      index++;
      if (index == columnString.length) break;
    }

    for (int i = 0; i < rowsString.length; i++) {
      if (!rowsString[i].equals(columnString[i])) {
        return false;
      }
    }
    return true;
  }
}
