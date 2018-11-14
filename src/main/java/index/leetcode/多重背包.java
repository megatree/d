package index.leetcode;

import org.junit.Test;

/**
 * Created by mythss on 2018-11-14.
 */
public class 多重背包 {

    @Test
    public void go() {
        int[] w = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int[] num = {8, 5, 2, 3};
        int capacity = 50;
        int r = pack(capacity, w, val, num);

        System.out.println(r);
    }


    /**
     * 多重背包
     * 一维数组
     *
     * @param capacity
     * @param w
     * @param val
     * @param num
     */
    public int pack(int capacity, int[] w, int[] val, int[] num) {
        int[] T = new int[capacity + 1];
        //w长度件物品
        for (int i = 0; i < w.length; i++) {
            multiPack(w[i], val[i], num[i], T, capacity);
        }

        int maxVal = T[capacity];
        return maxVal;
    }

    /**
     * 多重背包
     *
     * @param weight
     * @param value
     * @param num
     * @param dp
     * @param capacity
     */
    public void multiPack(int weight, int value, int num, int[] dp, int capacity) {
        if (weight * num >= capacity) {
            completePack(weight, value, dp, capacity);
            return;
        }

        int k = 1;
        while (k < num) {
            zeroOnePack(k * weight, k * value, dp, capacity);
            num -= k;
            k *= 2;
        }
        zeroOnePack(k * weight, k * value, dp, capacity);

    }

    public void zeroOnePack(int weight, int value, int[] dp, int capacity) {
        for (int j = capacity; j >= weight; j--) {
            dp[j] = Math.max(dp[j], dp[j - weight] + value);
        }
    }

    public void completePack(int weight, int value, int[] dp, int capacity) {
        for (int j = weight; j <= capacity; j++) {
            //在背包容量允许的情况下，完全背包，不计物品数量，因此weight系数不断上升
            dp[j] = Math.max(dp[j], dp[j - weight] + value);
        }
    }


}
