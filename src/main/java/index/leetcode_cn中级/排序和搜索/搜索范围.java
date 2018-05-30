package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-30.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class 搜索范围 {

    @Test
    public void go() {
        int[] arr = {1, 4};
        System.out.println(Arrays.toString(searchRange(arr, 4)));

    }

    /**
     * 二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] re = new int[2];
        re[0] = -1;
        re[1] = -1;
        if (nums == null || nums.length == 0) {
            return re;
        }

        int len = nums.length;
        if (len == 1) {
            if (nums[0] == target) {
                re[0] = 0;
                re[1] = 0;
                return re;
            }
            return re;
        }

        if (target < nums[0] || target > nums[len - 1]) {
            return re;
        }

        int left = 0;
        int right = len - 1;

        while (true) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                //由此搜索起止位置
                int i = mid;
                int j = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                while (j < len && nums[j] == target) {
                    j++;
                }
                i++;
                j--;
                re[0] = i;
                re[1] = j;
                return re;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                if (left == mid) {
                    left = mid + 1;
                } else {
                    left = mid;
                }
            }
        }

    }
}
