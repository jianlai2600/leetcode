package 与车相交的点;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {

        nums.sort((a, b)-> a.get(0) - b.get(0));
        int ret = 0;

        int left = nums.get(0).get(0);
        int right = nums.get(0).get(1);

        int n = nums.size();

        for (int i = 1; i < n; i++) {
            int curLeft = nums.get(i).get(0);
            int curRight = nums.get(i).get(1);

            if (curLeft <= right + 1) {
                right = Math.max(curRight, right);
            } else {
                ret += right - left + 1;
                left = curLeft;
                right = curRight;
            }
        }
        ret += right - left + 1;

        return ret;
    }
    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(3, 6));
        nums.add(Arrays.asList(1, 5));
        nums.add(Arrays.asList(4, 7));

        Solution sol = new Solution();
        int ret = sol.numberOfPoints(nums);

        System.out.println(ret);
    }
}