package index.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-11-13.
 * <p>
 * 完全背包是01背包变种，
 */
public class 完全背包 {

    int[] val = {3, 8, 4, 5};
    int[] w   = {2, 4, 3, 4};

    @Test
    public void test() {
        System.out.println(dp(50));
        System.out.println(dp2(50));
    }

    /**
     * 完全背包问题，设物品数量为3，序号为0..2
     * 二维数组解法
     * 把数量k 和 物品组合一起，视作k个物品
     *
     * @param capacity
     * @return
     */
    public int dp(int capacity) {
        int[] pre = new int[capacity + 1];
        int[] cur = new int[capacity + 1];

        //初始化pre
        for (int j = 0; j < capacity + 1; j++) {
            for (int k = 0; k * w[0] <= j; k++) {
                pre[j] = k * w[0];
            }
        }

        //外层循环物品
        for (int i = 0; i < 3; i++) {
            //内层循环容量
            for (int j = 0; j < capacity + 1; j++) {
                //物品数量，从0到k
                for (int k = 0; k * w[i] <= j; k++) {
                    //k=0不放当前物品，到在之前最优解的情况下，放入k个当前物品
                    cur[j] = Math.max(cur[j], pre[j - k * w[i]] + k * val[i]);
                }
            }

            //替换
            pre = cur;
        }

        //打印状态
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(cur));
        return cur[capacity];
    }


    /**
     * 省略k重复计算
     *
     * @param capacity
     * @return
     */
    public int dp2(int capacity) {
        int[] pre = new int[capacity + 1];
        int[] cur = new int[capacity + 1];

        //初始化pre
        for (int j = 0; j < capacity + 1; j++) {
            for (int k = 0; k * w[0] <= j; k++) {
                pre[j] = k * w[0];
            }
        }

        //外层循环物品
        for (int i = 0; i < 3; i++) {
            //内层循环容量
            for (int j = 0; j < capacity + 1; j++) {
                if (j < w[i]) {
                    //不放入
                    cur[j] = pre[j];
                } else {
                    //用了k-1个w[i]的最优价值，已经在cur[]中差一个w[i]的位置计算过了
                    cur[j] = Math.max(pre[j], cur[j - w[i]] + val[i]);
                }
            }
            //替换
            pre = cur;
        }

        //打印状态
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(cur));
        return cur[capacity];
    }
}
