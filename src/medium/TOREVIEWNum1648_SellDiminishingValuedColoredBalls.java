package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TOREVIEWNum1648_SellDiminishingValuedColoredBalls {
  public static void main(String[] args) {
    //

    long value = 1000000000;
    long answer = (value % (long) (Math.pow(10, 9) + 7));
    System.out.println(answer);
  }

  public int maxProfit(int[] inventory, int orders) {
    int mod = 1000000007;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int num : inventory) {
      pq.offer(num);
    }

    int cur = pq.poll();
    int count = 1; // When pq poll the next element, +1 to count.
    long res = 0;
    while (orders > 0) {
      int next = pq.isEmpty() ? 0 : pq.peek();
      // If the number for [next + 1, cur] less than orders, add them ALL.
      if ((cur - next) * count <= orders) {
        // Add all the sum, and don't forget cast!
        long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
        res = (res + num) % mod;
        orders -= (cur - next) * count;
      } else {
        // If the number for [next + 1, cur] greater than orders, only add partially.
        // Calculate the new next where the add stops.
        next = cur - orders / count;
        long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
        res = (res + num) % mod;
        // For the last number to add (new next), and don't forget cast! I forget here in contest!
        res = (res + 1L * next * (orders % count)) % mod;
        orders = 0;
      }

      if (!pq.isEmpty()) cur = pq.poll();
      count++;
    }
    return (int) res;
  }

  public int maxProfit2(int[] inventory, int orders) {

    long sum = 0;
    if (inventory.length == 1) {
      int value = inventory[0];
      while (orders > 0) {
        sum += value;
        value--;
        orders--;
      }
      return (int) (sum % (int) (Math.pow(10, 9) + 7));
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int ball : inventory) {
      priorityQueue.add(ball);
    }

    while (orders > 0) {
      int value = priorityQueue.poll();
      sum += value;
      priorityQueue.add(value - 1);
      orders--;
    }

    return (int) (sum % (int) (Math.pow(10, 9) + 7));
  }
}
