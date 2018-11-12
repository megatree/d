package index.leetcode_cn.动态规划;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class 打家劫舍 {

    @Test
    public void go() {
        int[] nums = {2, 7, 9, 3, 1};
        assert rob(nums) == 12;

    }

    /**
     * dp(i) = max( dp(i-1), dp(i-2) + nums[i])
     * 在dp i-1 与 dp i-2 加 当前值 中找出最大的
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        int g = 0;
        int t = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = g;
            g = Math.max(g, t + nums[i]);
            t = tmp;

            //max参数 g t仅相差一代，符合方程描述
        }

        return g;

    }


}
