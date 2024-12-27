package 分数到小数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long numeratorLong = Math.abs((long)numerator);
        long denominatorLong = Math.abs((long)denominator);

        long digit = numeratorLong / denominatorLong;
        sb.append(digit);

        if (numeratorLong % denominatorLong == 0) {
            return sb.toString();
        }

        StringBuilder fractionSB = new StringBuilder();

        numeratorLong = (numeratorLong % denominatorLong) * 10;
        Map<Long, Integer>map = new HashMap<>();
        int index = 0;

        while (!map.containsKey(numeratorLong) && numeratorLong > 0) {

            map.put(numeratorLong, index);

            if (numeratorLong / denominatorLong == 0) {
                numeratorLong *= 10;
                fractionSB.append("0");
                index++;
            } else {

                fractionSB.append(String.valueOf(numeratorLong / denominatorLong));
                index++;
                numeratorLong %= denominatorLong;
                numeratorLong *= 10;
            }
        }
        if (numeratorLong != 0) {
            index = map.get(numeratorLong);
            fractionSB.insert(index, '(');
            fractionSB.append(')');
        }
        sb.append(".");
        sb.append(fractionSB);
        return sb.toString();
    }
    public static void main(String[] args) {

        int numerator = -1, denominator = -2147483648;

        Solution sol = new Solution();
        String ret = sol.fractionToDecimal(numerator, denominator);

        System.out.println(ret);
    }
}