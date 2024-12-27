package 山羊拉丁文;

import java.util.*;

class Solution {
    public String toGoatLatin(String sentence) {

        StringBuilder sb = new StringBuilder();
        String[]arr = sentence.split(" ");

        String pattern = "aeiouAEIOU";

        int index = 1;
        for (String s : arr) {
            StringBuilder tmp = new StringBuilder();
            if (pattern.indexOf(s.charAt(0)) != -1) {
                tmp.append(s + "ma");
                for (int i = 0; i < index; i++) {
                    tmp.append('a');
                }
            } else {
                tmp.append(s.substring(1) + s.charAt(0) + "ma");
                for (int i = 0; i < index; i++) {
                    tmp.append('a');
                }
            }
            index++;
            sb.append(tmp.toString() + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static void main(String[] args) {

        String sentence = "I speak Goat Latin";

        Solution sol = new Solution();
        String ret = sol.toGoatLatin(sentence);

        System.out.println(ret);
    }
}