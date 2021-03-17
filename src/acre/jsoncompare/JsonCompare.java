package acre.jsoncompare;

import java.util.List;
import java.util.Map;

public class JsonCompare {

  /*
   * Ideally, will start with the basics
   *
   * 1. assume only primitive in diction
   * 2. assume only primitive + dict (primitive only)
   * 3. assume only primitive + list (primitive only)
   *
   * 4. assume dict + dict, recursion....
   * 5. assume list + list, recursion....
   *
   * 6. dict + n* (dict + list)
   */
  public boolean isTwoJsonSame(Map<String, Object> json1, Map<String, Object> json2) {
    // check size first
    if (json1.size() != json2.size()) {
      return false;
    }
    for (String key : json1.keySet()) {
      if (!json2.containsKey(key)) {
        return false;
      } else {
        Object value1 = json1.get(key);
        Object value2 = json2.get(key);
        // check type
        Class classType = value1.getClass();
        if (!classType.equals(value2.getClass())) {
          return false;
        }
        // handle different case, list and map are most complicated
        if (classType.equals(Map.class)) {
          // recursively process map
          boolean result =
                  isTwoJsonSame(
                          (Map<String, Object>) json1.get(key), (Map<String, Object>) json2.get(key));
          if (result == false) {
            return false;
          }
        }
        // call helper to process list
        if (classType.equals(List.class)) {
          boolean result =
                  compareList((List<Object>) json1.get(key), (List<Object>) json2.get(key));
          if (result == false) {
            return false;
          }
        }
        // primitive type comparison is the easiest
        else {
          if (json1.get(key) != json2.get(key)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean compareList(List<Object> objects1, List<Object> objects2) {
    // size diff, false immediately
    if (objects1.size() != objects2.size()) {
      return false;
    }
    // both list empty, return true due to recursion comparison
    if (objects1.size() == 0) {
      return true;
    }
    Object o1 = null;
    Object o2 = null;
    boolean foundSame = false;
    for (int i = 0; i < objects1.size(); i++) {
      o1 = objects1.get(i);
      boolean foundType = true;
      for (int j = 0; i < objects2.size(); j++) {
        o2 = objects2.get(j);
        // check the type first
        if (o1.getClass().equals(o2.getClass())) {

          if (o1.getClass().equals(Map.class)) {
            foundSame = isTwoJsonSame((Map<String, Object>) o1, (Map<String, Object>) o2);
            if (!foundSame) {
              return false;
            }
          }
          if (o1.getClass().equals(List.class)) {
            foundSame = compareList((List<Object>) o1, (List<Object>) o2);
            if (!foundSame) {
              return false;
            }
          }

          // if one miss match found, return false;
          if (o1 != o2) {
            return false;
          } else {
            foundSame = true;
            break;
          }
        }
      }
      // if no same type found, return false immediately
      if (!foundType) {
        return false;
      }
    }
    // two identical item found, remove them an compare the rest of the list;
    if (foundSame) {
      // ideally, a copy should be pass down....
      objects1.remove(o1);
      objects2.remove(o2);
      return compareList(objects1, objects2);
    } else {
      return false;
    }
  }
}
