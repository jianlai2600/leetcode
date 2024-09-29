package 查找共用字符;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> commonChars(String[] words) {

        List<String>ret = new ArrayList<>();

        Map<Character, Integer>map = new HashMap<>();
        for (Character c : words[0].toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for (String word : words) {

            Map<Character, Integer>wordMap = new HashMap<>();
            for (Character c : word.toCharArray()) {
                wordMap.putIfAbsent(c, 0);
                wordMap.put(c, wordMap.get(c) + 1);
            }

            for (Character key : map.keySet()) {
                if (!wordMap.containsKey(key)) {
                    map.put(key, 0);
                    continue;
                }
                if (map.get(key) > wordMap.get(key)) {
                    map.put(key, wordMap.get(key));
                }
            }
        }

        for (Character c : map.keySet()) {
            for (int i = 0; i < map.get(c); i++) {
                ret.add(c.toString());
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        String[] words = {"bella","label","roller"};

        Solution sol = new Solution();
        List<String> ret = sol.commonChars(words);

        System.out.println(ret);
    }
}



