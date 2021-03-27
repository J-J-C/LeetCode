package easy;

import java.util.*;

public class Num1436_DestinationCity {

  public String destCity(List<List<String>> paths) {

    // construct the graph
    Map<String, List<String>> graph = new HashMap<>();

    for (List<String> path : paths) {
      String departure = path.get(0);
      String destination = path.get(1);

      if (!graph.containsKey(destination)) {
        graph.put(destination, new ArrayList<>());
      }

      if (!graph.containsKey(departure)) {
        graph.put(departure, new ArrayList<>());
      }
      graph.get(departure).add(destination);
    }

    // find the node without any children
    String result = "";
    for (String key : graph.keySet()) {
      if (graph.get(key).size() == 0) {
        result = key;
        break;
      }
    }

    return result;
  }

  public String destCityTrick(List<List<String>> paths) {
    Set<String> set = new HashSet<>();
    for (List<String> l : paths) set.add(l.get(1));
    for (List<String> l : paths) set.remove(l.get(0));
    return set.iterator().next();
  }
}
