package index.leetcode_cn.动态规划;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class 最大子序和 {

    @Test
    public void go() {

        assert maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6;
    }

    /**
     * 非动态规划法
     * 当前面子数组之和为负数，那么再加一个数一定小于这个数本身，
     * 这时应该抛弃前面的子数组，从当前数开始计算。
     *
     * 14ms 56.08%
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        //数组长度至少为2
        int everMax = nums[0];
        int preSub = everMax;
        for (int i = 1; i < nums.length; i++) {
            //前面子数组之和小于0，抛弃，从元素i重新计算
            if (preSub < 0) {
                preSub = nums[i];
            }else {
                preSub += nums[i];
            }
            if (preSub > everMax) {
                everMax = preSub;
            }
        }

        return everMax;

    }
}
