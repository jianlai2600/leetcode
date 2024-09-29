package 找到K个最接近的元素;

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer>ret = new ArrayList<>();
        for (Integer num : arr) {
            ret.add(num);
        }

        Collections.sort(ret, (a, b)->{
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });

        ret = ret.subList(0, k);
        ret.sort(Comparator.naturalOrder());

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int k = 4, x = 3;

        Solution sol = new Solution();
        List<Integer>ret = sol.findClosestElements(nums, k, x);

        for (Integer num : ret) {
            System.out.println(num);
        }
    }
}