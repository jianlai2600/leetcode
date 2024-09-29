package 账户合并;

import java.security.Key;
import java.util.*;

class Solution {
    class ufs {
        int[]father;

        ufs(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {

            if (father[x] != x) {
                father[x] = find(father[x]);
            }
            return father[x];
        }

        public void join(int x, int y) {

            int f1 = find(x);
            int f2 = find(y);

            if (f1 != f2) {
                father[f2] = f1;
            }
        }
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>>ret = new ArrayList<>();

        int n = 0;
        Map<String, Integer> emailToIndex = new HashMap();
        Map<Integer, String> indexToEmail = new HashMap();
        Map<String, String> emailToName = new HashMap<String, String>();

        for (List<String>account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, n);
                    indexToEmail.put(n, email);
                    emailToName.put(email, name);
                    n++;
                }
            }
        }

        ufs group = new ufs(n);

        for (List<String>account : accounts) {

            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);

            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                group.join(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>>ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ind = group.find(i);
            if (ans.containsKey(ind)) {
                ans.get(ind).add(indexToEmail.get(i));
            } else {
                ans.put(ind, new ArrayList<>());
                ans.get(ind).add(indexToEmail.get(i));
            }
        }

        for (Integer key : ans.keySet()) {
            String name = emailToName.get(indexToEmail.get(key));
            List<String>tmp = ans.get(key);
            tmp.sort(Comparator.naturalOrder());

            List<String>toAdd = new ArrayList<>();
            toAdd.add(name);
            toAdd.addAll(tmp);

            ret.add(toAdd);
        }

        return ret;
    }
    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));

        Solution sol = new Solution();
        List<List<String>>ret = sol.accountsMerge(accounts);

        for (List<String> item : ret) {
            for (String s : item) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


