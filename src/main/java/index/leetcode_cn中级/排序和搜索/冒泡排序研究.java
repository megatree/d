package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-10-25.
 */
public class 冒泡排序研究 {

    @Test
    public void test() {
        int[] arr = {1, 4, 2, 7, 6, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 4, 5, 6, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 大数移到最后
     * 外层循环内缩
     * 共循环 n-1 轮
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int _count = 0;
        boolean isSorted = true;
        int len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            //末尾扫到倒数第二个
            for (int j = 0; j < i; j++) {
//                System.out.println(arr[j] + " " + arr[j + 1]);
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            _count++;

            if (isSorted){
                break;
            }
        }
        System.out.println("共循环轮数 " + _count);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
