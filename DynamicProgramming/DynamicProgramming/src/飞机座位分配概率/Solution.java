package 飞机座位分配概率;

class Solution {

    public double nthPersonGetsNthSeat(int n) {

        return n == 1 ? 1 : 0.5;
    }

    public static void main(String[] args) {

        int n = 2;

        Solution sol = new Solution();
        double ret = sol.nthPersonGetsNthSeat(n);

        System.out.println(ret);
    }
}