package TTCardAdd;

class Solution {
    public int getGCD(int a, int b) {

        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
    public int cardPackets(int[] cardTypes) {

        int ret = 0;
        //
        int gcd = cardTypes[0];
        for (int i = 1; i < cardTypes.length; i++) {
            gcd = getGCD(gcd, cardTypes[i]);
        }
        if (gcd != 1) {
            return 0;
        }
        //
        for (Integer num : cardTypes) {
            if (num % 2 == 1) {
                ret += 1;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] cardTypes = {4, 7, 5, 11, 15};

        Solution sol = new Solution();
        int ret = sol.cardPackets(cardTypes);

        System.out.println(ret);
    }
}