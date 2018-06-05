package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-05.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/117/
 */
public class 两数相除 {

    @Test
    public void go() {


    }

    public int divide(int dividend, int divisor) {

        //非法
        if (divisor == 0) {
            return -1;
        }

        //符号不同，结果应为负数
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;


        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        if (dvd == dvs) {
            return 1 * sign;
        }

        if (dvs == 1) {
            if (dividend < 0 && sign > 0 && dvd > Integer.MAX_VALUE) {
                dvd = Integer.MAX_VALUE;
            }
            return (int) (dvd * sign);
        }

        int result = 0;

        //用减法代替除法
        while (dvs < dvd) {
            long tmp = dvs;
            long mul = 1;

            //被除数大于除数的两倍,
            //两倍两倍的算，减少时间复杂度，O(lgn)
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            dvd -= tmp;
            result += mul;
        }

        return result * sign;

    }
}
