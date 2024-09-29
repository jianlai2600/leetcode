package 寻找旋转排序数组中的最小值;

class Solution {

    public int helper(int[] nums, int low, int high)
    {
        int ret = -1;
        int mid = (high - low) / 2 + low;

        if (nums[mid] > nums[low] && nums[mid] < nums[high])return nums[low];
        if (low == high)return nums[low];

        if (nums[high] > nums[mid])ret = helper(nums, low, mid);
        else
        {
            ret = helper(nums, mid + 1, high);
        }

        return ret;
    }
    public int findMin(int[] nums) {
        int ret = -1;

        ret = helper(nums, 0, nums.length - 1);

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {3, 4, 5, 1, 2};

        Solution sol = new Solution();
        int ret = sol.findMin(nums);

        System.out.println(ret);
    }
}