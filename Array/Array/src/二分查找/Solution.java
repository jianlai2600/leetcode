package 二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 找到一个大小于等于target 的坐标，为left
    public List<Integer> targetIndices(int[] nums, int target) {

        List<Integer>ret = new ArrayList<>();

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 这里使用left
        while (left < nums.length && nums[left] == target) {
            ret.add(left++);
        }

        return ret;
    }
    //
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        Solution sol = new Solution();
        int ret = sol.search(nums, target);

        System.out.println(ret);
    }
}