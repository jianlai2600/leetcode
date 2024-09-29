package 盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {

        int ret = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int volume = (right - left) * Math.min(height[left], height[right]);
            ret = Math.max(ret, volume);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[]height = {1,8,6,2,5,4,8,3,7};

        Solution sol = new Solution();
        int ret = sol.maxArea(height);

        System.out.println(ret);
    }
}
