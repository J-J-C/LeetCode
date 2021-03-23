package series.design;

import java.util.Stack;

public class Num1472_DesignBrowserHistory {
}

class BrowserHistory {

  Stack<String> backWard;
  Stack<String> forward;
  String homepage;

  public BrowserHistory(String homepage) {
    this.homepage = homepage;
    backWard = new Stack<>();
    forward = new Stack<>();
  }

  public void visit(String url) {
    backWard.push(url);
    forward = new Stack<>();
  }

  public String back(int steps) {
    int count = 0;
    while (!backWard.isEmpty()) {
      forward.push(backWard.pop());
      count++;
      if (count == steps) {
        break;
      }
    }
    return backWard.isEmpty() ? homepage : backWard.peek();
  }

  public String forward(int steps) {
    int count = 0;
    while (!forward.isEmpty()) {
      backWard.push(forward.pop());
      count++;
      if (count == steps) {
        break;
      }
    }
    return backWard.isEmpty() ? homepage : backWard.peek();
  }
}
