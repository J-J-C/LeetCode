package medium;

import java.util.*;

public class Num1152_AnalyzeUserWebsiteVisitPattern {

  public static void main(String[] args) {
    //
    String[] username = {
            "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"
    };
    String[] website = {
            "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"
    };

    System.out.println(Arrays.toString(mostVisitedPattern(username, null, website).toArray()));
  }

  public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    Map<String, List<Pair>> userVisitMap = new HashMap<>();
    int n = username.length;
    // collect the website info for every user, key: username, value: (timestamp, website)
    for (int i = 0; i < n; i++) {
      userVisitMap.putIfAbsent(username[i], new ArrayList<>());
      userVisitMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
    }

    // count map to record every 3 combination occuring time for the different user.
    Map<String, Integer> count = new HashMap<>();
    String result = "";
    for (String user : userVisitMap.keySet()) {
      Set<String> set = new HashSet<>();
      // this set is to avoid visit the same 3-seq in one user
      List<Pair> list = userVisitMap.get(user);
      Collections.sort(list, Comparator.comparingInt(a -> a.time)); // sort by time
      // brutal force O(N ^ 3)

      for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
          for (int k = j + 1; k < list.size(); k++) {
            String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
            if (!set.contains(str)) {
              count.put(str, count.getOrDefault(str, 0) + 1);
              set.add(str);
            }
            if (result.equals("") || count.get(result) < count.get(str) || (count.get(result) == count.get(str) && result.compareTo(str) > 0)) {
              // make sure the right lexi order
              result = str;
            }
          }
        }
      }

    }
    // grab the right answer
    String[] r = result.split(" ");
    List<String> resultList = new ArrayList<>();
    for (String str : r) {
      resultList.add(str);
    }
    return resultList;
  }


  static class Pair {
    int time;
    String web;

    public Pair(int time, String web) {
      this.time = time;
      this.web = web;
    }
  }
}

