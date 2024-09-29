package 字母异位词分组;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>>ret = new LinkedList<>();
        Map<String, List<String>>map = new HashMap<>();

        for (String s : strs) {
            int[]key = new int[26];
            for (Character c : s.toCharArray()) {
                key[c - 'a']++;
            }
            String keyStr = Arrays.toString(key);

            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new LinkedList<>());
            }
            map.get(keyStr).add(s);
        }

        for (Map.Entry<String, List<String>>entry : map.entrySet()) {
            ret.add(entry.getValue());
        }
        return ret;
    }
    public static void main(String[] args) {

        String[]strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution sol = new Solution();
        List<List<String>> ret = sol.groupAnagrams(strs);

        for (List<String>list : ret) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}



