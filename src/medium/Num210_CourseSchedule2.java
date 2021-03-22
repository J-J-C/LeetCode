package medium;

import java.util.*;

public class Num210_CourseSchedule2 {

  // simplified version of alien dictionary
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer> result = new LinkedList<>();

    if (prerequisites.length == 0) {
      result.add(0);
      return result.stream().mapToInt(i -> i).toArray();
    }

    // step 1: build the graph
    Map<Integer, List<Integer>> dependencyGraph = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      dependencyGraph.put(i, new ArrayList<>());
      countMap.put(i, 0);
    }

    for (int[] relation : prerequisites) {
      int prerequsiteCourse = relation[1];
      int dependentCourse = relation[0];

      dependencyGraph.get(prerequsiteCourse).add(dependentCourse);
      countMap.put(dependentCourse, countMap.get(dependentCourse) + 1);
    }

    // step 2: iterate graph
    Queue<Integer> queue = new LinkedList<>();
    for (int key : countMap.keySet()) {
      if (countMap.get(key) == 0) {
        queue.add(key);
      }
    }
    while (!queue.isEmpty()) {
      int course = queue.poll();
      result.add(course);
      List<Integer> list = dependencyGraph.get(course);
      for (int c : list) {
        if (countMap.get(c) == 1) {
          queue.add(c);
        }
        countMap.put(c, countMap.get(c) - 1);
      }
    }
    if (result.size() < numCourses) {
      return new int[0];
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
