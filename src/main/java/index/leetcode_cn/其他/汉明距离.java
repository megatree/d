package index.leetcode_cn.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/65/
 */
public class 汉明距离 {

    @Test
    public void go() {
        assert hammingDistance(1, 4) == 2;
    }

    /**
     * 有符号整型 9ms 74.8%
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {

        int count = 0;
        for (int i = 0; i < 31; i++) {
            int a = x & 1;
            int b = y & 1;
            if (a != b) {
                count++;
            }

            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}
