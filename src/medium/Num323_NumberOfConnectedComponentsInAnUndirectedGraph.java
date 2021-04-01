package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num323_NumberOfConnectedComponentsInAnUndirectedGraph {

  public int countComponents(int n, int[][] edges) {

    // step 1: construct the graph
    Map<Integer, Boolean> visited = new HashMap<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      visited.put(i, false);
    }

    for (int[] edge : edges) {
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new ArrayList<>());
      }
      if (!graph.containsKey(edge[1])) {
        graph.put(edge[1], new ArrayList<>());
      }

      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    // step 2: visit graph
    int counter = 0;
    for (int key : graph.keySet()) {
      if (visited.get(key)) {
        continue;
      }
      counter++;
      visitDFS(key, visited, graph);
    }
    for (boolean v : visited.values()) {
      if (!v) counter++;
    }
    return counter;
  }

  private void visitDFS(int key, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> graph) {
    if (visited.get(key)) {
      return;
    }
    visited.put(key, true);
    for (int neighbor : graph.get(key)) {
      visitDFS(neighbor, visited, graph);
    }
  }


  static int nodeCount;

  public int countComponentsUnionFind(int n, int[][] edges) {
    int[] parent = new int[n + 1];
    nodeCount = n;
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }


    int res = 0;

    for (int[] c : edges) {
      int x = c[0], y = c[1];
      if (findParent(parent, x) != findParent(parent, y)) {
        union(parent, x, y);
      }
    }

    return nodeCount;
  }

  private void union(int[] parent, int x, int y) {
    int px = findParent(parent, x);
    int py = findParent(parent, y);

    if (px != py) {
      parent[py] = px;
      nodeCount--;
    }
  }

  private int findParent(int[] parent, int x) {
    if (parent[x] == x) {
      return parent[x];
    }
    parent[x] = findParent(parent, parent[x]); // path compression
    return parent[x];
  }
}
