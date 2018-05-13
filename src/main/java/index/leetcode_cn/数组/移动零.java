package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-13.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 */
public class 移动零 {

    @Test
    public void go() {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速做法
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int unZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[unZeroCount] = nums[i];
                unZeroCount++;
            }
        }

        for (int i = unZeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 常规做法，其实并不需要严格判断非0位置，只需要找出为0位置覆盖就好
     * 最后几位为0一次刷新
     *
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int indexZero = 0;
        int index = 0;
        while (index < nums.length && indexZero < nums.length) {
            //zero下标找到位置
            while (indexZero < nums.length && nums[indexZero] != 0) {
                indexZero++;
            }

            //非0下标初始化
            if (index == 0) {
                index = indexZero + 1;
            }

            //非0下标找到位置
            while (index < nums.length && nums[index] == 0) {
                index++;
            }

            //程序结束条件，数组末尾正好为0
            if (index >= nums.length) {
                return;
            }

            //和上一个为0位置交换
            nums[indexZero] = nums[index];
            nums[index] = 0;
        }
    }
}
