package oop;

import java.util.Stack;

public class Num155_MinStack {

  public Stack<Integer> currentStack = new Stack<>();
  public Stack<Integer> minStack = new Stack();
  public int min;

  public Num155_MinStack() {
  }

  public void push(int x) {
    if (currentStack.isEmpty()) {
      minStack.push(x);
      min = x;
    } else {
      if (x <= min) {
        minStack.push(x);
        min = x;
      }
    }
    currentStack.push(x);

  }

  public void pop() {
    if (currentStack.peek() == min) {
      minStack.pop();
      min = minStack.peek();
    }
    currentStack.pop();
  }

  public int top() {
    return currentStack.peek();
  }

  public int getMin() {
    return min;

  }
}