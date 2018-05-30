package index.basicAlgo;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/11/6.
 */
public class Sorts {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = partition2(arr, 2, 7);
        System.out.println(Arrays.toString(arr));
        System.out.println(k);


    }

    public static int partition(int[] arr, int start, int end, int pivotIndex) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    public static int partition2(int[] arr, int start, int end) {
        if (arr == null) {
            throw new RuntimeException("数组不能为空");
        }

        int i = start;
        int j = end;
        int key = arr[i];

        while (i < j) {
            while (i < j && arr[j] > key) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < key) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        arr[i] = key;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
