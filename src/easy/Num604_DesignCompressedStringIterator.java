package easy;

public class Num604_DesignCompressedStringIterator {
}

class StringIterator {

  String string;
  int index;
  int countIndex;
  int count;

  static final char ZEOR = '0';

  public StringIterator(String compressedString) {
    this.string = compressedString;
    this.index = 0;
    this.countIndex = 1;
    this.count = compressedString.charAt(1) - ZEOR;
    while (this.countIndex < string.length() - 1
            && string.charAt(this.countIndex + 1) >= '0'
            && string.charAt(this.countIndex + 1) <= '9') {
      this.countIndex++;
      this.count = this.count * 10 + string.charAt(this.countIndex) - '0';
    }
  }

  public char next() {
    if (index == string.length()) {
      return ' ';
    }
    char c = string.charAt(index);
    if (count > 0) {
      count--;
    }
    if (count == 0) {
      index = this.countIndex + 1;
      if (index < string.length()) {
        this.countIndex = index + 1;
        this.count = string.charAt(countIndex) - ZEOR;
        while (this.countIndex < string.length() - 1
                && string.charAt(this.countIndex + 1) >= '0'
                && string.charAt(this.countIndex + 1) <= '9') {
          this.countIndex++;
          this.count = this.count * 10 + string.charAt(this.countIndex) - '0';
        }
      }
    }
    return c;
  }

  public boolean hasNext() {
    return index < string.length() && count > 0;
  }
}
