package index.questions;

import index.basicAlgo.Sorts;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/11/6.
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 7, 8, 12, 15, 33, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        System.out.println(moreThanHalfbyPartition(arr));

    }

    /**
     * 采用partition思想
     * 让中间元素左边都比他小，右边都比他大，但是左右两边不一定排序
     *
     * @param arr
     * @return
     */
    public static int moreThanHalfbyPartition(int[] arr) {
        if (!checkInvalidArray(arr)) {
            throw new IllegalArgumentException("参数不合法");
        }

        int middle = arr.length / 2;
        int start = 0;
        int end = arr.length - 1;
        int index = Sorts.partition2(arr, start, end);

        System.out.println("index:" + index + " middle:" + middle + " arr:" + Arrays.toString(arr));

        while (index != middle) {

            if (index > middle) {
                end = index - 1;
                index = Sorts.partition2(arr, start, end);
            } else {
                start = index + 1;
                index = Sorts.partition2(arr, start, end);
            }

            System.out.println("index:" + index + " middle:" + middle + " arr:" + Arrays.toString(arr));
        }
        int r = arr[middle];

        if (!checkMoreThanHalf(arr, r)) {
            throw new IllegalArgumentException("参数不合法");
        }

        return r;
    }

    /**
     * 复杂度为O(n)的算法
     *
     * @param arr
     * @return
     */
    public static int moreThanHalf0n(int[] arr) {
        if (!checkInvalidArray(arr)) {
            throw new IllegalArgumentException("参数不合法");
        }

        int k = 0;
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                k = arr[i];
            }

            if (k == arr[i]) {
                times++;
            } else {
                times--;
            }
        }

        if (!checkMoreThanHalf(arr, k)) {
            throw new IllegalArgumentException("参数不合法");
        }
        return k;

    }

    /**
     * @param arr
     * @return
     */
    public static boolean checkInvalidArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return true;


    }

    /**
     * 检查所查到元素是否大于数组长度一半
     *
     * @param arr
     * @param n
     * @return
     */
    public static boolean checkMoreThanHalf(int[] arr, int n) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                k++;
            }
        }
        if (2 * k <= arr.length) {
            return false;
        }
        return true;
    }
}
