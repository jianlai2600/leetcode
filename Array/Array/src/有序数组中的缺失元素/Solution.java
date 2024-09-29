package 有序数组中的缺失元素;

class Solution {
    public int missingElement(int[] nums, int k) {

        int n = nums.length;
        if (nums[n - 1] - nums[0] - n + 1 < k) {
            return k - (nums[n - 1] - nums[0] - n + 1) + nums[n - 1];
        }

        int left = 0, right = n - 1, mid = (left + right) / 2;

        int cnt = 0;

        while (left < right) {
            mid = (left + right) / 2;
            cnt = nums[mid] - nums[0] - mid;
            if (cnt == k) {
                return nums[mid] - 1;
            } else if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[mid] + k - cnt;
    }
    public static void main(String[] args) {

        int[] nums = {4,7,9,10};
        int k = 3;

        Solution sol = new Solution();
        int ret = sol.missingElement(nums, k);

        System.out.println(ret);
    }
}