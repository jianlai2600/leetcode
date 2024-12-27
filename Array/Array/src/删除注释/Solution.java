package 删除注释;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {

        List<String>res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean inBlock = false;
        for (String s : source) {

            int n = s.length();

            for (int i = 0; i < n; i++) {
                if (inBlock) {
                    if (i + 1 < n && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < n && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }

            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
    public static void main(String[] args) {

        String[] source = {
                "a/*comment", "line", "more_comment*/b"
        };

        Solution sol = new Solution();
        List<String>res = sol.removeComments(source);

        for (String line : res) {
            System.out.println(line);
        }
        System.out.println();
    }
}