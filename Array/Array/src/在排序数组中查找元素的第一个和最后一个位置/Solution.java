package 在排序数组中查找元素的第一个和最后一个位置;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[]ret = {-1, -1};
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                ret[0] = i;
                ret[1] = i;

                i++;
                while (i < n && nums[i] == target) {
                    i++;
                }
                ret[1] = i - 1;
                return ret;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        Solution sol = new Solution();
        int[]ret = sol.searchRange(nums, target);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}