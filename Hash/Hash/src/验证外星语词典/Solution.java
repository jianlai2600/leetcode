package 验证外星语词典;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        String[]tmp = Arrays.copyOf(words, words.length);
        Arrays.sort(tmp, (s1, s2)->{

            int n = Math.min(s1.length(), s2.length());
            int index = 0;

            while (index < n) {
                char c1 = s1.charAt(index);
                char c2 = s2.charAt(index);

                int ind1 = order.indexOf(c1);
                int ind2 = order.indexOf(c2);

                if (ind1 == ind2) {
                    index++;
                } else if (ind1 < ind2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (s2.length() > s1.length()) {
                return -1;
            }
            return 1;
        });

        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(tmp[i], words[i])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String[]words = {"ubg","kwh"};
        String order = "qcipyamwvdjtesbghlorufnkzx";

        Solution sol = new Solution();
        boolean ret = sol.isAlienSorted(words, order);

        System.out.println(ret);
    }
}



