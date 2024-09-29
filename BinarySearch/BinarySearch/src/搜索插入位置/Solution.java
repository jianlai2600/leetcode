package 搜索插入位置;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int binarySearch(int[] nums, int target, int low, int high)
    {
        if (target > nums[high])return high + 1;
        else if (target < nums[low])
        {
            return low;
        }

        int mid = (low + high) / 2;

        if (target > nums[mid])
        {
            return binarySearch(nums, target, mid + 1, high);
        } else if (target < nums[mid])
        {
            return binarySearch(nums, target, low, mid - 1);
        } else if (target == nums[mid])
        {
            return mid;
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        int ret = binarySearch(nums, target, 0, nums.length - 1);
        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        Solution sol = new Solution();
        int ret = sol.searchInsert(nums,target);

        System.out.println(ret);
    }
}