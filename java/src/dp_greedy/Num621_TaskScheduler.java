package dp_greedy;

import java.util.Arrays;

public class Num621_TaskScheduler {

  public static int leastInterval(char[] tasks, int n) {
    // frequencies of the tasks
    int[] frequencies = new int[26];
    for (int t : tasks) {
      frequencies[t - 'A']++;
    }

    Arrays.sort(frequencies);

    // max frequency
    int maxCurrentFrequency = frequencies[25];
    int coolDown = (maxCurrentFrequency - 1) * n;

    for (int i = frequencies.length - 2; i >= 0 && coolDown > 0; --i) {
      coolDown -= Math.min(maxCurrentFrequency - 1, frequencies[i]);
    }
    coolDown = Math.max(0, coolDown);

    return coolDown + tasks.length;
  }

  public int leastIntervalMath(char[] tasks, int n) {
    // frequencies of the tasks
    int[] frequencies = new int[26];
    for (int t : tasks) {
      frequencies[t - 'A']++;
    }

    // max frequency
    int f_max = 0;
    for (int f : frequencies) {
      f_max = Math.max(f_max, f);
    }

    // count the most frequent tasks
    int n_max = 0;
    for (int f : frequencies) {
      if (f == f_max) n_max++;
    }

    return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
  }
}
