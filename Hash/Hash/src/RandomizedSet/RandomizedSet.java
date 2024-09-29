package RandomizedSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    int index;
    Map<Integer, Integer> map;
    int[]list;
    public RandomizedSet() {

        index = -1;
        map = new HashMap<>();
        list = new int[200010];
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        } else {

            map.put(val, ++index);
            list[index] = val;
            return true;
        }
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int lastVal = list[index];

        int curIndex = map.get(val);
        if (curIndex == index) {
            index--;
            map.remove(val);
        } else {
            list[curIndex] = lastVal;
            index--;
            map.remove(val);
            map.put(lastVal, curIndex);
        }

        return true;
    }

    public int getRandom() {

        Random random = new Random();
        int ind = random.nextInt(index + 1);

        return list[ind];
    }
}
