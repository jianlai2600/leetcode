package 搜索旋转排序数组;

class Solution {
    public int binarySearch(int[] nums, int target, int low, int high)
    {
        if (low > high)return -1;

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
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pos = 0;
        boolean isReversed = false;
        int ret = 0;

        for (int i = 0; i < n - 1; i++)
        {
            if (nums[i] > nums[i + 1])
            {
                pos = i;
                isReversed = true;
                break;
            }
        }

        if (isReversed)
        {
            if (target >= nums[0])
            {
                ret = binarySearch(nums, target, 0, pos);
                return ret;
            }
            ret = binarySearch(nums, target, pos + 1, n - 1);
            return ret;
        }
        ret = binarySearch(nums, target, 0, n - 1);
        return ret;

    }

    public static void main(String[] args)
    {
        int[] nums = {3, 1};
        int target = 1;

        Solution sol = new Solution();
        int ret = sol.search(nums,target);

        System.out.println(ret);
    }
}