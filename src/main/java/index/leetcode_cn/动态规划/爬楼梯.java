package index.leetcode_cn.动态规划;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 */
public class 爬楼梯 {

    @Test
    public void go() {


    }



    public static int num[] = new int[1000];
    static {
        num[1]=1;
        num[2]=2;
        for(int i =3;i<1000-1;i++){
            num[i] = num[i-1]+num[i-2];
        }
    }

    public int climbStairs(int n) {
        return num[n];
    }

    /**
     * 非递归形式斐波那契数列
     * 3ms 86.34%
     *
     * @param n
     * @return
     */
    public int climbStairs_2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int i = 1;
        int j = 2;
        int temp = 0;
        int index = 0;
        while (index < n - 2) {
            index++;

            temp = j;
            j = j + i;
            i = temp;
        }

        return j;
    }

    /**
     * 递归形式的斐波那契数列
     *
     * @param n
     * @return
     */
    public int climbStairs_1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
