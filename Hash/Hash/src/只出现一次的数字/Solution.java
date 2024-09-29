package 只出现一次的数字;

import java.util.HashMap;

class Solution {
    public int singleNumber_HASH(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int g = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            g = map.getOrDefault(nums[i], 0);
            map.put(nums[i], g + 1);
            if (map.get(nums[i]) == 2){
                map.remove(nums[i]);
            }
        }
        int ret = 0;
        for (int key : map.keySet()){
            ret = key;
        }
        return ret;
    }
    public int singleNumber(int[] nums) {

        int n = nums.length;
        int ret = nums[0];
        for (int i = 1; i < n; i++) {
            ret ^= nums[i];
        }

        return ret;
    }
    public static void main(String[] args)
    {
        int[] nums = {2,2,1};

        Solution sol = new Solution();
        int ret = sol.singleNumber(nums);

        System.out.println(ret);

//        System.out.println(2^2);
//        System.out.println(2^1);
//        System.out.println(2^0);
    }
}



