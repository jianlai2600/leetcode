package 有效单词缩写;

class Solution {
    public boolean check(String s) {

        char pre = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                return false;
            }
            pre = s.charAt(i);
        }
        return true;
    }
    public boolean validWordAbbreviation(String word, String abbr) {

        int n = abbr.length();

        int index = 0;
        for (int i = 0; i < n; i++) {

            char c = abbr.charAt(i);
            // If it's digit
            if (c <= '9' && c >= '1') {
                int left = i;
                while (i < n && abbr.charAt(i + 1) <= '9' && abbr.charAt(i + 1) >= '1') {
                    i++;
                }

                int num = Integer.valueOf(abbr.substring(left, i + 1));

                if (!check(word.substring(index, index + num))) {
                    return false;
                }
                index += num;
            } else {
                index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String word = "internationalization", abbr = "i12iz4n";

        Solution sol = new Solution();
        boolean ret = sol.validWordAbbreviation(word, abbr);

        System.out.println(ret);
    }
}
