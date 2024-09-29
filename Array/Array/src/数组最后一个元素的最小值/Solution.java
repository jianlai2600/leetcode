package 数组最后一个元素的最小值;

class Solution {
    public long minEnd(int n, int x) {

        n--;
        long ans = x;

        while (n-- > 0) {

            ans++;
            ans |= x;
        }

        return ans;
    }
    public static void main(String[] args) {

        int x = 3, n = 4;

        Solution sol = new Solution();
        long ret = sol.minEnd(x, n);

        System.out.println(ret);
    }
}