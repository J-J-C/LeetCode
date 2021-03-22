package medium;

public class Num547_NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    int counter = 0;
    if (isConnected.length <= 1) {
      return isConnected.length;
    }
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected.length; j++) {
        if (isConnected[i][j] == 1) {
          isConnected[i][j] = 0;
          isConnected[j][i] = 0;
          dfs(isConnected, i);
          counter++;
        }
      }
    }
    return counter;
  }

  public void dfs(int[][] isConnected, int next) {
    int[] row = isConnected[next];
    for (int i = 0; i < row.length; i++) {
      if (row[i] == 1) {
        row[i] = 0;
        isConnected[i][next] = 0;
        dfs(isConnected, i);
      }
    }
  }

  public void dfs(int[][] M, int[] visited, int i) {
    for (int j = 0; j < M.length; j++) {
      if (M[i][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(M, visited, j);
      }
    }
  }

  public int findCircleNum2(int[][] M) {
    int[] visited = new int[M.length];
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      if (visited[i] == 0) {
        dfs(M, visited, i);
        count++;
      }
    }
    return count;
  }
}
