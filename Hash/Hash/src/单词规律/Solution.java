package 单词规律;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<String, Character>map1 = new HashMap<>();
        HashMap<Character, String>map2 = new HashMap<>();

        String[]arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {

            char c = pattern.charAt(i);
            String word = arr[i];

            if (map1.containsKey(word)) {
                if (c == map1.get(word)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map2.containsKey(c)) {
                    if (!map2.get(c).equals(word)) {
                        return false;
                    }
                } else {
                    map1.put(word, c);
                    map2.put(c, word);
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

        String pattern = "abba", s = "dog cat cat fish";

        Solution sol = new Solution();
        boolean ret = sol.wordPattern(pattern, s);

        System.out.println(ret);
    }
}



