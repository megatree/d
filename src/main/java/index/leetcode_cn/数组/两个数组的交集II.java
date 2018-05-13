package index.leetcode_cn.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-05-12.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 */
public class 两个数组的交集II {

    @Test
    public void main() {
        int[] nums1 = {4, 7, 9, 7, 6, 7};
        int[] nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //任一数组为空数组，应该返回空数组
        int[] empty = {};
        if (nums1 == null || nums1.length == 0) {
            return empty;
        }

        if (nums2 == null || nums2.length == 0) {
            return empty;
        }

        int[] shortArray;
        int[] longArray;
        shortArray = nums1.length < nums2.length ? nums1 : nums2;
        longArray = nums1.length >= nums2.length ? nums1 : nums2;

        //判断是否排序过
        boolean shortSorted = true;
        boolean longSorted = true;
        for (int i = 1; shortArray.length > 1 && i < shortArray.length; i++) {
            if (shortArray[i] < shortArray[i - 1]) {
                shortSorted = false;
                break;
            }
        }

        for (int i = 1; longArray.length > 1 && i < longArray.length; i++) {
            if (longArray[i] < longArray[i - 1]) {
                longSorted = false;
                break;
            }
        }

        //如果未排序，则将其排序
        if (!shortSorted) {
            Arrays.sort(shortArray);
        }

        if (!longSorted) {
            Arrays.sort(longArray);
        }

        //遍历两个数组，取交集
        int[] tempArr = new int[shortArray.length];
        int tempArrIndex = 0;

        int indexLong = 0;
        int lengthLong = longArray.length;

        int indexShort = 0;
        int lengthShort = shortArray.length;

        while (indexLong < lengthLong && indexShort < lengthShort) {
            if (shortArray[indexShort] < longArray[indexLong]) {
                indexShort++;
                continue;
            }

            if (shortArray[indexShort] > longArray[indexLong]){
                indexLong++;
                continue;
            }

            //两元素相等，记录
            tempArr[tempArrIndex] = shortArray[indexShort];
            tempArrIndex++;

            //两数组同时后移
            indexShort++;
            indexLong++;

        }

        //复制一份数组
        int[] result = new int[tempArrIndex];
        System.arraycopy(tempArr, 0, result, 0, tempArrIndex);
        return result;
    }

}
