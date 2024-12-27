package 统计字符串中的元音子字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countVowelSubstrings(String word) {

        int cnt = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            int[]arr = new int[5];
            boolean notVowel = false;

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                switch (c) {
                    case 'a':
                        arr[0]++;
                        break;
                    case 'e':
                        arr[1]++;
                        break;
                    case 'i':
                        arr[2]++;
                        break;
                    case 'o':
                        arr[3]++;
                        break;
                    case 'u':
                        arr[4]++;
                        break;
                    default:
                        notVowel = true;
                        break;
                }
                if (notVowel) {
                    break;
                }
                if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0 && arr[3] > 0 && arr[4] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        String word = "cuaieuouac";

        Solution sol = new Solution();
        int ret = sol.countVowelSubstrings(word);

        System.out.println(ret);
    }
}