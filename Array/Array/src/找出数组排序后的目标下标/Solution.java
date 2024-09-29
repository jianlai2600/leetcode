package 找出数组排序后的目标下标;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
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

        while (left < nums.length && nums[left] == target) {
            ret.add(left++);
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,5,2,3};
        int target = 5;

        Solution sol = new Solution();
        List<Integer>ret = sol.targetIndices(nums, target);

        for (Integer index : ret) {
            System.out.print(index + " ");
        }
        System.out.println();
    }
}