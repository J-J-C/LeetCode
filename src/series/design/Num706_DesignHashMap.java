package series.design;

import java.util.LinkedList;

public class Num706_DesignHashMap {
}

class MyHashMap {

  Bucket[] buckets;
  int hashKey = 769;

  /**
   * Initialize your data structure here.
   */
  public MyHashMap() {
    buckets = new Bucket[hashKey];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new Bucket();
    }
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    System.out.println(hash(key));
    System.out.println(buckets[hash(key)]);
    buckets[hash(key)].add(key, value);
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    return buckets[hash(key)].get(key);
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    buckets[hash(key)].remove(key);
  }

  private int hash(int key) {
    return key % hashKey;
  }

  static class Bucket {
    LinkedList<int[]> list;

    public Bucket() {
      list = new LinkedList<>();
    }

    public int get(int key) {
      for (int[] pair : list) {
        if (pair[0] == key) {
          return pair[1];
        }
      }
      return -1;
    }

    public void add(int key, int value) {
      for (int[] pair : list) {
        if (pair[0] == key) {
          pair[1] = value;
          return;
        }
      }
      int[] pair = new int[]{key, value};
      list.add(pair);
    }

    public void remove(int key) {
      int index = 0;
      for (int[] pair : list) {
        if (pair[0] == key) {
          break;
        }
        index++;
      }
      if (index < list.size()) {
        list.remove(index);
      }
    }
  }
}
