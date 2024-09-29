package 赎金信;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer>map = new HashMap<>();

        for (Character c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String ransomNote = "aa", magazine = "aab";

        Solution sol = new Solution();
        boolean ret = sol.canConstruct(ransomNote, magazine);

        System.out.println(ret);
    }
}



