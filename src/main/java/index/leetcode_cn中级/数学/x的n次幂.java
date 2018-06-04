package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by mythss on 2018-06-04.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/115/
 */
public class x的n次幂 {

    @Test
    public void go() {
        System.out.println(myPow(-1.00, -2147483647));
    }


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        if (x == -1) {
            long xn = n;
            if (xn < 0) {
                xn = -xn;
            }
            if (xn % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        boolean isNegative = false;
        long ln = n;
        if (ln < 0) {
            ln *= -1;
            isNegative = true;
        }

        double src = x;
        Double last = null;
        for (int i = 1; i < ln; i++) {
            x = src * x;

            if (last != null && x == last) {
                break;
            }

            if (isNegative && x > 1000000) {
                return 0;
            }

            last = x;
        }
        if (isNegative) {
            x = 1 / x;
        }
        return x;
    }



    /**
     *  example: 2^10
     *
     *  (10)10 = (1010)2
     *  2^10 = 2^(2^0 * 0 + 2^1 * 1 + 2^2 * 0 + 2^3 * 1)
     *       = 2^(0 + 2 + 0 + 8)
     *       = 2^10
     *
     * @param x base
     * @param n pow
     * @return result
     */
    public double myPow_(double x, int n) {
        double pow = 1.0;
        x = n >= 0 ? x : 1 / x;
        n = (n >= 0) ? n : n * -1;
        while (n != 0) {
            if ((n&1) != 0) { // n % 2 != 0
                pow *= x;
            }
            x *= x;
            n /= 2; // n /= 2
        }
        return pow;
    }

}
