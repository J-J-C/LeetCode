package array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Num621_TaskScheduler {

  public int leastIntervalOptimal(char[] tasks, int n) {
    int[] counter = new int[26];
    int max = 0;
    int maxCount = 0;
    for (char task : tasks) {
      counter[task - 'A']++;
      if (max == counter[task - 'A']) {
        maxCount++;
      } else if (max < counter[task - 'A']) {
        max = counter[task - 'A'];
        maxCount = 1;
      }
    }

    int partCount = max - 1;
    int partLength = n - (maxCount - 1);
    int emptySlots = partCount * partLength;
    int availableTasks = tasks.length - max * maxCount;
    int idles = Math.max(0, emptySlots - availableTasks);

    return tasks.length + idles;
  }

  public int leastInterval(char[] tasks, int n) {
    List<Character> result = new LinkedList<>();
    if (n == 0) {
      return tasks.length;
    }
    // key: task value: frequency remaining
    Map<Character, Integer> map = new HashMap<>();

    // list of task, order by frequency
    PriorityQueue<Character> remainingTaskPq = new PriorityQueue<>(
        (o1, o2) -> map.get(o2) - map.get(o1));

    // to store tasks that cannot be processed
    Queue<Character> waitingQueue = new LinkedList<>();

    // setup
    for (char c : tasks) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    for (char c : map.keySet()) {
      remainingTaskPq.add(c);
    }

    int interval = 0;
    while (!map.keySet().isEmpty()) {
      if (interval < n) {
        // if there is no interval, and there are task remaining
        if (!remainingTaskPq.isEmpty()) {
          // process a task and add it to waiting waitingQueue
          proceedTask(remainingTaskPq, waitingQueue, map, result);
        } else {
          result.add('+');
        }
        // every time a task is processed, increment interval
        interval++;
      } else if (interval == n) {
        // when interval is reached, we can clear the waitingQueue and process any tasks.
        interval = 0;

        // if no task can be processed, add +
        if (remainingTaskPq.isEmpty()) {
          result.add('+');
        } else {
          // process remaining task
          proceedTask(remainingTaskPq, waitingQueue, map, result);
          if (!waitingQueue.isEmpty()) {
            remainingTaskPq.add(waitingQueue.poll());
          }
        }
        // move everything back to remaining task list.
        while (!waitingQueue.isEmpty()) {
          remainingTaskPq.add(waitingQueue.poll());
        }
      }
    }
    return result.size();
  }

  private void proceedTask(PriorityQueue<Character> priorityQueue, Queue<Character> queue,
      Map<Character, Integer> map, List<Character> result) {
    char c = priorityQueue.poll();
    result.add(c);
    updateMap(c, map);
    if (map.containsKey(c)) {
      queue.add(c);
    }
  }

  private void updateMap(char c, Map<Character, Integer> map) {
    if (map.get(c) == 1) {
      map.remove(c);
    } else {
      map.put(c, map.get(c) - 1);
    }
  }
}
