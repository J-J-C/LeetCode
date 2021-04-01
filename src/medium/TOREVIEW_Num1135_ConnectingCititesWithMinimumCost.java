package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TOREVIEW_Num1135_ConnectingCititesWithMinimumCost {
  int[] parent;
  int n;

  private void union(int x, int y) {
    int px = find(x);
    int py = find(y);

    if (px != py) {
      parent[py] = px;
      n--;
    }
  }

  private int find(int x) {
    if (parent[x] == x) {
      return parent[x];
    }
    parent[x] = find(parent[x]); // path compression
    return parent[x];
  }

  public int minimumCost(int N, int[][] connections) {
    parent = new int[N + 1];
    n = N;
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));

    int res = 0;

    for (int[] c : connections) {
      int x = c[0], y = c[1];
      if (find(x) != find(y)) {
        res += c[2];
        union(x, y);
      }
    }

    return n == 1 ? res : -1;
  }
}
