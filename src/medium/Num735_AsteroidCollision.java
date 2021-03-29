package medium;

import java.util.Arrays;
import java.util.Stack;

public class Num735_AsteroidCollision {

  public static void main(String[] args) {
    //
    int[] arr1 = {-3, -8, -4, 5, -2, 8, 10, -10, -7, 4};
    System.out.println(Arrays.toString(asteroidCollision(arr1)));
  }

  public static int[] asteroidCollision(int[] asteroids) {
    if (asteroids.length <= 1) {
      return asteroids;
    }

    Stack<Integer> stack = new Stack<>();

    stack.push(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {
//      System.out.println(Arrays.toString(stack.toArray()));
      if (stack.isEmpty()) {
        stack.push(asteroids[i]);
        continue;
      }
      if (asteroids[i] * stack.peek() > 0 || ((asteroids[i]) > 0 && stack.peek() < 0)) {
        stack.push(asteroids[i]);
      } else {
        int pop = stack.pop();
        int value = pop + asteroids[i];
        while (!stack.isEmpty() && value < 0 && stack.peek() > 0) {
          pop = stack.pop();
          value = pop + asteroids[i];
        }
        if (value == 0) {
          continue;
        }
        if (stack.isEmpty()) {
          if (value < 0) {
            stack.push(asteroids[i]);
          } else {
            stack.push(pop);
          }
        } else {
          if (stack.peek() < 0 && value < 0) {
            stack.push(asteroids[i]);
          } else {
            stack.push(pop);
          }
        }
      }
    }
    int[] res = new int[stack.size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = stack.pop();
    }
    return res;
//    return stack.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[] asteroidCollision2(int[] asteroids) {
    Stack<Integer> s = new Stack<>();
    for (int i : asteroids) {
      if (i > 0) {
        s.push(i);
      } else { // i is negative
        while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
          s.pop();
        }
        if (s.isEmpty() || s.peek() < 0) {
          s.push(i);
        } else if (i + s.peek() == 0) {
          s.pop(); // equal
        }
      }
    }
    int[] res = new int[s.size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = s.pop();
    }
    return res;
  }
}
