package UniqueWordsGenerator;

public class UniqueWordsGenerator {
    public static int countUniqueWords(int wordLen, int maxVowels) {
        if (wordLen == 0) return 0;

        // 定义dp数组
        int[] dpVowel = new int[wordLen + 1];
        int[] dpConsonant = new int[wordLen + 1];

        // 初始条件
        dpVowel[1] = 5; // 长度为1的元音结尾单词数量
        dpConsonant[1] = 21; // 长度为1的辅音结尾单词数量

        // 进行状态转移
        for (int i = 2; i <= wordLen; i++) {
            // 计算以辅音结尾的单词数
            dpConsonant[i] = 21 * (dpVowel[i - 1] + dpConsonant[i - 1]);

            // 计算以元音结尾的单词数，限制连续元音数
            dpVowel[i] = 5 * dpConsonant[i - 1];
            if (i > maxVowels) {
                dpVowel[i] += 5 * (dpVowel[i - 1] - dpVowel[i - maxVowels]);
            } else {
                dpVowel[i] += 5 * dpVowel[i - 1];
            }
        }

        // 返回总的有效单词数
        return dpVowel[wordLen] + dpConsonant[wordLen];
    }

    public static void main(String[] args) {
        int wordLen = 4;  // 示例单词长度
        int maxVowels = 1; // 示例最多连续元音数
        System.out.println("可以生成的唯一单词数: " + countUniqueWords(wordLen, maxVowels));
        // 412,776
    }
}
