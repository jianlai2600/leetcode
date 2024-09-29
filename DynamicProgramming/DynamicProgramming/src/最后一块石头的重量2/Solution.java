package 最后一块石头的重量2;

class Solution {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (Integer i : stones) {
            sum += i;
        }

        int target = sum / 2;

        int[]dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }

    public static void main(String[] args)
    {
        int[] stones = {2,7,4,1,8,1};

        Solution sol = new Solution();
        int ret = sol.lastStoneWeightII(stones);

        System.out.println(ret);
    }
}


