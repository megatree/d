package index.leetcode_cn.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/66/
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 示例:
 * <p>
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
 * 返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
public class 颠倒二进制位 {

    @Test
    public void go() {
        System.out.println(Math.log(reverseBits(128))/Math.log(2));
    }

    /**
     * 2ms 77.08%
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            //r 少位移一次
            r = r << 1;

            r = r | (n & 1);

            n = n >> 1;

        }
        return r;
    }
}
