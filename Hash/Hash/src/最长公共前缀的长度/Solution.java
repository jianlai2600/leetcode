package 最长公共前缀的长度;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<String> set = new HashSet<>();

        for (Integer num : arr1) {
            String s = num.toString();
            for (int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }

        int res = 0;
        for (Integer num : arr2) {
            String s = num.toString();
            for (int i = 1; i <= s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    if (i > res) {
                        res = i;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[]arr1 = {1,10,100}, arr2 = {1000};

        Solution sol = new Solution();
        int ret = sol.longestCommonPrefix(arr1, arr2);

        System.out.println(ret);
    }
}



