package 仅执行一次字符串交换能否使两个字符串相等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[]map = new int[26];

        List<Character>list = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            map[c1 - 'a']++;
            map[c2 - 'a']--;

            if (c1 != c2) {
                list.add(c1);
                list.add(c2);
                cnt++;
            }
        }
        if (cnt == 2 && list.get(0) == list.get(3) && list.get(1) == list.get(2)) {
            return true;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        String s1 = "kelb", s2 = "kelb";

        Solution sol = new Solution();
        boolean ret = sol.areAlmostEqual(s1, s2);

        System.out.println(ret);
    }
}



