package 将1移动到末尾的最大操作次数;

class Solution {
    public int maxOperations(String s) {

        int ret = 0;
        int oneNum = 0;

        char[]sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '1') {
                oneNum++;
            } else if (i > 0 && sArr[i - 1] == '1') {
                ret += oneNum;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        String s = "1001101";

        Solution sol = new Solution();
        int ret = sol.maxOperations(s);

        System.out.println(ret);
    }
}