package 分割回文串;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>>ret = new ArrayList<>();
    List<String>ans = new ArrayList<>();

    public boolean isValid(String s, int start, int len) {
        int left = start, right = start + len - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void backTracking(String s, int start) {

        if (start == s.length()) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int len = 1; len + start <= s.length(); len++) {
            if (isValid(s, start, len)) {
                ans.add(s.substring(start, start + len));
                backTracking(s, start + len);
                ans.removeLast();
            }
        }
    }
    public List<List<String>> partition(String s) {

        backTracking(s, 0);
        return ret;
    }
    public static void main(String[] args) {

        String s = "aab";

        Solution sol = new Solution();
        List<List<String>> ret = sol.partition(s);

        for (List<String> innerList : ret) {
            // 遍历内层列表
            for (String value : innerList) {
                System.out.print(value + "+");
            }
            System.out.println(); // 换行，移动到下一行
        }
    }
}