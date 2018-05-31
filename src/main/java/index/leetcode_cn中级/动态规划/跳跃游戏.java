package index.leetcode_cn中级.动态规划;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-31.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/104/
 */
public class 跳跃游戏 {

    @Test
    public void go() {
        int[] arr1 = {3, 2, 1, 0, 4};
        assert !canJump(arr1);

        int[] arr2 = {2, 3, 1, 1, 4};
        assert canJump(arr2);

    }

    @Test
    public void go2() {
        int[] arr = {3, 0, 8, 2, 0, 0, 1};
        assert canJump(arr);
    }

    /**
     * 7 ms 96.05%
     *
     * @param nums
     * @return
     */
    public boolean canJump_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int preValMin = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i == 0 && nums[0] < preValMin) {
                return false;
            }

            if (nums[i] == 0) {
                preValMin++;
                continue;
            }

            if (nums[i] >= preValMin) {
                preValMin = 1;
                continue;
            }

            //当前步数不符合preValMin，需要将本步加上
            preValMin++;
        }
        return true;
    }

    /**
     * 递归方式
     * 8ms 84.98%
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        return dp(nums, nums.length - 2, 1);
    }

    public boolean dp(int[] nums, int i, int expectMinVal) {
        //前面没有错误结果
        if (i < 0) {
            return true;
        }

        //第一个元素若仍不满足条件，false
        if (i == 0 && nums[0] < expectMinVal) {
            return false;
        }

        if (nums[i] < expectMinVal) {
            expectMinVal++;
        } else {
            expectMinVal = 1;
        }

        return dp(nums, i - 1, expectMinVal);
    }


}
