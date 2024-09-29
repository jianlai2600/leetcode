package 实现一个魔法字典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MagicDictionary {
    HashMap<Integer, List<String>>map;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {

        for (String word : dictionary) {
            int n = word.length();
            if (!map.containsKey(n)) {
                map.put(n, new ArrayList<>());
            }
            map.get(n).add(word);
        }
    }
    public boolean haveOneDifference(String s, String t) {

        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
    public boolean search(String searchWord) {

        int n = searchWord.length();
        if (!map.containsKey(n)) {
            return false;
        }
        List<String>list = map.get(n);
        for (String s : list) {
            if (haveOneDifference(s, searchWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        MagicDictionary md = new MagicDictionary();
        String[] dictionary = {"hello", "world"};
        md.buildDict(dictionary);

        boolean ret = md.search("hellc");

        System.out.println(ret);
    }
}



