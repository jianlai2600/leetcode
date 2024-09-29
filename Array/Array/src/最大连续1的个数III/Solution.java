package 最大连续1的个数III;

class Solution {
    public int binarySearch(int[]p, int target) {

        int left = 0, right = p.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (p[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int[]p = new int[n + 1];

        int zeroNum = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                zeroNum++;
            }
            p[i] = zeroNum;
        }

        int ret = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(p, p[right + 1] - k);
            ret = Math.max(ret, right - left + 1);
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        Solution sol = new Solution();
        int ret = sol.longestOnes(nums, k);

        System.out.println(ret);
    }
}