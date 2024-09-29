package 两个非重叠子数组的最大和;

class Solution {
    public int helper(int[] nums, int len1, int len2) {

        int suml = 0, sumr = 0, maxSumL = 0;

        for (int i = 0; i < len1; i++) {
            suml += nums[i];
        }
        maxSumL = suml;
        for (int i = len1; i < len1 + len2; i++) {
            sumr += nums[i];
        }

        int ret = maxSumL + sumr;

        for (int i = len1 + len2, j = len1; i < nums.length; i++, j++) {
            suml += nums[j] - nums[j - len1];
            maxSumL = Math.max(maxSumL, suml);
            sumr += nums[i] - nums[i - len2];
            ret = Math.max(ret, sumr + maxSumL);
        }
        return ret;
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        return Math.max(helper(nums, firstLen, secondLen), helper(nums, secondLen, firstLen));
    }

    public static void main(String[] args) {

        int[] nums = {0,6,5,2,2,5,1,9,4};
        int firstLen = 1, secondLen = 2;

        Solution sol = new Solution();
        int ret = sol.maxSumTwoNoOverlap(nums, firstLen, secondLen);

        System.out.println(ret);
    }
}