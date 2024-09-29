package 基于时间的键值存储;

import java.util.*;

class TimeMap {
    class node {
        String k, v;
        int t;
        node(String _k, String _v, int _t) {
            k = _k;
            v = _v;
            t = _t;
        }
    }
    Map<String, List<node>>map;
    public TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {

        List<node>list = map.getOrDefault(key, new ArrayList<>());
        list.addLast(new node(key, value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {

        List<node> list = map.getOrDefault(key, new ArrayList<>());
        if (list.isEmpty()) {
            return "";
        }
        int n = list.size();
        int left = 0, right = n - 1;

        if (timestamp < list.get(0).t) {
            return "";
        }
        if (timestamp > list.get(n - 1).t) {
            return list.get(n - 1).v;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).t == timestamp) {
                return list.get(mid).v;
            } else if (list.get(mid).t < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list.get(right).v;
    }
}