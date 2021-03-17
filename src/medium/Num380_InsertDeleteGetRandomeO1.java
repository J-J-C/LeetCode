package medium;

import java.util.*;

public class Num380_InsertDeleteGetRandomeO1 {

    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public Num380_InsertDeleteGetRandomeO1() {
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);
        // delete the last element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
