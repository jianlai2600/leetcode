package 最长回文串;

class Solution {

    public int longestPalindrome(String s) {

        int res = 0;

        int[]lower = new int[26];
        int[]upper = new int[26];

        for (Character c : s.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                lower[c - 'a']++;
                if (lower[c - 'a'] >= 2) {
                    res += 2;
                    lower[c - 'a'] -= 2;
                }
            } else {
                upper[c - 'A']++;
                if (upper[c - 'A'] >= 2) {
                    res += 2;
                    upper[c - 'A'] -= 2;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (upper[i] > 0 || lower[i] > 0) {
                return res + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        String s = "abccccdd";

        Solution sol = new Solution();
        int ret = sol.longestPalindrome(s);

        System.out.println(ret);
    }
}


