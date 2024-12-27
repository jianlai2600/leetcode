package clip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class clipTest {

    @Test
    public void testClipLengthOne() {
        // 测试片段长度为1的情况
        int clipLength = 1;
        int diff = 0;
        long expected = 26;  // 单个字符的片段总数应该是26个
        long result = clip.countBalancedClips(clipLength, diff);
        assertEquals(expected, result);
    }

    @Test
    public void testClipLengthTwoDiffThree() {
        // 测试片段长度为2，最大差值为3
        int clipLength = 2;
        int diff = 3;
        long expected = 170;  // 手动计算平滑片段数目
        long result = clip.countBalancedClips(clipLength, diff);
        assertEquals(expected, result);
    }

    @Test
    public void testClipLengthTwoDiffZero() {
        // 测试片段长度为2，最大差值为0（必须是相同的字符）
        int clipLength = 2;
        int diff = 0;
        long expected = 26;  // 所有平滑片段都必须是相同的字符，共26种
        long result = clip.countBalancedClips(clipLength, diff);
        assertEquals(expected, result);
    }

    @Test
    public void testClipLengthThreeDiffOne() {
        // 测试片段长度为3，最大差值为1
        int clipLength = 3;
        int diff = 1;
        long expected = 224;  // 手动计算平滑片段数目
        long result = clip.countBalancedClips(clipLength, diff);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeClipLength() {
        // 测试较大的片段长度，检查程序是否能处理大输入
        int clipLength = 1000;
        int diff = 25;  // 最大的可能差值
        long result = clip.countBalancedClips(clipLength, diff);
        assertTrue(result > 0);  // 检查结果是否有效，具体结果可能较大且难以手动验证
    }
}
