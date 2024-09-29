package 反转字符串中的单词;

class Solution {
    public String reverseWords(String s) {

        int n = s.length();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder(n);

        int i = n - 1;

        while (i >= 0) {
            while (i >= 0 && c[i] == ' ') {
                i--;
            }
            StringBuilder word = new StringBuilder(n);
            while (i >= 0 && c[i] != ' ') {
                word.append(c[i]);
                i--;
            }
            if (!word.isEmpty()) {
                sb.append(word.reverse() + " ");
            }

        }
        sb.deleteCharAt(sb.length()-1);

        return  sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "the sky is blue";

        Solution sol = new Solution();
        String ret = sol.reverseWords(s);

        System.out.println(ret);
    }
}
