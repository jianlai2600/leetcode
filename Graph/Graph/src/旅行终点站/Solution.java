package 旅行终点站;


import java.security.Key;
import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {

        Set<String>set = new HashSet<>();

        for (List<String>path : paths) {
            String s = path.get(0);
            set.add(s);
        }
        for (List<String>path : paths) {
            String d = path.get(1);
            if (!set.contains(d)) {
                return d;
            }
        }
        return "";
    }

    public static void main(String[] args) {

        List<List<String>>paths = new ArrayList<>();

        paths.add(new ArrayList<>(Arrays.asList("London", "New York")));
        paths.add(new ArrayList<>(Arrays.asList("New York", "Lima")));
        paths.add(new ArrayList<>(Arrays.asList("Lima", "Sao Paulo")));

        Solution sol = new Solution();
        String res = sol.destCity(paths);

        System.out.println(res);
    }
}


