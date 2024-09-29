package 有效的字母异位词;


import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[]alpha = new int[26];

        for (Character c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        for (Character c : t.toCharArray()) {
            alpha[c - 'a']--;
            if (alpha[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";
        Solution sol = new Solution();
        boolean ret = sol.isAnagram(s, t);

        System.out.println(ret);
    }
}



