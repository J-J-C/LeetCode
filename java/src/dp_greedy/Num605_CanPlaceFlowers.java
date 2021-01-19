package dp_greedy;

public class Num605_CanPlaceFlowers {

  public static void main(String[] args) {
    int[] array = {1, 0, 1, 0, 1, 0, 1};
    int n = 1;
    //    System.out.println(canPlaceFlowers(array, n));

    int[] array2 = {1, 0, 0, 0, 1, 0, 0};
    n = 2;
    System.out.println(canPlaceFlowers(array2, n));
  }

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {

    if (n == 0) return true;
    if (flowerbed.length == 1) {
      return n == 1 && flowerbed[0] == 0;
    }

    // handle special case: head
    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      n--;
      flowerbed[0] = 1;
    }

    int index = 1;
    int previous = index - 1;
    int next = index + 1;

    // general case
    while (index < flowerbed.length - 1) {
      if (flowerbed[index] == 1) {

      } else if (flowerbed[previous] == 0 && flowerbed[next] == 0 && flowerbed[index] == 0) {
        n--;
        flowerbed[index] = 1;
      }
      if (n <= 0) {
        break;
      }
      index++;
      previous++;
      next++;
    }

    // handle special case, tail
    if (flowerbed[previous] == 0 && flowerbed[index] == 0) {
      n--;
    }

    return n <= 0;
  }
}
