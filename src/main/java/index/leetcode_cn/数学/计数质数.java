package index.leetcode_cn.数学;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
 * <p>
 * 统计所有小于非负数整数 n 的质数的数量。
 */
public class 计数质数 {

    @Test
    public void go() {
        countPrimes(499979);

    }

    /**
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];

        for (int i = 2; i * i <= n; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                //符合这个公式的数均不为质数
                notPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }

        return count;

    }

    /**
     * 小于10 2/3/5/7
     * 所有大于10的质数中，个位数只有1,3,7，9。
     * <p>
     * NOTICE: 如果要判断一个数是否为素数，则需要从头到这个数进行循环%，时间复杂度极高
     * 我们可以找出不是素数的规律，用一个bool数组记录
     *
     * @param n
     * @return
     */
    public int countPrimes_1(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        if (n <= 5) {
            return 2;
        }
        if (n <= 7) {
            return 3;
        }
        if (n <= 11) {
            return 4;
        }

        //大于10，从11开始
        int[] units = {1, 3, 7, 9};
        int tens = 1;
        int primeCount = 4;
        boolean interrupt = false;
        for (; !interrupt; tens++) {
            for (int i = 0; i < units.length; i++) {
                int num = tens * 10 + units[i];
                if (num >= n) {
                    interrupt = true;
                    break;
                }

                //判断num是不是素数
                if (isPrime(num)) {
                    primeCount++;
                }
            }
        }
        return primeCount;
    }

    /**
     * 素数只能被1和它自身整除
     * 任何数都不能被大于自身一半的数整除
     * p*q = num 如果p<q，那么p< 根号num
     *
     * @param k
     * @return
     */
    public boolean isPrime(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
