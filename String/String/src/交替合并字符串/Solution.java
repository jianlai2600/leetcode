package 交替合并字符串;

class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder res = new StringBuilder();

        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        while (i < m) {
            res.append(word1.charAt(i++));
        }
        while (j < n) {
            res.append(word2.charAt(j++));
        }
        return res.toString();
    }
    public static void main(String[] args) {

        String word1 = "abc", word2 = "pqr";

        Solution sol = new Solution();
        String res = sol.mergeAlternately(word1, word2);

        System.out.println(res);
    }
}