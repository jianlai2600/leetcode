package 大礼包;

import java.util.*;

class Solution {
    int n;
    Map<List<Integer>, Integer>memory;
    public List<Integer> apply(List<Integer>offer, List<Integer> needs) {

        List<Integer>updatedNeed = new ArrayList<>(needs);
//        Collections.copy(updatedNeed, needs);

        for (int i = 0; i < needs.size(); i++) {
            int cnt = offer.get(i);

            if (needs.get(i) - cnt < 0) {
                return null;
            } else {
                updatedNeed.set(i, needs.get(i) - cnt);
            }
        }
        return updatedNeed;
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        if (memory.containsKey(needs)) {
            return memory.get(needs);
        }

        int minSum = 0;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += price.get(i) * needs.get(i);
        }
        minSum = curSum;

        for (int i = 0; i < special.size(); i++) {
            List<Integer>offer = special.get(i);
            List<Integer>updatedNeed = apply(offer, needs);
            if (updatedNeed != null) {
                minSum = Math.min(minSum, offer.get(offer.size() - 1) + dfs(price, special, updatedNeed));
            }
        }
        memory.put(needs, minSum);
        return minSum;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        n = price.size();
        memory = new HashMap<>();
        return dfs(price, special, needs);
    }
    public static void main(String[] args) {

        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);

        Solution sol = new Solution();
        int res = sol.shoppingOffers(price, special, needs);

        System.out.println(res);
    }
}


