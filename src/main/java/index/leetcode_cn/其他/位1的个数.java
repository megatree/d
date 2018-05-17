package index.leetcode_cn.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/64/
 */
public class 位1的个数 {

    @Test
    public void go() {
        assert hammingWeight(11) == 3;
        assert hammingWeight(128) == 1;

    }

    /**
     * 1ms 100%
     * @param n 无符号整数
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }

            n = n >> 1;
        }
        return count;
    }
}
