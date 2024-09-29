package 考试的最大困扰度;

class Solution {
    public int helper(String s, int k, char c) {

        int ret = 0, n = s.length(), cnt = 0;

        for (int left = 0, right = 0; right < n; right++) {

            if (s.charAt(right) == c) {
                cnt++;
            }
            while (cnt > k) {
                if (s.charAt(left) == c) {
                    cnt--;
                }
                left++;
            }
            int len = right - left + 1;
            ret = Math.max(ret, len);
        }

        return ret;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
    }
    public static void main(String[] args) {

        String answerKey = "TTFF";
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.maxConsecutiveAnswers(answerKey, k);

        System.out.println(ret);
    }
}


