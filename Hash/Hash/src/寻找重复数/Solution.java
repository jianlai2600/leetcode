package 寻找重复数;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : nums){
            if (map.containsKey(item)){
                return item;
            }
            map.put(item, 1);
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;

        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,3,4,2,2};

        Solution sol = new Solution();
        int ret = sol.findDuplicate(nums);

        System.out.println(ret);
    }
}



