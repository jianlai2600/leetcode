package ProductOfNumbers;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer>preMulti;
    public ProductOfNumbers() {

        preMulti = new ArrayList<>();
        preMulti.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            preMulti = new ArrayList<>();
            preMulti.add(1);
        } else {

            preMulti.add(num * preMulti.getLast());
        }
    }

    public int getProduct(int k) {

        if (k >= preMulti.size()) {
            return 0;
        }
        int n = preMulti.size();
        return preMulti.getLast() / preMulti.get(n - k - 1);
    }
}