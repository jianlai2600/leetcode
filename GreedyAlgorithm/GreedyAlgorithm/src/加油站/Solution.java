package 加油站;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int curSum = 0, totalSum = 0, ret = 0;

        for (int i = 0; i < n; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if (curSum < 0) {
                curSum = 0;
                ret = i + 1;
            }
        }

        if (totalSum < 0) {
            return -1;
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        Solution sol = new Solution();
        int ret = sol.canCompleteCircuit(gas, cost);

        System.out.println(ret);
    }
}

