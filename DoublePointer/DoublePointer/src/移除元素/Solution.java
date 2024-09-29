package 移除元素;

class Solution {

    public int removeElement(int[] nums, int val) {

        int slow = 0, fast = nums.length - 1;

        int k = 0;
        while (slow <= fast) {
            if (nums[slow] == val) {
                while (slow < fast && nums[fast] == val) {
                    k++;
                    fast--;
                }
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                fast--;
                k++;
            } else {
                slow++;
            }
        }
        return nums.length - k;
    }

    public static void main(String[] args)
    {
        int[] nums = {1};
        int val = 1;

        Solution sol = new Solution();
        int ret = sol.removeElement(nums, val);

        for (int i = 0; i < ret; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println(ret);
    }
}
