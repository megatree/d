package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-06-15.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/128/
 * <p>
 * <p>
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class 第一个缺失的正数 {


    @Test
    public void go() {
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {3, 4, -1, 1};
        int[] nums = {1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int len = nums.length;
        //index = i,value = i+1
        int index = 0;
        while (index < len) {
            //超出范围、值与索引正好匹配、当前值与值对应索引位置的值相等，即重复情况
            if (nums[index] > len || nums[index] < 1 || nums[index] == index + 1||nums[index]==nums[nums[index]-1]) {
                index++;
            } else {
                swap(nums, index, nums[index] - 1);
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
