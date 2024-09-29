package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer>row1 = new ArrayList<>();
        row1.add(1);
        ret.add(row1);
        if (numRows == 1)return ret;

        List<Integer>rowtmp = new ArrayList<>();
        rowtmp.add(1);
        rowtmp.add(1);
        ret.add(rowtmp);
        if (numRows == 2)return ret;

        for (int i = 2; i < numRows; i++){
            List<Integer> row = new ArrayList<>();

            row.add(1);
            for (int j = 1; j < i; j++){
                int num = rowtmp.get(j) + rowtmp.get(j - 1);
                row.add(num);
            }
            row.add(1);

            ret.add(row);
            rowtmp = new ArrayList<>(row);
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int numRows = 5;

        Solution sol = new Solution();
        List<List<Integer>> ret = sol.generate(numRows);

        for (List<Integer> row : ret){
            System.out.println(row.toString());
        }
        System.out.println();
    }
}


