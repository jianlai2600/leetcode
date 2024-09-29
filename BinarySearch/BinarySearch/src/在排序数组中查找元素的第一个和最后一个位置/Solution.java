package 在排序数组中查找元素的第一个和最后一个位置;

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
    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, target, 0, nums.length - 1);
        int[] ret = {-1, -1};

        int n = nums.length - 1;
        if (pos != -1)
        {
            int tmp = pos;
            while (tmp >= 0 && tmp <= n && nums[tmp] == target)
            {
                ret[0] = tmp;
                tmp--;
            }
            tmp = pos;
            while (tmp >= 0 && tmp <= n && nums[tmp] == target)
            {
                ret[1] = tmp;
                tmp++;
            }
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution sol = new Solution();
        int[] ret = sol.searchRange(nums,target);

        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}