package 重排数组以得到最大前缀分数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int maxScore(int[] nums) {

        List<Integer>list = new ArrayList<>();
        for (Integer num : nums) {
            list.add(num);
        }

        list.sort((a, b)->b - a);

        if (list.get(0).equals(0)) {
            return 0;
        }

        long[]preSum = new long[nums.length + 1];

        int index = 1;
        int count = 0;
        for (Integer num : list) {
            preSum[index] = preSum[index - 1] + num;
            if (preSum[index] > 0) {
                count++;
            }
            index++;
        }
        return count;
    }
    public static void main(String[] args) {

        int[] nums = {2,-1,0,1,-3,3,-3};

        Solution sol = new Solution();
        int ret = sol.maxScore(nums);

        System.out.println(ret);
    }
}