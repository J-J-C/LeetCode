package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Num994_RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                if (grid[row][column] == 2) {
                    queue.add(new int[]{row + 1, column});
                    queue.add(new int[]{row - 1, column});
                    queue.add(new int[]{row, column + 1});
                    queue.add(new int[]{row, column - 1});
                }
            }
        }

        int counter = rotten(grid, queue, 0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return counter;
    }

    public int rotten(int[][] oranges, Queue<int[]> queue, int counter) {

        if (queue.isEmpty()) {
            return counter;
        }
        Queue<int[]> newQueue = new LinkedList<>();
        boolean isRotten = false;
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int column = position[1];
            if (row < 0 || column < 0 || row >= oranges.length || column >= oranges[0].length) {
            } else {
                if (oranges[row][column] == 1) {
                    oranges[row][column] = 2;
                    newQueue.add(new int[]{row + 1, column});
                    newQueue.add(new int[]{row - 1, column});
                    newQueue.add(new int[]{row, column + 1});
                    newQueue.add(new int[]{row, column - 1});
                    isRotten = true;
                }
            }
        }

        return isRotten ? rotten(oranges, newQueue, counter + 1) : counter;
    }
}
