package 单词接龙;

import java.util.*;

class Solution {
    public boolean isAdjacent(String s, String t) {

        int ret = 0;
        int m = s.length();
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ret++;
            }
        }
        return ret == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        Set<String>set = new HashSet<>(wordList);
        wordList = new ArrayList<>(set);
        int m = wordList.size();
        // Make graph
        Map<String, List<String>>graph = new HashMap<>();
        for (String s : wordList) {
            graph.put(s, new ArrayList<>());
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                String s = wordList.get(i);
                String t = wordList.get(j);

                if (isAdjacent(s, t)) {
                    graph.get(s).add(t);
                    graph.get(t).add(s);
                }
            }
        }
        int distance = 1;
        Queue<String>queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String>wordSet = new HashSet<>();
        wordSet.add(beginWord);

        if (graph.isEmpty()) {
            return 0;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();

                if (node.equals(endWord)) {
                    return distance;
                }

                for (String neighbor : graph.get(node)) {
                    if (!wordSet.contains(neighbor)) {
                        queue.add(neighbor);
                        wordSet.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return 0;
    }

    public static void main(String[] args) {

        List<String>wordList = new ArrayList<>();
        wordList.add("talk");
        wordList.add("tons");
        wordList.add("fall");
        wordList.add("tail");
        wordList.add("gale");
        wordList.add("hall");
        wordList.add("negs");

        String beginWord = "talk", endWord = "tail";

        Solution sol = new Solution();
        int ret = sol.ladderLength(beginWord, endWord, wordList);

        System.out.println(ret);
    }
}


