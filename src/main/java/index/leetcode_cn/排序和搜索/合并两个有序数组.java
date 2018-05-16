package index.leetcode_cn.排序和搜索;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
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

        int i = m + n - 1;
        int index1 = m - 1;
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
