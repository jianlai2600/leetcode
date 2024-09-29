package 同构字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character>map1 = new HashMap<>();
        HashMap<Character, Character>map2 = new HashMap<>();

        int n = s.length();
        for (int i = 0, j = 0; i < n; i++, j++) {

            if (map1.containsKey(s.charAt(i))) {
                if (map1.get(s.charAt(i)) != t.charAt(j)) {
                    return false;
                }
            } else {
                map1.put(s.charAt(i), t.charAt(j));
            }

            if (map2.containsKey(t.charAt(j))) {
                if (map2.get(t.charAt(j)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map2.put(t.charAt(j), s.charAt(i));
            }
        }

        return true;
    }
    public static void main(String[] args) {

        String s = "egg", t = "add";

        Solution sol = new Solution();
        boolean ret = sol.isIsomorphic(s, t);

        System.out.println(ret);
    }
}



