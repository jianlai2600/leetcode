package Z字形变换;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder[]arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {

            if (index == numRows - 1 || index == 0) {
                flag = !flag;
            }
            arr[index].append(s.charAt(i));
            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        for (int i = 0; i < numRows; i++) {
            sb.append(arr[i].toString());
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        String s = "AB";
        int numRows = 1;

        Solution sol = new Solution();
        String res = sol.convert(s, numRows);

        System.out.println(res);
    }
}