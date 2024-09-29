package 重复的子字符串;

class Solution {
    public int[] getNext(String s) {

        int[]next = new int[s.length()];

        for (int i = 1, j = 0; i < s.length(); i++) {

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public boolean repeatedSubstringPattern(String s) {

        int[]next = getNext(s);
        StringBuffer sb = new StringBuffer(s);
        sb.append(s);

        int ind = 0;
        for (int i = 1, j = 0; i < sb.length(); i++) {

            while (j > 0 && sb.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (sb.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                ind = i - s.length() + 1;
                break;
            }
        }

        if (ind > 0 && ind < s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "ababab";

        Solution sol = new Solution();
        boolean ret = sol.repeatedSubstringPattern(s);

        System.out.println(ret);
    }
}