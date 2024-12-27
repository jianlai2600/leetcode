package 区域和检索数组不可变;

class NumArray {

    int[]preSum;
    public NumArray(int[] nums) {

        preSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return preSum[right + 1] - preSum[left];
    }

}
