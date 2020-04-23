package string;

import java.util.Arrays;

public class Num165_CompareVersionNumbers {


    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.0.0"));
    }

    public static int compareVersion(String version1, String version2) {

//        version1 = version1.replaceAll("\\.", "").replaceAll("0+$", "");
//        version2 = version2.replaceAll("\\.", "").replaceAll("0+$", "");

//        System.out.println(version1);
//        System.out.println(version2);
        String[] v1Array = version1.split("\\.");
        String[] v2Array = version1.split("\\.");

        System.out.println(Arrays.toString(v1Array));
        System.out.println(Arrays.toString(v2Array));

        int minVersionLength = v1Array.length < v2Array.length ? v1Array.length : v2Array.length;
        for (int i = 0; i < minVersionLength; i++) {
            int v1_ = Integer.parseInt(v1Array[i]);
            int v2_ = Integer.parseInt(v2Array[i]);
            if (v1_ < v2_) {
                return -1;
            }
            if (v1_ > v2_) {
                return 1;
            }
        }
        if (v1Array.length == v2Array.length) {
            return 0;
        }
        if (minVersionLength == v1Array.length) {
            for (int i = v1Array.length; i < v2Array.length; i++) {
                if (Integer.parseInt(v2Array[i]) > 0) {
                    return -1;
                }
            }
        } else {
            for (int i = v2Array.length; i < v1Array.length; i++) {
                if (Integer.parseInt(v1Array[i]) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
}