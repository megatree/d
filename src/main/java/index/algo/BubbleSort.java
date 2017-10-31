package index.algo;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/9/20.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 3, 9, 2, 4, 6, 8, 10, 12, 11, 14, 15, 13};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (array[j] < array[j - 1]) {
                    int t = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = t;
                }
            }

        }
        return array;
    }
}
