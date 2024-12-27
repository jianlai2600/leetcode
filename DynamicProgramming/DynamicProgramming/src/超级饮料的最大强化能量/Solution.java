package 超级饮料的最大强化能量;

class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {

        int n = energyDrinkA.length;

        long[]dpA = new long[n];
        long[]dpB = new long[n];

        long res = 0;

        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];

        dpA[1] = dpA[0] + energyDrinkA[1];
        dpB[1] = dpB[0] + energyDrinkB[1];

        for (int i = 2; i < n; i++) {
            dpA[i] = Math.max(dpA[i - 1] + energyDrinkA[i], dpB[i - 2] + energyDrinkA[i]);
            dpB[i] = Math.max(dpB[i - 1] + energyDrinkB[i], dpA[i - 2] + energyDrinkB[i]);

            res = Math.max(res, Math.max(dpA[i], dpB[i]));
        }
        return res;
    }

    public static void main(String[] args) {

        int[]energyDrinkA = {1, 3, 1};
        int[]energyDrinkB = {3, 1, 1};

        Solution sol = new Solution();
        long res = sol.maxEnergyBoost(energyDrinkA, energyDrinkB);

        System.out.println(res);
    }
}


