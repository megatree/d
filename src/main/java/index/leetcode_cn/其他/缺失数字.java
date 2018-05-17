package index.leetcode_cn.其他;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/69/
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class 缺失数字 {

    @Test
    public void go() {
        int[] arr = {3, 0, 1};
        assert missingNumber(arr) == 2;

        int[] arr2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assert missingNumber(arr2) == 8;

    }

    /**
     * 1 ms
     * 92.43%
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;

        int sum = len * (len + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;

    }
}
