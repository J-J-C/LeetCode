package q101_to_q200;

import java.util.HashMap;
import java.util.Map;

public class Num170_TwoSum_III_ClassDesign {


    /**
     * Initialize your data structure here.
     */
    public Num170_TwoSum_III_ClassDesign() {
        this.hashMap = new HashMap<>();
    }

    private Map<Integer, Integer> hashMap;

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if(this.hashMap.containsKey(number)) {
            this.hashMap.put(number, this.hashMap.get(number) + 1);
        } else {
            this.hashMap.put(number, 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int a : this.hashMap.keySet()) {
            System.out.println(hashMap.get(a));

            if (hashMap.containsKey(value - a)) {
                if(value - a == a) {
                    if(hashMap.get(a) > 1) {
                        return true;
                    } else {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Num170_TwoSum_III_ClassDesign twoSum_iii_classDesign = new Num170_TwoSum_III_ClassDesign();
        twoSum_iii_classDesign.add(0);
        twoSum_iii_classDesign.add(0);
        System.out.println(twoSum_iii_classDesign.find(0));
    }
}