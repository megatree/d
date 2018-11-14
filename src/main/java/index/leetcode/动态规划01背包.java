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
        System.out.println(dp2(5));
        System.out.println(dp3(3, 5));
        System.out.println(dp4(5));
    }

    /**
     * 由于之前结果只用到i - 1，因此只需要存储两行数据
     *
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

    /**
     * 简化存储
     * 本质还是二维数组，此时内层循环正序即可
     *
     * @param capacity
     * @return
     */
    public int dp2(int capacity) {

        int[] pre = new int[capacity + 1];
        int[] cur = new int[capacity + 1];

        //初始化pre数组
        for (int j = 0; j < pre.length; j++) {
            if (j >= w[0]) {
                pre[j] = val[0];
            } else {
                pre[j] = 0;
            }
        }


        //开始计算
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                //当前容量能装下物品i
                if (j >= w[i]) {
                    cur[j] = Math.max(pre[j], pre[j - w[i]] + val[i]);
                } else {
                    cur[j] = pre[j];
                }
            }
            //切换pre
            pre = cur;
        }

        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(cur));
        return cur[capacity];
    }

    /**
     * 01 背包问题的递归实现
     *
     * @param n        物品数量
     * @param capacity 背包容量
     * @return
     */
    public int dp3(int n, int capacity) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        //物品索引
        int i = n - 1;
        //当前容量
        int j = capacity;

        if (j >= w[i]) {
            //能装下物品i，选择
            return Math.max(dp3(n - 1, j), val[i] + dp3(n - 1, j - w[i]));
        }

        return dp3(n - 1, j);
    }


    /**
     * 非递归方式
     * 转化为一维数组，内层循环使用倒序
     *
     * @param capacity
     * @return
     */
    public int dp4(int capacity) {
        int[] T = new int[capacity + 1];
        T[0] = 0;

        //外层循环物品种类
        for (int i = 0; i < 3; i++) {
            //假设只有1个物品，j>=w[i]保证容量足够放进去，不然无需计算
            for (int j = capacity; j >= w[i]; j--) {
                T[j] = Math.max(T[j], T[j - w[i]] + val[i]);
                //其实算到最后一层，计算出capacity即可，前面无需计算
            }
        }
        return T[capacity];
    }
}
