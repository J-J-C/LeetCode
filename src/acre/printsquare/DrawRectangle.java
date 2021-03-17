package acre.printsquare;

/**
 * 第二轮coding： 画长形状，输入条件比如说让你画一个长为3，竖为4的长方形，长用"-",宽用"|"，然后两个长等于一个竖（因为长比较短），然后四个拐角处用这个特别的符号 “⌜”。
 * 反正就是画长方形（print出来）。
 * 第一个followup是位移，比如说把向下位移三个空间，向右位移2个空间之类的。
 * 第二个followup是一次性画多个长方形，重叠的部分要处理，比如说一个长方形的长和另一个长方形的竖重叠了，你就要换成’+‘十字符号。他会告诉你什么情况的重叠换成什么符号。
 */
public class DrawRectangle {

  private static final char STAR = '*';

  // does corner count
  private static final char TOP_LEFT_CORNER = '⌜';
  private static final char TOP_RIGHT_CORNER = '⌝';
  private static final char BOTTOM_LEFT_CORNER = '⌞';
  private static final char BOTTOM_RIGHT_CORNER = '⌟';

  // 3 width == 3 - being printed?
  private static final char WIDTH = '-';
  // 3 height == 3 | being printed?
  private static final char HEIGHT = '|';

  public static void main(String[] args) {
    DrawRectangle drawRectangle = new DrawRectangle();
    //    drawRectangle.fillSquare(4, 4);

    //    char[][] square = drawRectangle.fillShiftedSquare(2, 0, 4, 4);

    char[][] array = new char[8][8];
    fillStar(array);

    // size 4,4
    char[][] square = drawRectangle.fillSquare(array, 0, 0, 4, 4);
    drawRectangle.printCharArray(square);

    System.out.println("--------------------------------");
    // size 4,4
    square = drawRectangle.fillShiftedSquare(array, 2, 2, 4, 4);
    drawRectangle.printCharArray(square);

    System.out.println("-----------------------");

    // this generic can be applied, we define with rec1 to be top left and rec2 to be bottom right
    int r1XT = 0;
    int r1YT = 0;
    int r1XB = 4;
    int r1YB = 4;

    int r2XT = 2;
    int r2YT = 2;
    int r2XB = 6;
    int r2YB = 6;

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        // this capture all overlapped area
        if (i >= r2XT && i <= r1XB + 1) {
          if (j >= r2YT && j <= r1YB + 1) {
            // depends on whats in the box, we can do some modification accordingly
            if (array[i][j] == '*') {
              array[i][j] = '@';
            }
          }
        }
      }
    }
    drawRectangle.printCharArray(array);
  }

  public char[][] fillShiftedSquare(char[][] array, int xShift, int yShift, int row, int column) {
    char[][] filledSquare = fillSquare(array, xShift, yShift, row + xShift, column + yShift);
    return filledSquare;
  }

  public char[][] fillSquare(
          char[][] array, int startRow, int startColumn, int endRow, int endColumn) {

    fillInHeight(array, startRow, startColumn, endRow, endColumn);
    fillInWidth(array, startRow, startColumn, endRow, endColumn);
    fillInCorner(array, startRow, startColumn, endRow, endColumn);

    return array;
  }

  private static void fillStar(char[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        array[i][j] = STAR;
      }
    }
  }

  private void fillInCorner(
          char[][] array, int startRow, int startColumn, int endRow, int endColumn) {
    array[startRow][startColumn] = TOP_LEFT_CORNER;
    array[startRow][endColumn + 1] = TOP_RIGHT_CORNER;
    array[endRow + 1][startColumn] = BOTTOM_LEFT_CORNER;
    array[endRow + 1][endColumn + 1] = BOTTOM_RIGHT_CORNER;
  }

  private void fillInWidth(
          char[][] array, int startRow, int startColumn, int endRow, int endColumn) {
    char[] top = array[startRow];
    char[] bottom = array[endRow + 1];
    for (int i = startColumn; i <= endColumn + 1; i++) {
      top[i] = WIDTH;
      bottom[i] = WIDTH;
    }
  }

  private void fillInHeight(
          char[][] array, int startRow, int startColumn, int endRow, int endColumn) {
    for (int i = startRow; i <= endRow; i++) {
      array[i][startColumn] = HEIGHT;
      array[i][endColumn + 1] = HEIGHT;
    }
  }

  public void printCharArray(char[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
}
