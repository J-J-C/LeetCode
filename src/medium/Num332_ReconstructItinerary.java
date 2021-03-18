package medium;

import java.util.*;

public class Num332_ReconstructItinerary {

  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> result = new ArrayList<>();
    if (tickets.size() == 0) {
      return result;
    }

    if (tickets.size() == 1) {
      return tickets.get(0);
    }

    Map<String, Node> map = new HashMap<>();

    // step 1: construct the graph
    for (List<String> ticket : tickets) {
      Node depNode = map.getOrDefault(ticket.get(0), new Node());
      Node arrNode = map.getOrDefault(ticket.get(1), new Node());

      depNode.name = ticket.get(0);
      arrNode.name = ticket.get(1);

      depNode.neighbors.add(arrNode);

      map.put(ticket.get(0), depNode);
      map.put(ticket.get(1), arrNode);
    }

    // visit the graph
    Node start = map.get("JFK");
    result.add("JFK");

    dfs(start, result);

    return result;
  }

  private void dfs(Node start, List<String> result) {
    PriorityQueue<Node> neighbors = start.neighbors;
    while (neighbors != null && !neighbors.isEmpty()) {
      Node peek = neighbors.poll();
      dfs(peek, result);
    }
    result.add(0, start.name);
  }
}

class Node {
  String name;
  PriorityQueue<Node> neighbors = new PriorityQueue<>(Comparator.comparing(o -> o.name));
}
