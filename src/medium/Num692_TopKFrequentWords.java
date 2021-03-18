package medium;

import java.util.*;

public class Num692_TopKFrequentWords {

  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> freqMap = new HashMap<>();
    for (String w : words) {
      freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
    }

    PriorityQueue<String> pq =
            new PriorityQueue(
                    (Comparator<String>)
                            (o1, o2) -> {
                              int diff = freqMap.get(o1) - freqMap.get(o2);
                              return diff != 0 ? -diff : o1.compareTo(o2);
                            });
    for (String w : freqMap.keySet()) {
      pq.add(w);
    }
    List<String> total = new ArrayList<>();
    while (k > 0) {
      total.add(pq.poll());
      k--;
    }
    return total;
  }
}
