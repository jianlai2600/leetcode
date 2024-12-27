package 数青蛙;

import java.util.*;

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {

        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }

        int res = 0;
        int frog = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);

        int[]cnt = new int[4];

        for (Character c : croakOfFrogs.toCharArray()) {

            int num = map.get(c);
            if (num == 0) {
                frog++;
                cnt[num]++;

                if (frog > res) {
                    res = frog;
                }
            } else {
                if (cnt[num - 1] == 0) {
                    return -1;
                }
                cnt[num - 1]--;
                if (num == 4) {
                    frog--;
                } else {
                    cnt[num]++;
                }
            }
        }

        if (frog > 0) {
            return -1;
        }
        return res;
    }
    public static void main(String[] args) {

        String croakOfFrogs = "crcoakroak";

        Solution sol = new Solution();
        int ret = sol.minNumberOfFrogs(croakOfFrogs);

        System.out.println(ret);
    }
}