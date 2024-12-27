package 感染二叉树需要的总时间;

import java.util.*;

class Solution {
    public int getIndex(int num) {

        int sum = 0;
        int curNum = 1;
        int res = 0;
        while (sum < num) {
            sum += curNum;
            curNum *= 2;
            res++;
        }
        return res;
    }
    public int transformNum(int num, int index) {
        int curNum = num;
        if (index % 2 == 0) {
            int down = (int)Math.pow(2, index - 1);
            int up = (int)Math.pow(2, index) - 1;
            curNum = up - num + down;
        }
        return curNum;
    }
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer>list = new ArrayList<>();
        int index = getIndex(label);

        // 2^(n-1) --- 2^n - 1

        int curNum = transformNum(label, index);

        while (curNum >= 1) {
            list.add(curNum);
            curNum /= 2;
        }
        list = list.reversed();

        for (int i = 0; i < list.size(); i++) {
            list.set(i, transformNum(list.get(i), i + 1));
        }

        return list;
    }

    public static void main(String[] args){

        Solution sol = new Solution();
        List<Integer>res = sol.pathInZigZagTree(14);

        System.out.println(res.toString());
    }
}

