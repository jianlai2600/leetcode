package 下一个排列;


class Solution {
    public void swap(int[] nums, int pos1, int pos2){
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    public void reverse(int[] nums, int pos){
        int left = pos, right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int pos = n - 2;
        while (pos >= 0 && nums[pos] >= nums[pos + 1]){
            pos--;
        }
        if (pos != -1){
            int bigger = n - 1;
            while (bigger > pos && nums[pos] >= nums[bigger]){
                bigger--;
            }
            swap(nums, pos, bigger);
        }
        reverse(nums, pos + 1);
    }
    public static void main(String[] args)
    {
        int[] nums = {3,2,1};

        Solution sol = new Solution();
        sol.nextPermutation(nums);

        for (Integer item : nums){
            System.out.println(item + " ");
        }
        System.out.println();
    }
}



