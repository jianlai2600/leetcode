package AM_getMinimumChanges;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCode {

    @Test
    public void testExampleCase() {
        int[] prod_price = {5, 7, 7, 8};
        int k = 2;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(2, result, "Test failed for input {5, 7, 7, 8} with k=2");
    }

    @Test
    public void testAllEqualElements() {
        int[] prod_price = {4, 4, 4, 4};
        int k = 2;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(0, result, "Test failed for input {4, 4, 4, 4} with k=2");
    }

    @Test
    public void testSingleElementArray() {
        int[] prod_price = {10};
        int k = 1;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(0, result, "Test failed for input {10} with k=1");
    }

    @Test
    public void testLargeKValue() {
        int[] prod_price = {1, 2, 3, 4, 5};
        int k = 5;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(0, result, "Test failed for input {1, 2, 3, 4, 5} with k=5");
    }

    @Test
    public void testMixedValues() {
        int[] prod_price = {1, 2, 1, 2, 1};
        int k = 3;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(2, result, "Test failed for input {1, 2, 1, 2, 1} with k=3");
    }

    @Test
    public void testLargeInputArray() {
        int[] prod_price = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int k = 3;
        int result = Solution.getMinimumChanges(prod_price, k);
        assertEquals(0, result, "Test failed for input {1, 2, 3, 1, 2, 3, 1, 2, 3} with k=3");
    }
}