package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-06-19.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/130/
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class 寻找重复数 {

    @Test
    public void go() {
        int[] nums = {1, 3, 4, 2, 2};
        assert 2 == findDuplicate(nums);
    }

    /**
     * 数字在1~n之间，在这之间可能有一个数是重复的
     * 如果没有重复数字，<=n 出现的次数是n
     * <p>
     * 于是根据出现次数count 与mid 的关系确定在左或右范围内找
     *
     * 5ms
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 1;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }
}
