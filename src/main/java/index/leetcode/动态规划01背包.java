package index.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-11-12.
 */
public class 动态规划01背包 {

    int[] val = {3, 8, 4, 5};
    int[] w   = {2, 4, 3, 4};

    @Test
    public void test() {
        System.out.println(dp(5));
    }

    /**
     * @param capacity 当前背包容量
     * @return 最大价值
     */
    public int dp(int capacity) {

        // 3个物品，j容量
        int[][] T = new int[3][capacity + 1];

        //初始化第一行
        for (int j = 0; j < T[0].length; j++) {
            if (j >= w[0]) {
                T[0][j] = val[0];
            } else {
                T[0][j] = 0;
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                //如果能装下
                if (w[i] <= j) {
                    T[i][j] = Math.max(T[i - 1][j], val[i] + T[i - 1][j - w[i]]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(T));

        return T[2][capacity];
    }
}
