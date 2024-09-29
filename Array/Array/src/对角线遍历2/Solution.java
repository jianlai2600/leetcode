package 对角线遍历2;

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        int m = nums.size();

        List<int[]>list = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int[]cor = new int[]{i, j};
                list.add(cor);
                map.put(cor, nums.get(i).get(j));
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = o1[0] + o1[1];
                int sum2 = o2[0] + o2[1];

                if (sum1 == sum2) {
                    return o1[0] - o2[0] > 0 ? -1 : 1;
                } else {
                    return sum1 - sum2;
                }
            }
        });

        int len = list.size();
        int[]ret = new int[len];

        int index = 0;
        for (int[]cor : list) {
            ret[index++] = map.get(cor);
        }

        return ret;
    }
    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8, 9));

        Solution sol = new Solution();
        int[]ret = sol.findDiagonalOrder(nums);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}