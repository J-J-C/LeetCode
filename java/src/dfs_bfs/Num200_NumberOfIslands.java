package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Num200_NumberOfIslands {


    public static void main(String[] args) {
        char[][] array = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslandsBFS(array));
    }

    public static int numIslandsBFS(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int result = 0;
        int nc = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.add(i * nc + j);
                    while (!queue.isEmpty()) {
                        int v = queue.poll();
                        int vx = v / nc;
                        int vy = v % nc;
                        grid[vx][vy] = '0';
                        if (vy - 1 >= 0 && grid[vx][vy - 1] == '1') {
                            queue.add((vx * nc + vy - 1));
                            grid[vx][vy - 1] = '0';

                        }
                        if (vx - 1 >= 0 && grid[vx - 1][vy] == '1') {
                            queue.add((vx - 1) * nc + vy);
                            grid[vx - 1][vy] = '0';
                        }
                        if (vy + 1 < grid[0].length && grid[vx][vy + 1] == '1') {
                            queue.add(vx * nc + vy + 1);
                            grid[vx][vy + 1] = '0';

                        }
                        if (vx + 1 < grid.length && grid[vx + 1][vy] == '1') {
                            queue.add((vx + 1) * nc + vy);
                            grid[vx + 1][vy] = '0';

                        }
                    }
                }

            }
        }
        return result;
    }

    public static int numIslands(char[][] grid) {
        return 0;
    }

}
