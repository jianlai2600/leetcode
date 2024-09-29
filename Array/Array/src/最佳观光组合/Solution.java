package 最佳观光组合;
class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int ret = 0;
        int n = values.length;
        int maxFirst = values[0];
        int maxSecond = 0;
        //
        for (int i = 1; i < n; i++) {

            ret = Math.max(ret, maxFirst + values[i] - i);
            maxFirst = Math.max(maxFirst, values[i] + i);
        }
        //
        return ret;
    }
    public static void main(String[] args) {

        int[] values = {8,1,5,2,6};

        Solution sol = new Solution();
        int ret = sol.maxScoreSightseeingPair(values);

        System.out.println(ret);
    }
}