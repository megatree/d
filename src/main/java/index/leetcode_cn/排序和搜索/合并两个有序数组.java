package index.leetcode_cn.排序和搜索;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
 */
public class 合并两个有序数组 {

    @Test
    public void go() {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }


    /**
     * 解法1
     * 先补全，再排序
     * <p>
     * 5ms 50%
     * O(n log(n))
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    /**
     * 解法2
     * 从后往前扫描
     * 由于两个数组是有序的，因此从两个数组末尾向前扫，比较取出大的那个放在位置上
     *
     * O(n)
     * 4ms 91.71%
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        //末尾下标
        int i = m + n - 1;
        //数组1末尾
        int index1 = m - 1;
        //数组2末尾
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[i] = nums1[index1];
                index1--;
            } else {
                nums1[i] = nums2[index2];
                index2--;
            }
            i--;
        }

        //index2 剩下的填入nums1
        if (index2 >= 0) {
            for (int j = index2; j >= 0 && i >= 0; j--, i--) {
                nums1[i] = nums2[j];
            }
        }
    }

}
