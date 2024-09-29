package 搜索插入位置;

class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int left = 0, right = n - 1, mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        Solution sol = new Solution();
        int ret = sol.searchInsert(nums, target);

        System.out.println(ret);
    }
}