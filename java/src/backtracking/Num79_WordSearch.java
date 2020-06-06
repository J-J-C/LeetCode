package backtracking;

public class Num79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        if (board.length == 1) {
            return word.equals(new String(board[0]));
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) {
                    continue;
                } else {
                    boolean result = searchNeighbour(board, word, 0, i, j);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean searchNeighbour(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        // mark node visited for current path
        board[i][j] ^= 256;
        boolean exist = false;
        exist = searchNeighbour(board, word, index + 1, i, j + 1)
                || searchNeighbour(board, word, index + 1, i, j - 1)
                || searchNeighbour(board, word, index + 1, i - 1, j)
                || searchNeighbour(board, word, index + 1, i + 1, j);
        // we cannot find it, so unmark for next path search
        board[i][j] ^= 256;
        return exist;
    }
}
