package 拆分字符串使唯一子字符串的数目最大;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String>curArr = new ArrayList<>();
    int res;
    Set<String> set = new HashSet<>();
    public void backTracking(String s, int index) {

        if (index == s.length()) {
            res = Math.max(res, curArr.size());
            return;
        }

        for (int len = 1; index + len <= s.length(); len++) {
            String str = s.substring(index, index + len);
            if (set.contains(str)) {
                continue;
            }
            curArr.add(str);
            set.add(str);
            backTracking(s, index + len);
            curArr.remove(curArr.size() - 1);
            set.remove(str);
        }
    }
    public int maxUniqueSplit(String s) {

        res = 0;

        set = new HashSet<>();
        for (int len = 1; len <= s.length(); len++) {
            String str = s.substring(0, 0 + len);
            curArr.add(str);
            set.add(str);
            backTracking(s, len);
            curArr.remove(curArr.size() - 1);
            set.remove(str);
        }

        return res;
    }
    public static void main(String[] args) {

        String s = "ababccc";

        Solution sol = new Solution();
        int ret = sol.maxUniqueSplit(s);

        System.out.println(ret);
    }
}