package 整数转罗马数字;

class Solution {
    // M1
    public String intToRoman(int num) {

        String s = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder();
        int n = s.length();

        int len = n;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '4') {
                if (n == 3) {
                    stringBuilder.append("CD");
                } else if (n == 2) {
                    stringBuilder.append("XL");
                } else if (n == 1) {
                    stringBuilder.append("IV");
                }
            } else if (c == '9') {
                if (n == 3) {
                    stringBuilder.append("CM");
                } else if (n == 2) {
                    stringBuilder.append("XC");
                } else if (n == 1) {
                    stringBuilder.append("IX");
                }
            } else if (c == '5') {
                if (n == 3) {
                    stringBuilder.append("D");
                } else if (n == 2) {
                    stringBuilder.append("L");
                } else if (n == 1) {
                    stringBuilder.append("V");
                }
            } else {
                if (c < '5') {
                    int curNum = c - '0';
                    if (n == 4) {
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("M");
                        }
                    } else if (n == 3) {
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("C");
                        }
                    } else if (n == 2) {
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("X");
                        }
                    } else if (n == 1) {
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("I");
                        }
                    }
                } else {
                    int curNum = c - '0' - 5;
                    if (n == 3) {
                        stringBuilder.append("D");
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("C");
                        }
                    } else if (n == 2) {
                        stringBuilder.append("L");
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("X");
                        }
                    } else if (n == 1) {
                        stringBuilder.append("V");
                        for (int j = 0; j < curNum; j++) {
                            stringBuilder.append("I");
                        }
                    }
                }

            }

            n--;
        }

        return stringBuilder.toString();
    }
    // M2
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
    public static void main(String[] args) {

        int num = 3749;

        Solution sol = new Solution();
        String romanNum = sol.intToRoman2(num);

        System.out.println(romanNum);
    }
}