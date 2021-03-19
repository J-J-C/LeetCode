package easy;

import java.util.HashMap;
import java.util.Map;

public class Num760_FindAnagramMappings {

  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      map.put(B[i], i);
    }

    int[] array = new int[A.length];
    for (int i = 0; i < array.length; i++) {
      array[i] = map.get(A[i]);
    }
    return array;
  }
}
