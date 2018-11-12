package index.leetcode;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-11-12.
 *
 * 动态规划
 *
 * <p>
 * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化，返回你可以获得的最大乘积
 * 例如，给定n=2，返回1（2=1+1）
 * 给定n=10，返回36（10=3+3+4）
 * 你可以假设n不小于且不大于58 （个人理解，int类型足够）
 */
public class 整数拆分343 {

    @Test
    public void test() {
        assert integerBreak(12) == 81;
        assert integerBreak(11) == 54;
    }

    /**
     * 根据规律，4以上的都可以拆成2和3，比如5，一定是2*3 最大
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 4) {
            return n == 4 ? 4 : n - 1;
        }

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        return result * n;
    }
}
