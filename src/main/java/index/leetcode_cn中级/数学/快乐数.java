package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-01.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/112/
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class 快乐数 {

    @Test
    public void go() {
        boolean b = isHappy(19);
        System.out.println(b);
    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }

        long sum = n;
        int index = 0;
        while (sum != 1) {
            if (index>10){
                return false;
            }

            long t = sumPowerOfDigit(sum);
            sum = t;
            index++;
        }
        return true;
    }

    public long sumPowerOfDigit(long src) {
        long sum = 0;
        while (src != 0) {
            long digit = src % 10;
            sum += digit * digit;
            src /= 10;
        }
        return sum;
    }
}
