package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-05-30.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/99/
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class 寻找峰值 {

    private int min = Integer.MIN_VALUE;

    @Test
    public void go() {


    }

    /**
     * 跟On遍历一样速度
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }

        int left = 0;
        int right = len - 1;
        while (true) {
            int mid = (left + right) >> 1;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    /**
     * On
     *
     * @param nums
     * @return
     */
    public int findPeakElement_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
