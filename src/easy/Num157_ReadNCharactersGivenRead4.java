package easy;

public class Num157_ReadNCharactersGivenRead4 {
  public int read(char[] buf, int n) {

    if (n <= 4) {
      int temp = read4(buf);
      if (n < temp) {
        return n;
      } else {
        return temp;
      }

    } else {
      int total = 0;
      int index = 0;
      char[] tempBuf = new char[4];
      while (n > 0) {
        int temp = read4(tempBuf);
        boolean isChanged = false;
        for (int i = 0; i < temp; i++) {
          if (n > 0) {
            buf[index] = tempBuf[i];
            index++;
            n--;
            isChanged = true;
            total++;
          } else {
            buf[index] = 0;
            index++;
          }
        }
        if (!isChanged) {
          return total;
        }
        tempBuf = new char[4];
      }
      return total;
    }
  }

  public int read4(char[] buf4) {
    return 0;
  }
}
