package medium;

import java.util.Arrays;

public class Num238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        //
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(array)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] productFromLeft = new int[nums.length];
        int[] productFromRight = new int[nums.length];

        productFromLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            productFromLeft[i] = productFromLeft[i - 1] * nums[i];
        }
        System.out.println(Arrays.toString(productFromLeft));

        productFromRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            productFromRight[i] = productFromRight[i + 1] * nums[i];
        }
        System.out.println(Arrays.toString(productFromRight));

        int[] products = new int[nums.length];

        for (int i = 1; i < nums.length - 1; i++) {
            products[i] = productFromLeft[i - 1] * productFromRight[i + 1];
        }
        System.out.println(Arrays.toString(products));

        products[0] = productFromRight[1];
        products[nums.length - 1] = productFromLeft[nums.length - 2];

        return products;
    }
}
