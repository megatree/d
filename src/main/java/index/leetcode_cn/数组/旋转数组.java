package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-11.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class 旋转数组 {

    @Test
    public void go() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 3次翻转数组
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        k = k % length;

        rotateSelf(nums, 0, length - k - 1);

        rotateSelf(nums, length - k, length - 1);

        rotateSelf(nums, 0, nums.length - 1);
    }

    /**
     * 反转数组
     *
     * @param arr
     * @param start
     * @param end
     */
    public void rotateSelf(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    /**
     * 元素挨个移动，慢
     *
     * @param nums
     * @param k
     */
    public void rotate_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        if (length <= k) {
            k = k % length;
        }

        int temp = 0;
        if (k > length / 2) {
            //最左侧length-k个元素移动到右侧
            int cycle = length - k;

            for (int i = 0; i < cycle; i++) {
                temp = nums[0];

                for (int j = 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }

                nums[length - 1] = temp;
            }


        } else {
            //最右侧length-k个元素移动到左侧
            for (int i = 0; i < k; i++) {
                temp = nums[length - 1];

                for (int j = length - 2; j >= 0; j--) {
                    nums[j + 1] = nums[j];
                }

                nums[0] = temp;
            }

        }

        System.out.println(Arrays.toString(nums));
    }
}
