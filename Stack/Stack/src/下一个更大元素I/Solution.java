package 下一个更大元素I;

import java.util.*;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int[]ret = new int[m];
        Arrays.fill(ret, -1);

        Map<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums1[i], i);
        }

        Stack<Integer>stack = new Stack<>();
        //
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int ind = stack.pop();
                if (map.containsKey(nums2[ind])) {
                    ret[map.get(nums2[ind])] = nums2[i];
                }
            }
            stack.push(i);
        }
        //
        return ret;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 4}, nums2 = {1, 2, 3, 4};
        Solution sol = new Solution();

        int[] ret = sol.nextGreaterElement(nums1, nums2);

        for (Integer i : ret){
            System.out.print (i + " ");
        }
        System.out.println();
    }
}