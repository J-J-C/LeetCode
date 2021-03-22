package series.design;

public class Num348_DesignTicTacToe {
}

class TicTacToe {
  int[][] board;

  /**
   * Initialize your data structure here.
   */
  public TicTacToe(int n) {
    board = new int[n][n];
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   *
   * @param row    The row of the board.
   * @param col    The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2:
   * Player 2 wins.
   */
  public int move(int row, int col, int player) {
    board[row][col] = player;
    return hasWinner();
  }

  public int hasWinner() {
    // check all rows
    for (int row = 0; row < board.length; row++) {
      int w = checkRow(board[row]);
      if (w > 0) {
        return w;
      }
    }

    // check all columns
    for (int column = 0; column < board.length; column++) {
      int w = board[0][column];
      boolean foundWinner = true;
      for (int row = 0; row < board.length; row++) {
        if (board[row][column] != w || board[row][column] == 0) {
          foundWinner = false;
          break;
        }
      }
      if (foundWinner) {
        return w;
      }
    }

    // check diagonal
    int w = board[0][0];
    boolean foundWinner = true;
    for (int i = 1; i < board.length; i++) {
      if (board[i][i] != w || board[i][i] == 0) {
        foundWinner = false;
      }
    }
    if (foundWinner) {

      return w;
    }

    int size = board.length - 1;
    w = board[size][0];
    foundWinner = true;
    for (int i = 0; i < board.length; i++) {
      if (board[size - i][i] != w || board[size - i][i] == 0) {
        foundWinner = false;
      }
    }
    if (foundWinner) {

      return w;
    }
    return 0;
  }

  private int checkRow(int[] row) {
    int winner = row[0];
    for (int column = 1; column < row.length; column++) {
      if (row[column] != winner || row[column] == 0) {
        return 0;
      }
    }
    return winner;
  }
}
