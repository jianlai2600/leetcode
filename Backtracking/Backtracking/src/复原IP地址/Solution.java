package 复原IP地址;

import java.util.*;

class Solution {
    List<String>ret = new ArrayList<>();
    List<String>ans = new ArrayList<>();

    public boolean isValid(String s, int start, int len) {

        if (start + len > s.length()) {
            return false;
        }
        if (s.charAt(start) == '0' && len > 1) {
            return false;
        }
        int num = Integer.parseInt(s.substring(start, start + len));

        if (num > 255) {
            return false;
        }

        return true;
    }
    public String makeString(List<String>ans) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 3; i++) {
            sb.append(ans.get(i));
            sb.append('.');
        }
        sb.append(ans.get(3));
        return sb.toString();
    }
    public void backTracking(String s, int start) {

        if (ans.size() > 4) {
            return;
        }
        if (start + 3 < s.length() && ans.size() == 3) {
            return;
        }
        if (ans.size() == 4 && start == s.length()) {
            ret.add(makeString(ans));
            return;
        }

        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            if (isValid(s, start, len)) {
                ans.add(s.substring(start, start + len));
                backTracking(s, start + len);
                ans.removeLast();
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {

        backTracking(s, 0);
        return ret;
    }
    public static void main(String[] args) {

        String s = "10101010";

        Solution sol = new Solution();
        List<String> ret = sol.restoreIpAddresses(s);

        for (String item : ret) {
            System.out.println("Answer: " + item);
        }
    }
}