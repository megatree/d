package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

/**
 * Created by wangzhe.bj on 2018-10-25.
 */
public class 二分法研究 {

    @Test
    public void test() {
        int[] arr = {0, 1, 2, 4, 5, 7, 8, 11};
        System.out.println(binarySearch(arr, 12));
    }

    /**
     * 寻找k在有序数组arr中的下标
     * 没有则返回-1
     *
     * @param arr
     * @param k
     * @return
     */
    public int binarySearch(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;

        if (len == 1) {
            return arr[0] == k ? 0 : -1;
        }

        if (k < arr[0] || k > arr[len - 1]) {
            return -1;
        }

        int l = 0;
        int r = len - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] > k) {
                r = mid - 1;
                continue;
            }

            if (arr[mid] < k) {
                l = mid + 1;
                continue;
            }
        }

        return -1;
    }

}
