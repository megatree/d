package index.leetcode_cn中级.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-05.
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/119/
 *
 *
 */
public class 两整数之和 {

    @Test
    public void go(){
        System.out.println(getSum(9,0));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}
