package 颠倒二进制位;

class Solution {
    public int reverseBits(int n) {

        int ret = 0;

        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>= 1;
        }

        return ret;
    }
    public static void main(String[] args) {

        int n = 0b00000010100101000001111010011100;

        Solution sol = new Solution();
        int ret = sol.reverseBits(n);

        System.out.println(ret);

        int a = 6; // 0110
        int b = 2; // 0010
        a ^= b; // 0100
        System.out.println(a);
    }
}