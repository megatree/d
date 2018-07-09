package index.leetcode_cn高级.排序和搜索;

import org.junit.Test;

/**
 * Created by mythss on 2018-07-09.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/153/
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 * <p>
 * <p>
 * https://blog.csdn.net/hk2291976/article/details/51107778
 */
public class 两个排序数组的中位数 {

    @Test
    public void go() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = 0, l2 = 0, r1 = 0, r2 = 0, c1, c2;
        int lo = 0, hi = 2 * n;
        //hi 为 2n+1 -1

        while (lo <= hi) {
            //数组1 2 的割
            c1 = (lo + hi) / 2;
            c2 = m + n - c1;

            l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            r1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];

            l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            r2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];

            if (l1 > r2) {
                //c1减 c2增 c1向左二分
                hi = c1 - 1;
            } else if (l2 > r1) {
                lo = c1 + 1;
            } else {
                //why
                break;
            }
        }

        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }


}






























