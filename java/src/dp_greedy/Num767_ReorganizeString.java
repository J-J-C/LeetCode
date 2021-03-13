package dp_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Num767_ReorganizeString {

  public static void main(String[] args) {

    String s = "bbbbayobq";
    System.out.println(reorganizeString(s));
  }

  public static String reorganizeString(String s) {
    int[] frequencies = new int[26];
    Arrays.fill(frequencies, 0);

    for (char c : s.toCharArray()) {
      frequencies[c - 'a'] = frequencies[c - 'a'] + 1;
    }
    PriorityQueue<Character> priorityQueue =
            new PriorityQueue<>((o1, o2) -> -(frequencies[o1 - 'a'] - frequencies[o2 - 'a']));

    for (int i = 'a'; i <= 'z'; i++) {
      if (frequencies[i - 'a'] > 0) {
        priorityQueue.add((char) i);
      }
    }

    if (frequencies[priorityQueue.peek() - 'a'] > (s.length() + 1) / 2) {
      return "";
    }

    // construct string
    char[] placeHolder = new char[s.length()];
    Arrays.fill(placeHolder, '0');

    int index = 0;
    char mostFrequent = priorityQueue.poll();
    while (frequencies[mostFrequent - 'a'] > 0) {
      placeHolder[index] = mostFrequent;
      index += 2;
      frequencies[mostFrequent - 'a'] = frequencies[mostFrequent - 'a'] - 1;
    }
    index = 1;
    while (!priorityQueue.isEmpty()) {
      char current = priorityQueue.poll();
      while (index < s.length() && placeHolder[index] != '0') {
        index++;
      }
      if (index == s.length()) {
        break;
      }
      placeHolder[index] = current;
      index += 1;
      frequencies[current - 'a'] = frequencies[current - 'a'] - 1;
      if (frequencies[current - 'a'] > 0) {
        priorityQueue.add(current);
      }
    }
    return new String(placeHolder);
  }
}
