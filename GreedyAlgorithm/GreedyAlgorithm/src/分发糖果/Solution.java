package 分发糖果;

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length, ret = 0;

        int[]candyNum = new int[n];
        candyNum[0] = 1;

        for (int i = 1; i < n; i++) {
            candyNum[i] = ratings[i] > ratings[i - 1] ? candyNum[i - 1] + 1 : 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            int num = ratings[i] > ratings[i + 1] ? candyNum[i + 1] + 1 : 1;
            candyNum[i] = Math.max(num, candyNum[i]);
            ret += candyNum[i];
        }

        return ret + candyNum[n - 1];
    }
    public static void main(String[] args) {

        int[] ratings = {1, 0, 2};

        Solution sol = new Solution();
        int ret = sol.candy(ratings);

        System.out.println(ret);
    }
}

