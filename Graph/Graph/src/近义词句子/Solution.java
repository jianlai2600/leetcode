package 近义词句子;


import java.util.*;
class Solution {
    public class UnionFind {
        int size;
        int[]union;

        UnionFind(int n) {
            size = n;
            union = new int[size];

            for (int i = 0; i < size; i++) {
                union[i] = i;
            }
        }
        public int find(int element) {
            return union[element];
        }

        public boolean isConnected(int element1, int element2) {
            return find(element1) == find(element2);
        }

        public void unionTwoelement(int element1, int element2) {

            int firstFather = find(element1);
            int secondFather = find(element2);

            if (firstFather != secondFather) {
                for (int i = 0; i < size; i++) {
                    if (union[i] == firstFather) {
                        union[i] = secondFather;
                    }
                }
            }
        }
    }
    public String makeString(String[]textArr) {
        StringBuffer sb = new StringBuffer();
        for (String s : textArr) {
            sb.append(s + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public void backTracking(int ind) {

        if (ind >= textArr.length) {
            ret.add(makeString(textArr));
            return;
        }

        String original = textArr[ind];
        if (map.containsKey(original)) {
            for (int j = 0; j < n; j++) {
                if (uf.isConnected(map.get(original), j)) {
                    textArr[ind] = list.get(j);
                    backTracking(ind + 1);
//                    textArr[ind] = original;
                }
            }
        } else {
            backTracking(ind + 1);
        }
    }
    // Global variables
    List<String>ret;
    UnionFind uf;
    HashMap<String, Integer>map;
    List<String>list;
    String[]textArr;
    int n;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {

        textArr = text.split(" ");

        // Get all words in a list
        Set<String>set = new HashSet<>();
        for (List<String>list : synonyms) {
            set.addAll(list);
        }
        n = set.size();
        list = new LinkedList<>(set);

        // Make a map around words and Integer example: "happy->2"
        map = new HashMap<>();
        int ind = 0;
        for (String s : list) {
            map.put(s, ind++);
        }

        // Make a UnionFind object according to the map
        uf = new UnionFind(n);
        for (List<String>list : synonyms) {
            uf.unionTwoelement(map.get(list.get(0)), map.get(list.get(1)));
        }

        // Make the return variable
        ret = new ArrayList<>();

        // Precess DFS and backTracking
        backTracking(0);

        // Sort the return variable alphabetically
        ret.sort((a, b)->a.compareTo(b));

        return ret;
    }

    public static void main(String[] args) {

        List<List<String>> synonyms = Arrays.asList(
                Arrays.asList("happy", "joy"),
                Arrays.asList("sad", "sorrow"),
                Arrays.asList("joy", "cheerful")
        );
        String text = "I am happy today but was sad yesterday";

        Solution sol = new Solution();
        List<String> ret = sol.generateSentences(synonyms, text);

        for (String s : ret) {
            System.out.println(s);
        }
    }
}


