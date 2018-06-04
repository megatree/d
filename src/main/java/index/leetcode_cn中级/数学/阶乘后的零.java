package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by mythss on 2018-06-02.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/113/
 * <p>
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class 阶乘后的零 {

    @Test
    public void go() {

    }

    public int trailingZeroes(int n) {
        int re = 0;
        while (n >= 5) {
            n /= 5;
            re += n;
        }
        return re;
    }

}
