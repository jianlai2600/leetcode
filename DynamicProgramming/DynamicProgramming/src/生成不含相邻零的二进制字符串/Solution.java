package 生成不含相邻零的二进制字符串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> validStrings(int n) {
        return new ArrayList<>();
    }
    public static void main(String[] args) {

        int n = 3;

        Solution sol = new Solution();
        List<String>res = sol.validStrings(n);

        for (String s : res) {
            System.out.println(s);
        }
    }
}


