package q101_to_q200;

public class Num136_SingleNumber {

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

}
