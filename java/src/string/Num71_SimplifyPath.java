package string;

import java.util.Stack;

public class Num71_SimplifyPath {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home/"));
  }

  public static String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] array = path.split("/");

    for (String directory : array) {
      if (directory.equals(".") || directory.equals("")) {
        continue;
      }
      if (directory.equals("..")) {
        if (!stack.empty()) {
          stack.pop();
        }
      } else {
        stack.push(directory);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    StringBuilder builder = new StringBuilder();
    builder.append("/");
    for (String s : stack) {
      builder.append(s).append("/");
    }
    return builder.substring(0, builder.length() - 1);
  }
}
