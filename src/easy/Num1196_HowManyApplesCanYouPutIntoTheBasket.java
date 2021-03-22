package easy;

import java.util.Arrays;

public class Num1196_HowManyApplesCanYouPutIntoTheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int limit = 5000;
        for (int n : arr) {
            limit -= n;
            count++;
            if (limit < 0) {
                return count - 1;
            }
        }
        return count;
    }
}
