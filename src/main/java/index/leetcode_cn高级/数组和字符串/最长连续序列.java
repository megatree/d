package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhe.bj on 2018-06-19.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/129/
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class 最长连续序列 {

    @Test
    public void go() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assert 4 == longestConsecutive(nums);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> keyCountMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer k = keyCountMap.getOrDefault(nums[i], 0);
            keyCountMap.put(nums[i], k + 1);
        }

        int totalMax = 0;
        for (int i = 0; i < nums.length; i++) {

            if (isExists(keyCountMap, nums[i])) {
                //向前找
                int max = 1;
                int cur = nums[i];
                while (isExists(keyCountMap, ++cur)) {
                    max++;
                }
                //向后找
                cur = nums[i];
                while (isExists(keyCountMap, --cur)) {
                    max++;
                }

                totalMax = Math.max(totalMax, max);
            }
        }
        return totalMax;
    }

    public boolean isExists(Map<Integer, Integer> keyCountMap, Integer key) {
        Integer k = keyCountMap.getOrDefault(key, 0);
        if (k > 0) {
            //此数存在
            keyCountMap.put(key, k - 1);
            return true;
        }
        return false;
    }
}
