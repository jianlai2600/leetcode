package AM_similarString;

public class Solution {
    /**
     * Finds how many substrings in review are similar to keyword
     * Two strings are similar if one can be transformed into the other
     * by swapping two adjacent characters at most once
     */
    public static int countSimilarStrings(String keyword, String review) {
        if (keyword == null || review == null || keyword.length() > review.length()) {
            return 0;
        }

        int count = 0;
        int keywordLength = keyword.length();

        // Check each possible substring of review
        for (int i = 0; i <= review.length() - keywordLength; i++) {
            String substring = review.substring(i, i + keywordLength);
            if (isSimilar(substring, keyword)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Checks if string s can be transformed into string t
     * by swapping two adjacent characters at most once
     */
    private static boolean isSimilar(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        // Try swapping each adjacent pair of characters
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            // Swap
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;

            // Check if strings are equal after swap
            if (String.valueOf(chars).equals(t)) {
                return true;
            }

            // Swap back
            temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }

        return false;
    }

    // Test the solution with the example from the problem
    public static void main(String[] args) {
        String keyword = "moon";
        String review = "monomon";

        int result = countSimilarStrings(keyword, review);
        System.out.println("Number of similar substrings: " + result);

        // Print all similar substrings for demonstration
        int keywordLength = keyword.length();
        for (int i = 0; i <= review.length() - keywordLength; i++) {
            String substring = review.substring(i, i + keywordLength);
            if (isSimilar(substring, keyword)) {
                System.out.println("Similar substring found at position " + i + ": " + substring);
            }
        }
    }
}