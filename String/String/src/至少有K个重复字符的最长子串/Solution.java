package 至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer>map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) < k) {

                int res = 0;
                for (String sub : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(sub, k));
                }
                return res;
            }
        }

        return s.length();
    }
    public static void main(String[] args) {

        String s = "aaabb";
        int k = 3;

        Solution sol = new Solution();
        int ret = sol.longestSubstring(s, k);

        System.out.println(ret);
    }
}