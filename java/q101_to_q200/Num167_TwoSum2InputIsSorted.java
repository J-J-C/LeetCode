package q101_to_q200;

public class Num167_TwoSum2InputIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if(numbers[head] + numbers[tail] == target) {
                result[0] = head;
                result[1] = tail;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                tail--;
            }
        }
        return result;
    }
}
