package MyHashMap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {
    private class Pair {
        int key, value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }
        public int getKey() {
            return this.key;
        }
        public int getValue() {
            return this.value;
        }
        public void setValue(int v) {
            value = v;
        }
    }
    static final int BASE = 1000;
    LinkedList<LinkedList<Pair>>map;
    public MyHashMap() {

        map = new LinkedList<>();
        for (int i = 0; i < BASE; i++) {
            map.add(new LinkedList<>());
        }
    }

    public int hash(int k) {
        return k % BASE;
    }
    public void put(int key, int value) {

        LinkedList<Pair>list = map.get(hash(key));
        Iterator<Pair>iterator = list.iterator();

        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }

        }

        list.offerLast(new Pair(key, value));
    }

    public int get(int key) {

        LinkedList<Pair>list = map.get(hash(key));
        Iterator<Pair>iterator = list.iterator();

        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }

        return -1;
    }

    public void remove(int key) {

        LinkedList<Pair>list = map.get(hash(key));
        Iterator<Pair>iterator = list.iterator();

        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                list.remove(pair);
                return;
            }
        }
    }
}