package easy;

public class Num1629_SlowestKey {

  public char slowestKey(int[] releaseTimes, String keysPressed) {
    char slowestKey = keysPressed.charAt(0);
    int longestDuration = releaseTimes[0];

    for (int i = 1; i < releaseTimes.length; i++) {
      int duration = releaseTimes[i] - releaseTimes[i - 1];
      if (duration > longestDuration) {
        slowestKey = keysPressed.charAt(i);
        longestDuration = duration;
      } else if (duration == longestDuration) {
        slowestKey = slowestKey > keysPressed.charAt(i) ? slowestKey : keysPressed.charAt(i);
      }
    }

    return slowestKey;
  }
}
