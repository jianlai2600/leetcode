package 第k个缺失的正整数;

class Solution {
    public int findKthPositive(int[] arr, int k) {

        int n = arr.length, left = 0, right = n - 1;

        int num = arr[n - 1] - n;
        if (num < k) {
            return arr[n - 1] + k - num;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            num = arr[mid] - mid - 1;
            if (num < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        num = arr[left] - left - 1;
        return arr[left] - (num - k) - 1;
        // 以后做题目一定要思考好判定条件再做
    }
    public static void main(String[] args) {

        int[] arr = {1,4,7,9,14,15,16,18,20,23,24,25,26,28,29,30,33,35,38,39,42,44,46,48,49,52,53,55,57,58,60,63,68,69,70};
        int k = 11;

        Solution sol = new Solution();
        int ret = sol.findKthPositive(arr, k);

        System.out.println(ret);
    }
}