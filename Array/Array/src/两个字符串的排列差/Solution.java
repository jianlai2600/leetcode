package 两个字符串的排列差;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPermutationDifference(String s, String t) {

        Map<Character, Integer>map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int ret = 0;
        for (int i = 0; i < t.length(); i++) {
            ret += Math.abs(i - map.get(t.charAt(i)));
        }

        return ret;
    }
    public static void main(String[] args) {

        String s = "abc", t = "bac";

        Solution sol = new Solution();
        int ret = sol.findPermutationDifference(s, t);

        System.out.println(ret);
    }
}