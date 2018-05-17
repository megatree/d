package index.leetcode_cn.数学;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/62/
 * <p>
 * 给出一个整数，写一个函数来确定这个数是不是3的一个幂。
 * <p>
 * 后续挑战：
 * 你能不使用循环或者递归完成本题吗？
 */
public class _3的幂 {

    static Set<Integer> set = new HashSet<>();

    static {
        long temp = 3;
        while (temp < Integer.MAX_VALUE) {
            set.add((int) temp);
            temp *= 3;
        }
    }

    @Test
    public void go() {
//        assert isPowerOfThree(81);
//        assert isPowerOfThree(9);
//        assert !isPowerOfThree(8);

        isPowerOfThree(2147483647);

    }

    /**
     * 53.68%
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n < 0) {
            return false;
        }

        // 0...1 之间不符合要求
        if (n == 1) {
            return true;
        }

        return set.contains(n);
    }

}
