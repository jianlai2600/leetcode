package 扁平化嵌套列表迭代器;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        int n = nestedList.size();
        stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {
            NestedInteger tmp = stack.peek();
            if (tmp.isInteger()) {
                return true;
            }
            stack.pop();
            List<NestedInteger> tmpArr = tmp.getList();
            int len = tmpArr.size();

            for (int i = len - 1; i >= 0; i--) {
                stack.push(tmpArr.get(i));
            }
        }
        return false;
    }
}
