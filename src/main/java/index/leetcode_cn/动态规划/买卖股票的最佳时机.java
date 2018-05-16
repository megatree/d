package index.leetcode_cn.动态规划;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 * <p>
 * 最多只允许完成一笔交易
 */
public class 买卖股票的最佳时机 {

    @Test
    public void go() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        assert maxProfit(arr) == 5;
    }

    /**
     *
     * 向后扫描，记录已扫描元素的最小值，
     * 让当前元素和最小值做差，更新每次最大差值
     *
     * 1 ms 99.86%
     * O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int everMax = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }

            int diff = prices[i] - min;
            if (diff > everMax) {
                everMax = diff;
            }
        }

        return everMax;
    }
}
