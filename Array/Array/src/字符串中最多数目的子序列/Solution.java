package 字符串中最多数目的子序列;

class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {

        int cnt1 = 0, cnt2 = 0;
        long ret = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == pattern.charAt(1)) {
                cnt2++;
                ret += cnt1;
            }
            if (c == pattern.charAt(0)) {
                cnt1++;
            }
        }
        // 顺序有讲究的，先后再前，面向的是pattern是一个字符的问题，模拟一下即可
        return Math.max(cnt2, cnt1) + ret;
    }
    public static void main(String[] args) {

        String text = "abdcdbc", pattern = "ac";

        Solution sol = new Solution();
        long ret = sol.maximumSubsequenceCount(text, pattern);

        System.out.println(ret);
    }
}