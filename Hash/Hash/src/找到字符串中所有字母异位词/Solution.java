package 找到字符串中所有字母异位词;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isEqual(Map<Character, Integer>ms, Map<Character, Integer>mp) {

        for (Character key : mp.keySet()) {
            if (ms.containsKey(key) && ms.get(key).equals(mp.get(key))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {

        int m = s.length(), n = p.length();
        if (n > m) {
            return new ArrayList<>();
        }

        List<Integer>ret = new ArrayList<>();
        Map<Character, Integer>mp = new HashMap<>();
        for (Character c : p.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer>ms = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ms.put(c, ms.getOrDefault(c, 0) + 1);
        }

        for (int i = n; i < m; i++) {
            if (isEqual(ms, mp)) {
                ret.add(i - n);
            }
            char addC = s.charAt(i);
            char delC = s.charAt(i - n);
            ms.put(addC, ms.getOrDefault(addC, 0) + 1);
            ms.put(delC, ms.get(delC) - 1);
        }
        if (isEqual(ms, mp)) {
            ret.add(m - n);
        }

        return ret;
    }
    public static void main(String[] args) {

        String s = "abab", p = "ab";

        Solution sol = new Solution();
        List<Integer>ret = sol.findAnagrams(s, p);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



