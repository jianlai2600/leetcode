package 反转字符串中的单词;

class Solution {
    public void helperFun(StringBuffer s, int left, int right) {

        while (left < right) {
            char tmp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, tmp);
            left++;
            right--;
        }
    }
    public String reverseWords(String s) {

        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                while (i >= 1 && s.charAt(i - 1) == ' ') {
                    i--;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        for (int i = 0; i < sb.length();) {
            if (sb.charAt(i) != ' ') {
                int left = i;
                while (i < sb.length() && sb.charAt(i) != ' ') {
                    i++;
                }
                int right = i - 1;

                helperFun(sb, left, right);
            } else {
                i++;
            }
        }

        if (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        String s = "the sky is blue";

        Solution sol = new Solution();
        String ret = sol.reverseWords(s);

        System.out.println(ret);
    }
}