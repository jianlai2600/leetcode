package 最大交换;

class Solution {
    public int maximumSwap(int num) {

        int l = -1, r = -1, n = String.valueOf(num).length();
        int[]numArr = new int[n];

        int ind = n - 1, tmpNum = num;
        while (tmpNum > 0) {
            numArr[ind--] = tmpNum % 10;
            tmpNum /= 10;
        }

        boolean flag = false;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            int curNum = numArr[i];
            for (int j = i + 1; j < n; j++) {
                if (!find && numArr[j] > curNum) {
                    curNum = numArr[j];
                    l = i;
                    r = j;
                    flag = true;
                    find = true;
                }
                if (find && numArr[j] >= curNum) {
                    curNum = numArr[j];
                    l = i;
                    r = j;
                }
            }
            if (flag) {
                break;
            }
        }

        if (l == -1 && r == -1) {
            return num;
        }
        int tmp = numArr[l];
        numArr[l] = numArr[r];
        numArr[r] = tmp;

        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = ret * 10 + numArr[i];
        }

        return ret;
    }
    public static void main(String[] args) {

        int num = 98368;

        Solution sol = new Solution();
        int ret = sol.maximumSwap(num);

        System.out.println(ret);
    }
}

