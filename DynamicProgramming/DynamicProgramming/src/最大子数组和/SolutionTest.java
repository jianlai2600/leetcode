package 最大子数组和;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testMaxSubArray_AllNegativeNumbers() {
        Solution sol = new Solution();
        int[] nums = {-2, -3, -1, -4};
        int[] expected = {2, 2}; // Maximum sum subarray is {-1}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_MixedNumbers() {
        Solution sol = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] expected = {3, 6}; // Maximum sum subarray is {4, -1, 2, 1}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_AllPositiveNumbers() {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] expected = {0, 3}; // Maximum sum subarray is {1, 2, 3, 4}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_SingleElement() {
        Solution sol = new Solution();
        int[] nums = {5};
        int[] expected = {0, 0}; // Maximum sum subarray is {5}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_ContainsZero() {
        Solution sol = new Solution();
        int[] nums = {0, -1, 2, -3, 4, -2, 2, 1, -5, 3};
        int[] expected = {4, 7}; // Maximum sum subarray is {4, -2, 2, 1}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_LargeNegativeAtStart() {
        Solution sol = new Solution();
        int[] nums = {-10, 1, 2, 3, 4};
        int[] expected = {1, 4}; // Maximum sum subarray is {1, 2, 3, 4}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_MultipleMaxSubarrays() {
        Solution sol = new Solution();
        int[] nums = {1, -1, 1, -1, 1, -1, 1};
        int[] expected = {0, 0}; // Multiple subarrays with equal max sum {1}, returning the first
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_AllZeros() {
        Solution sol = new Solution();
        int[] nums = {0, 0, 0, 0, 0};
        int[] expected = {0, 0}; // Maximum sum subarray is any single element {0}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_NegativeNumbersWithPositiveEnd() {
        Solution sol = new Solution();
        int[] nums = {-5, -4, -1, -2, 2, 3};
        int[] expected = {4, 5}; // Maximum sum subarray is {2, 3}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_SingleLargePositiveNumber() {
        Solution sol = new Solution();
        int[] nums = {-10, -20, -30, 100, -10, -20};
        int[] expected = {3, 3}; // Maximum sum subarray is {100}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_TwoElementsPositive() {
        Solution sol = new Solution();
        int[] nums = {3, 5};
        int[] expected = {0, 1}; // Maximum sum subarray is the whole array {3, 5}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_TwoElementsNegative() {
        Solution sol = new Solution();
        int[] nums = {-7, -3};
        int[] expected = {1, 1}; // Maximum sum subarray is the element {-3}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_ZeroesAndNegatives() {
        Solution sol = new Solution();
        int[] nums = {0, -1, -2, 0};
        int[] expected = {0, 0}; // Maximum sum subarray is any single {0}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_LongSequenceWithSinglePositivePeak() {
        Solution sol = new Solution();
        int[] nums = {-10, -3, -4, -2, 0, -1, 9, -10, -5, -2};
        int[] expected = {6, 6}; // Maximum sum subarray is {9}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSubArray_OnlyOneZero() {
        Solution sol = new Solution();
        int[] nums = {0};
        int[] expected = {0, 0}; // Maximum sum subarray is {9}
        int[] result = sol.maxSubArray(nums);
        assertArrayEquals(expected, result);
    }
}
