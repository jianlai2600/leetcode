package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

class Solution {
    List<String>ret = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public void backTracking(int startIndex, String digits, Map<Character, List<Character>>map) {

        if (sb.length() == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < digits.length(); i++) {
            List<Character>list = map.get(digits.charAt(i));
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                backTracking(i + 1, digits, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return ret;
        }
        Map<Character, List<Character>>map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        backTracking(0, digits, map);
        return ret;
    }
    public static void main(String[] args) {

        String digits = "23";

        Solution sol = new Solution();
        List<String> ret = sol.letterCombinations(digits);

        for (String s : ret) {
            System.out.println("Answer: " + s);
        }
    }
}