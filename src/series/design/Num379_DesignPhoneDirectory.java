package series.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Num379_DesignPhoneDirectory {}

class PhoneDirectory {
  private final int max;
  private final Set<Integer> used;
  private final LinkedList<Integer> free;

  public PhoneDirectory(int maxNumbers) {
    max = maxNumbers;
    used = new HashSet<>();
    free = new LinkedList<>();
  }

  public int get() {
    if (used.size() == max) {
      return -1;
    }
    Integer ret = free.isEmpty() ? used.size() : free.remove();
    used.add(ret);
    return ret;
  }

  public boolean check(int number) {
    return !used.contains(number);
  }

  public void release(int number) {
    if (used.remove(number)) {
      free.add(number);
    }
  }
}
