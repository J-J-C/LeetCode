package easy;

import java.util.HashMap;
import java.util.Map;

public class Num359_LoggerRateLimiter {

  class Logger {

    Map<String, Long> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Logger() {
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns
     * false. If this method returns false, the message will not be printed. The timestamp is in
     * seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
      if (map.containsKey(message)) {
        long time = map.get(message);
        if (timestamp - time < 10) {
          return false;
        }
      }
      map.put(message, (long) timestamp);
      return true;
    }
  }
}
