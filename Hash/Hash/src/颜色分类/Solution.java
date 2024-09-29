package 颜色分类;

import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0, n = nums.length;
        int tmp = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                nums[i] = nums[p1];
                nums[p1] = 1;
                p1++;
            } else if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                if (p0 < p1){
                    tmp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = tmp;
                }
                p1++;
                p0++;
            }
        }
    }
    public static void main(String[] args)
    {
        int[] nums = {2,0,2,1,1,0};

        Solution sol = new Solution();
        sol.sortColors(nums);

        for (Integer item : nums){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



