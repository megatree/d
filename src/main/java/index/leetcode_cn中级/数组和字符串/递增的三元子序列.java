package index.leetcode_cn中级.数组和字符串;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-24.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/80/
 */
public class 递增的三元子序列 {

    @Test
    public void go() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};

        assert increasingTriplet(arr1);
        assert !increasingTriplet(arr2);

    }

    /**
     * 要求On O1
     * 5ms
     * 持有最小，次小两个变量，初始值 MAX
     * 当比最小值小时，替换最小，
     * 当大于最小 小于次小时，替换次小，
     * 当大于次小时，达到要求
     * <p>
     * 两个变量的意义是证明左侧存在 有比次小还小的数组成的递增子序列，
     * 所以最小数的索引大于次小数索引，是没关系的
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 4) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (min < nums[i] && nums[i] < min2) {
                min2 = nums[i];
            } else if (nums[i] > min2) {
                return true;
            }
        }
        return false;
    }

}
