package AM_getMinimumChanges;

import java.util.*;

public class Solution {

    public static int getMinimumChanges(int[] prod_price, int k) {
        int n = prod_price.length;
        // Step 1: 创建 k 个组
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            groups.add(new ArrayList<>());
        }

        // Step 2: 将数组中的元素按照 (i % k) 分到对应的组
        for (int i = 0; i < n; i++) {
            groups.get(i % k).add(prod_price[i]);
        }

        // Step 3: 计算最小修改次数
        int totalChanges = 0;
        for (List<Integer> group : groups) {
            // 统计组内每个值的频率
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : group) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // 找到组内出现次数最多的值的频率
            int maxFrequency = 0;
            for (int freq : countMap.values()) {
                maxFrequency = Math.max(maxFrequency, freq);
            }

            // 修改次数 = 组的总大小 - 出现最多的频率
            totalChanges += group.size() - maxFrequency;
        }

        return totalChanges;
    }

    public static void main(String[] args) {
        // 示例输入
        int[] prod_price = {5, 7, 7, 8};
        int k = 2;

        // 调用函数并输出结果
        int result = getMinimumChanges(prod_price, k);
        System.out.println("Minimum changes required: " + result);
    }
}
