package index.leetcode_cn中级.排序和搜索;

import index.basicAlgo.Sorts;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-30.
 * <p>
 * 快速排序-分区算法有下面几种
 * 1. 挖坑填坑 - 正确
 *
 * 2. 两头交换 - bug
 * （本质上前两种属于一种）
 *
 * 3. 顺序遍历，并通过交换，维持一个指针，使数组分为三部分：小于pivot 大于pivot 未扫描到的
 *  - 正确
 */
public class 快速排序研究 {

    @Test
    public void test1() {
        int[] arr = {99, 3, 2, 3, 88, 1, 4, 5, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int p = partition(nums, begin, end);

        quickSort(nums, begin, p - 1);
        quickSort(nums, p + 1, end);
    }


    /**
     * 1. 挖坑填坑法
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public int partition(int[] arr, int begin, int end) {
        //选取头部
        int pivot = arr[begin];

        while (begin < end) {
            while (begin < end && arr[end] > pivot) {
                end--;
            }

            if (begin < end) {
                //填坑,尾端找到小于等于pivot的数，移动到头部
                arr[begin] = arr[end];
                //arr[end] 是挖的坑
                begin++;
            }

            while (begin < end && arr[begin] < pivot) {
                begin++;
            }

            if (begin < end) {
                arr[end] = arr[begin];
                end--;
            }
        }

        //begin end相遇
        arr[begin] = pivot;
        return begin;
    }

    @Test
    public void test2() {
        int[] arr = {3, 2, 3, 1, 4, 5, 1};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    @Deprecated
    public void quickSort2(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

//        int pivotIndex = ((end - begin) >> 1) + begin;
        int pivotIndex = begin;
        int[] p = partition2(nums, begin, end, pivotIndex);

        quickSort2(nums, begin, p[1]);
        quickSort2(nums, p[0], end);
    }

    /**
     * 两头交换法（指定基准值）
     * 存在bug
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    @Deprecated
    public int[] partition2(int[] arr, int begin, int end, int pivotIndex) {

        int[] re = new int[2];

        int pivot = arr[pivotIndex];

        while (begin < end) {
            while (begin < end && arr[begin] < pivot) {
                begin++;
            }
            while (begin < end && arr[end] > pivot) {
                end--;
            }
            //两头交换 <=
            if (begin < end) {
                Sorts.swap(arr, begin, end);

                //同时移动
                begin++;
                end--;
            } else if (begin == end) {
                begin++;
            }
        }

        re[0] = begin;
        re[1] = end;

        return re;

    }

    @Test
    public void test3() {
        int[] arr = {99, 3, 2, 3, 88, 1, 4, 5, 1, 0};
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    public void quickSort3(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

//        int pivotIndex = ((end - begin) >> 1) + begin;
        int pivotIndex = begin;
        int p = partition3(nums, begin, end, pivotIndex);

        quickSort3(nums, begin, p - 1);
        quickSort3(nums, p + 1, end);
    }

    /**
     * 3. 顺序遍历（效率最高）
     *
     * @param arr
     * @param begin
     * @param end
     * @param pivotIndex
     * @return
     */
    public int partition3(int[] arr, int begin, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        int storeIndex = begin;

        //把pivot暂存到最后一位
        Sorts.swap(arr, pivotIndex, end);

        //不包括最后一位
        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                Sorts.swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        //此时末尾存的还是pivot，将其与storeIndex交换 还原
        Sorts.swap(arr, storeIndex, end);

        return storeIndex;
    }
}
