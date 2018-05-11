package index.leetcode_cn.数组;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-11.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */
public class 买卖股票的最佳时机II {

    @Test
    public void go() {

        assert maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 7;
        assert maxProfit(new int[]{1, 2, 3, 4, 5}) == 4;
        assert maxProfit(new int[]{7, 6, 4, 3, 1}) == 0;

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return sum;

    }


    /**
     * 记录最低、最高值
     * 后一元素下降时，本元素即为最高值
     *
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        //至少两天才能完成交易
        if (prices == null || prices.length < 2) {
            return 0;
        }


        //记录下标
        int minIdx = 0;
        int maxIdx = 0;
        int min = prices[minIdx];
        int max = prices[maxIdx];
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                minIdx = i;
                min = prices[i];
            } else if (prices[i] > max) {
                maxIdx = i;
                max = prices[i];
            }

            //交易
            //1、最高点下降时
            //2、最高点为末尾元素时
            //进行交易
            if ((i + 1 < prices.length && prices[i + 1] < max)) {
                sum += diffPriceSafe(max, min, maxIdx, minIdx);
                maxIdx = i + 1;
                minIdx = i + 1;
                min = prices[minIdx];
                max = prices[maxIdx];
                continue;
            }
            if ((i + 1) == prices.length) {
                sum += diffPriceSafe(max, min, maxIdx, minIdx);
                continue;
            }
        }

        return sum;
    }

    public int diffPriceSafe(int max, int min, int maxIdx, int minIdx) {
        return maxIdx > minIdx ? max - min : 0;
    }
}
