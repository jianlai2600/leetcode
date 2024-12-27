package 找到稳定山的下标;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {

        List<Integer> ret = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                ret.add(i);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] height = {1,2,3,4,5};
        int threshold = 2;

        Solution sol = new Solution();
        List<Integer> ret = sol.stableMountains(height, threshold);

        for (Integer i : ret) {
            System.out.println(i);
        }
    }
}