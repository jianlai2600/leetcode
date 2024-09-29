package strStr;

class Solution {
    public int[] getNext(char[] c) {

        int[]next = new int[c.length];

        int j = 0;
        for (int i = 1; i < c.length; i++) {

            while (j > 0 && c[i] != c[j]) {
                j = next[j - 1];
            }
            if (c[i] == c[j]) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
    public int strStr(String haystack, String needle) {

        char[]haystackArray = haystack.toCharArray();
        char[]needleArray = needle.toCharArray();
        int n = haystack.length(), m = needle.length();

        int[]next = getNext(needleArray);

        for (int i = 0, j = 0; i < n; i++) {

            while (j > 0 && haystackArray[i] != needleArray[j]) {
                j = next[j - 1];
            }
            if (haystackArray[i] == needleArray[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String haystack = "jojosadbutsad";
        String needle = "sad";

        Solution sol = new Solution();
        int ret = sol.strStr(haystack, needle);

        System.out.println(ret);
    }
}