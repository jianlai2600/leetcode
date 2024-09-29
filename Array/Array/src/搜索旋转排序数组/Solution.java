package 搜索旋转排序数组;

class Solution {
    public int binarySearch(int[] nums, int target, int l, int r) {

        int left = l, right = r, mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int left = 0, n = nums.length, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // left have orders
            if (nums[left] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    return binarySearch(nums, target, left, mid);
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target >= nums[mid]) {
                    return binarySearch(nums, target, mid, right);
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {3, 1};
        int target = 1;

        Solution sol = new Solution();
        int ret = sol.search(nums, target);

        System.out.println(ret);
    }
}