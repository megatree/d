package index.综合题系列1;

import index.basicAlgo.QuickSort;

/**
 * Created by wangzhe.bj on 2017/12/5.
 */
public class 数组中找出所有重复数字 {

    public static void main(String[] args) {

        int[] arr = {5, 4, 5, 7, 5, 6, 1, 2, 3};
        getRepeatedNumber(arr);

    }

    public static void getRepeatedNumber(int[] arr) {
        if (arr == null) {
            return;
        }


        //先排序
        QuickSort.quickSort2(arr, 0, arr.length - 1);

        //再查找
        int t = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i >= 1) {
                if (arr[i] == t) {
                    System.out.print(arr[i] + ",");
                }
            }

            t = arr[i];
        }

    }
}
