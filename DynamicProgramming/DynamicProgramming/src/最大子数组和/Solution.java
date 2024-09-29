package 最大子数组和;

class Solution {

    public int[] maxSubArray(int[] nums) {

        int[] ret = new int[2];
        int curSum = nums[0];
        int maxSum = nums[0];
        int start = 0, end = 0, tmpStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = nums[i];
                tmpStart = i;
            } else {
                curSum += nums[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                start = tmpStart;
                end = i;
            }
        }
        ret[0] = start;
        ret[1] = end;

        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {-2,1,-3,4,-1,2,1,-5,4};

        Solution sol = new Solution();
        int[] ret = sol.maxSubArray(nums);

        System.out.println(ret[0] + " " + ret[1]);
    }

}


