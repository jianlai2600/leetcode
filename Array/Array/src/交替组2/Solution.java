package 交替组2;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int res = 0;
        int n = colors.length;

        int[]arr = new int[n * 2];

        System.arraycopy(colors, 0, arr, 0, colors.length); // 拷贝第一个数组
        System.arraycopy(colors, 0, arr, colors.length, colors.length); // 拷贝第二个数组

        int left = 0;
        int cnt = 1;
        for (int right = 1; left < n && right < n * 2;) {
            while (arr[right] != arr[right - 1] && cnt < k) {
                right++;
                cnt++;
            }
            if (cnt == k) {
                res++;
                left++;
                cnt--;
            } else {
                left = right;
                right = left + 1;
                cnt = 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[] colors = {0,1,0,1,0};

        Solution sol = new Solution();
        int ret = sol.numberOfAlternatingGroups(colors, 3);

        System.out.println(ret);
    }
}