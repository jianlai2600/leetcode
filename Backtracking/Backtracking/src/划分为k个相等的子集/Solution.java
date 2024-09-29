package 划分为k个相等的子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    boolean[]visited; 
    public boolean backTracking(int[]nums, int target, int k, int startIndex, int curSum) {

        if (k == 0) {
            return true;
        }
        if (curSum == target) {
            return backTracking(nums, target, k - 1, 0, 0);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {

                if (curSum + nums[i] > target) {
                    continue;
                }

                curSum += nums[i];
                visited[i] = true;

                if (backTracking(nums, target, k, i + 1, curSum)) {
                    return true;
                }

                curSum -= nums[i];
                visited[i] = false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        int n = nums.length;
        int target = sum / k;
        Arrays.sort(nums);

        int curSum = 0;
        visited = new boolean[n];

        return backTracking(nums, target, k, 0, 0);
    }
    public static void main(String[] args) {

        int[] nums = {2,2,2,2,3,4,5};
        int k = 4;

        Solution sol = new Solution();
        boolean ret = sol.canPartitionKSubsets(nums, k);

        System.out.println(ret);
    }
}