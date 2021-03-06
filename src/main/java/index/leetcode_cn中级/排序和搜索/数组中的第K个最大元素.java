package index.leetcode_cn中级.排序和搜索;

import index.basicAlgo.Sorts;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2018-05-29.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
 */
public class 数组中的第K个最大元素 {

    @Test
    public void go() {
        int[] arr = {3, 2, 3, 1, 4, 5};
        assert findKthLargest(arr, 1) == 5;
        assert findKthLargest(arr, 3) == 3;
        assert findKthLargest(arr, 4) == 3;
        assert findKthLargest(arr, 5) == 2;

    }

    public int findKthLargest_1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 要求第k大，考虑用partition方法
     * 4ms On的partition方法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    public int find(int[] arr, int start, int end, int i) {
//        int p = Sorts.partition(arr, start, end, i);
        int p = partition(arr, start, end, i);

        if (p > i) {
            return find(arr, start, p - 1, i);
        } else if (p < i) {
            return find(arr, p + 1, end, i);
        }
        return arr[p];
    }

    /**
     * 用while实现
     *
     * @param arr
     * @param begin
     * @param end
     * @param pivotIndex
     * @return
     */
    public int partition(int[] arr, int begin, int end, int pivotIndex) {
        pivotIndex = begin;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);

        int low = begin;
        int high = end;

        while (low < high) {
            while (low < high && arr[low] < pivot) low++;
            while (low < high && arr[high] > pivot) high--;
            if (low < high) {
                swap(arr, low, high);
            }
        }

        swap(arr, low, end);
        return low;
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
