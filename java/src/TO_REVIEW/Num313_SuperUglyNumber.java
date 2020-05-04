package TO_REVIEW;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Num313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add((long) 1);
        long result = 0;
        while (n > 0) {
            long min = queue.poll();
            while (min == result) {
                min = queue.poll();
            }
            for (int i = 0; i < primes.length; i++) {
                queue.add(min * primes[i]);
            }
            result = min;
            n--;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        nthSuperUglyNumberI(n, primes);
    }

    // Follow up
    public static int nthSuperUglyNumberI(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length]; // what does it store

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[index[j]]);
            }
            System.out.println(Arrays.toString(ugly));
            System.out.println(Arrays.toString(index));
            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[index[j]] <= ugly[i]) {
                    index[j]++;
                }
            }
            System.out.println("--------------------------");
            System.out.println(Arrays.toString(ugly));
            System.out.println(Arrays.toString(index));
            System.out.println("===========================");
        }
        return ugly[n - 1];
    }
}
