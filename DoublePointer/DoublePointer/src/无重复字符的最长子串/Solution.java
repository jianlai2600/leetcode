package 无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ret = 0;
        int left = 0, right = 0;
        Set<Character>set = new HashSet<>();

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (set.contains(rc)) {
                while (s.charAt(left) != rc) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(rc);
                ret = Math.max(ret, right - left + 1);
            }
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        Solution sol = new Solution();
        int ret = sol.lengthOfLongestSubstring(s);

        System.out.println(ret);
    }
}
