package pow;

class Solution {
    public double quickPow(double x, long n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double tmp = quickPow(x, n / 2);

        return n % 2 == 1 ? tmp * tmp * x : tmp * tmp;
    }
    public double myPow(double x, int n) {

        long N = n;
        return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }
    public static void main(String[] args) {

        double x = 2.0;
        int n = -2;

        Solution sol = new Solution();
        double ret = sol.myPow(x, n);

        System.out.println(ret);
    }
}