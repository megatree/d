package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mythss on 2018-10-25.
 * <p>
 * https://segmentfault.com/a/1190000004410119
 */
public class 快速排序研究2 {

    @Test
    public void test() {
        int[] arr = {99, 3, 2, 3, 88, 1, 4, 5, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    void quickSort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition3(a, start, end);
        quickSort(a, start, mid - 1);
        quickSort(a, mid + 1, end);
    }

    /**
     * 挖坑填坑法
     * 选取第一个元素为pivot，则头元素为坑，从后向前遍历填坑，遇到比pivot小的元素填进去，此时end为坑。
     * 然后从前向后遍历，直到遇到比pivot 大的元素，填进坑
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    int partition(int a[], int start, int end) {
        int p = a[start];
        while (start < end) {
            while (start < end && a[end] >= p) end--;
            a[start] = a[end];
            while (start < end && a[start] < p) start++;
            a[end] = a[start];
        }
        a[start] = p;
        return start;
    }

    /**
     * 交换法
     * 以第一个元素为pivot，从第二个元素开始遍历
     * start指针找到第一个比pivot大的，end指针找到第一个比pivot小的
     * 交换
     * 继续，直到end=start-1
     * 交换首元素和end，返回end下标
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    int partition2(int a[], int start, int end) {
        int p = a[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            while (l <= r && a[l] < p) {
                l++;
            }
            while (l <= r && a[r] >= p) {
                r--;
            }
            if (l < r) {
                swap(a, l, r);
            }
        }
        //这里刚好start=end+1
        //因为r指向的数比 pivot 小，所以是它和pivot交换
        swap(a, start, r);
        return r;
    }

    /**
     * 顺序遍历法
     * 维护start storeIndex 指向开始
     * pivot 指向最后
     * start向后移动，当遇到比pivot小的元素，就将其与storeIndex交换，然后storeIndex+1
     * 直到start到达pivot
     * 交换storeIndex和pivot位置，返回storeIndex
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    int partition3(int a[], int start, int end) {
        int pivot = a[end];
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                swap(a, i, storeIndex);
                storeIndex++;
            }
        }
        swap(a, storeIndex, end);
        return storeIndex;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
