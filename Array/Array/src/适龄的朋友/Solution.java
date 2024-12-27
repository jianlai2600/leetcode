package 适龄的朋友;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numFriendRequests(int[] ages) {

        int res = 0;
        Arrays.sort(ages);

        int left = 0, right = 0;
        for (int age : ages) {

            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                left++;
            }
            while (right + 1 < ages.length && ages[right + 1] <= age) {
                right++;
            }
            res += right - left;
        }

        return res;
    }
    public static void main(String[] args) {

        int[] ages = {20,30,100,110,120};

        Solution sol = new Solution();
        int ret = sol.numFriendRequests(ages);

        System.out.println(ret);
    }
}