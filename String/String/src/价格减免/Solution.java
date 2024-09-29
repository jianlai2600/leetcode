package 价格减免;

import java.util.List;

class Solution {
    public String getProcessedWord(String word, int discount) {

        if (word.charAt(0) != '$') {
            return word;
        }
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                continue;
            } else {
                return word;
            }
        }
        if (word.length() == 1) {
            return word;
        }
        long num = Long.valueOf(word.substring(1, word.length()));
        double processedNum = num * (1.0 - (double) discount / 100);
        StringBuffer sb = new StringBuffer();
        sb.append("$");
        sb.append(String.format("%.2f", processedNum));
        return sb.toString();
    }
    public String discountPrices(String sentence, int discount) {

        StringBuffer sb = new StringBuffer();

        String[]list = sentence.split(" ");

        for (String word : list) {
            sb.append(getProcessedWord(word, discount) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public static void main(String[] args) {

        String sentence = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int discount = 28;

        Solution sol = new Solution();
        String res = sol.discountPrices(sentence, discount);

        System.out.println(res);
    }
}