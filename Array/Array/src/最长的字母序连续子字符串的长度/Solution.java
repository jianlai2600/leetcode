package 最长的字母序连续子字符串的长度;

class Solution {
    public int longestContinuousSubstring(String s) {

        int ret = 1;

        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                cur++;
            } else {
                cur = 1;
            }
            ret = Math.max(ret, cur);
        }

        return ret;
    }
    public static void main(String[] args) {

        String s = "abacaba";

        Solution sol = new Solution();
        int ret = sol.longestContinuousSubstring(s);

        System.out.println(ret);
    }
}