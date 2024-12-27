package 从给定原材料中找到所有可以做出的菜;


import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer>inDegrees = new HashMap<>();

        int n = recipes.length;
        for (int i = 0; i < n; i++) {

            List<String>list = ingredients.get(i);
            for (int j = 0; j < list.size(); j++) {
                map.putIfAbsent(list.get(j), new ArrayList<>());
                map.get(list.get(j)).add(recipes[i]);
            }
            inDegrees.put(recipes[i], list.size());
        }

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            queue.offer(supplies[i]);
        }

        while (!queue.isEmpty()) {
            String curFood = queue.poll();
            if (!map.containsKey(curFood)) {
                continue;
            }
            for (String key : map.get(curFood)) {
                inDegrees.put(key, inDegrees.get(key) - 1);
                if (inDegrees.get(key) == 0) {
                    res.add(key);
                    queue.offer(key);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        // 初始化 recipes
        String[] recipes = {"bread", "sandwich"};

        // 初始化 ingredients
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour")); // bread 的原料
        ingredients.add(Arrays.asList("bread", "meat"));  // sandwich 的原料

        // 初始化 supplies
        String[] supplies = {"yeast", "flour", "meat"};

        Solution sol = new Solution();
        List<String> res = sol.findAllRecipes(recipes, ingredients, supplies);

        for (String s : res) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}


