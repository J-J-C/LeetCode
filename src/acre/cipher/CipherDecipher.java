package acre.cipher;

public class CipherDecipher {

  public String cipher(char[][] table, String text) throws Exception {
    StringBuilder builder = new StringBuilder();
    for (char c : text.toCharArray()) {
      builder.append(cipher(table, c));
    }
    return builder.toString();
  }

  public String cipher(char[][] table, char c) {
    for (int row = 0; row < table.length; row++) {
      for (int column = 0; column < table[0].length; column++) {
        if (table[row][column] == c) {
          return "" + row + column;
        }
      }
    }
    throw new UnsupportedOperationException();
  }

  // problem, only works when matrix size < 9*9
  public String decipher(char[][] table, String text) {
    StringBuilder builder = new StringBuilder();
    for (String number : text.split("[^0-9]+")) {
      int row = number.charAt(0) - '0';
      int column = number.charAt(1) - '0';
      builder.append(decipher(table, row, column));
    }
    return builder.toString();
  }

  public String decipher(char[][] table, int row, int column) {
    if (row < 0 || row >= table.length || column < 0 || column >= table[0].length) {
      throw new IllegalArgumentException();
    }

    return "" + table[row][column];
  }
}
