package 根据频率重新构造字符串;

import java.security.KeyPair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer>map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuffer sb = new StringBuffer();

        PriorityQueue<Map.Entry<Character, Integer>>pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return  o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });

        for (Map.Entry<Character, Integer>entry : map.entrySet()) {
            pq.add(entry);
        }

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer>entry = pq.poll();

            char c = entry.getKey();
            int n = entry.getValue();

            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        String s = "mammambbba";

        Solution sol = new Solution();
        String ret = sol.frequencySort(s);

        System.out.println(ret);
    }
}