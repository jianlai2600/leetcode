package 寻找峰值;

class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {

            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    // Binary Search
    public int findPeakElement2(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,3,5,6,4};

        Solution sol = new Solution();
        int ret = sol.findPeakElement2(nums);

        System.out.println(ret);
    }
}