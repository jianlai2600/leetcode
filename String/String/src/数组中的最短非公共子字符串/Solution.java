package 数组中的最短非公共子字符串;

class Solution {
    public boolean isValid(String[]arr, int pos, String s) {

        for (int i = 0; i < arr.length; i++) {
            if (i != pos && arr[i].contains(s)) {
                return false;
            }
        }
        return true;
    }
    public String[] shortestSubstrings(String[] arr) {

        int n = arr.length;
        String[]ret = new String[arr.length];

        for (int i = 0; i < n; i++) {
            int m = arr[i].length();
            String ans = "";
            for (int len = 1; len <= m && ans.isEmpty(); len++) {
                for (int start = 0; start + len <= m; start++) {

                    String subString = arr[i].substring(start, start + len);
                    if (isValid(arr, i, subString) && (ans.isEmpty() || subString.compareTo(ans) < 0)) {
                        ans = subString;
                    }
                }
            }
            ret[i] = ans;
        }

        return ret;
    }
    public static void main(String[] args) {

        String[] arr = {"cab","ad","bad","c"};

        Solution sol = new Solution();
        String[]ret = sol.shortestSubstrings(arr);

        for (String s : ret) {
            System.out.print(s + "<-*-> ");
        }
        System.out.println();
    }
}