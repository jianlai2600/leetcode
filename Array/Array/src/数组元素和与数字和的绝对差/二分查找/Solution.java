package 数组元素和与数字和的绝对差.二分查找;

class Solution {
    public int getDigitNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    public int differenceOfSum(int[] nums) {

        int sum = 0;
        int digitSum = 0;

        for (Integer num : nums) {
            sum += num;
            digitSum += getDigitNum(num);
        }

        return Math.abs(sum - digitSum);
    }
    public static void main(String[] args) {

        int[] nums = {1,15,6,3};

        Solution sol = new Solution();
        int ret = sol.differenceOfSum(nums);

        System.out.println(ret);
    }
}