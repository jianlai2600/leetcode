package 子域名访问计数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String makeString(String[]arr) {

        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            sb.append(item + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer>map = new HashMap<>();

        for (String domain : cpdomains) {
            String[]tmp = domain.split(" ");
            int num = Integer.parseInt(tmp[0]);
            String d = tmp[1];
            String[]arr = d.split("\\.");
            int len = arr.length;

            for (int i = 1; i <= len; i++) {
                String[]key = Arrays.copyOfRange(arr, len - i, len);
                String k = makeString(key);
                map.put(k, map.getOrDefault(k, 0) + num);
            }
        }
        List<String>res = new ArrayList<>();

        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(map.get(key)));
            sb.append(" " + key);

            res.add(sb.toString());
        }
        return res;
    }
    public static void main(String[] args) {

        String[]cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        Solution sol = new Solution();
        List<String> ret = sol.subdomainVisits(cpdomains);

        for (String item : ret) {
            System.out.println(item);
        }
        System.out.println();
    }
}



