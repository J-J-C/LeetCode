package acre.mofang;

import java.util.*;

/**
 * 第三轮coding： 判断魔方是否正确，给你一个数组['wwwwwwwww' 'yyyyyyyyyyyy' ..........],
 * 里面的每一个string都代表魔方的一个面，每个string里的每一个char都代表颜色，比如说list[0][0]='w' 就代表魔方的第一面的最左上角是白色的。
 *
 * <p>第一问问你一共有多少颜色，符不符合规则。
 *
 * <p>第二问问你每个颜色分别有多少个，符不符合规则。 第三问问你魔方中心点的这6个颜色，合不合理，因为中心点的颜色不可能重叠嘛。 第四问问你每个角的颜色合不合理。
 */
public class Mofang {

  public static void main(String[] args) {
    //
  }

  public int getTotalColor(List<char[]> magicSquare) {
    Set<Character> set = new HashSet<>();

    magicSquare.forEach(
            array -> {
              for (char c : array) {
                set.add(c);
              }
            });
    System.out.println("Our square has exactly 6 color? " + (set.size() == 6));
    return set.size();
  }

  public Map<Character, Integer> getEachColorCount(List<char[]> magicSquare) {
    Map<Character, Integer> map = new HashMap<>();

    magicSquare.forEach(
            array -> {
              for (char c : array) {
                if (map.containsKey(c)) {
                  map.computeIfPresent(c, (character, integer) -> integer++);
                } else {
                  map.put(c, 1);
                }
              }
            });
    System.out.println("Our square has exactly 6 color? " + (map.size() == 6));
    boolean isSatisfied = true;
    for (char c : map.keySet()) {
      isSatisfied = isSatisfied && map.get(c) == 9;
      System.out.println("Our color " + c + " has exactly 9 count?" + (map.get(c) == 9));
    }

    return map;
  }

  public boolean checkCentralColor(List<char[]> magicSquare) {
    Set<Character> set = new HashSet<>();
    for (char[] chars : magicSquare) {
      char c = chars[4];
      if (set.contains(c)) {
        System.out.println("Color " + c + " already present in " + Arrays.toString(set.toArray()));
        return false;
      }
    }
    return true;
  }
}
