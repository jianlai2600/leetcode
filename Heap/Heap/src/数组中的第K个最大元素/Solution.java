package 数组中的第K个最大元素;

class Solution {
    // Heap Sort
    public void swap(int[] nums,int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void heapify(int nums[], int n, int i) {

        int left = i * 2 + 1, right = i * 2 + 2;
        int largest = i;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, n, largest);
        }
    }
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
        for (int i = 0; i < k; i++) {
            swap(nums, 0, n - 1 - i);
            heapify(nums, n - i - 1, 0);
        }
        return nums[n - k];
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        Solution sol = new Solution();

        int ret = sol.findKthLargest(nums, k);

        System.out.println(ret);
    }
}
