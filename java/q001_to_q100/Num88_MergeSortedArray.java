package q001_to_q100;

public class Num88_MergeSortedArray {


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int backPointer1 = m - 1;
        int backPointer2 = n - 1;
        int index = m + n - 1;
        while (backPointer1 != -1 || backPointer2 != -1) {

            if (backPointer1 == -1) {
                nums1[index] = nums2[backPointer2];
                backPointer2--;
                index--;
            } else if (backPointer2 == -1) {
                nums1[index] = nums1[backPointer1];
                backPointer1--;
                index--;
            } else {

                int num1 = nums1[backPointer1];
                int num2 = nums2[backPointer2];

                if (num1 >= num2) {
                    nums1[index] = num1;
                    index--;
                    backPointer1--;
                } else {
                    nums1[index] = num2;
                    index--;
                    backPointer2--;
                }
            }
        }
    }
}
