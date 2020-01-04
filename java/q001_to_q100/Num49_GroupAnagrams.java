package q001_to_q100;

import java.util.*;

public class Num49_GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramList = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String word: strs) {

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String newWord = new String(charArray);

            if(map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                anagramList.add(list);
                map.put(newWord, list);
            }
        }
        return anagramList;
    }
}
