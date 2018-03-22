package index.basicAlgo;

import java.util.Arrays;

/**
 * 将待排序元素在已排序数组中放置在合适位置
 *
 * Created by wangzhe.bj on 2017/8/3.
 */
public class InsertSort {

    private int[] array;

    public InsertSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 3, 77, 54, 38, 98};
        InsertSort insertSort = new InsertSort(arr);
        insertSort.sort2();
        insertSort.print();

    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public void sort() {
        if (array == null) {
            throw new RuntimeException();
        }

        int length = array.length;


        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i - 1;

            for (; j > 0&&array[j] >= temp  ; j--) {
                array[j + 1] = array[j];
            }

            array[j + 1] = temp;

        }

    }

    public void sort2() {
        if (array == null) {
            throw new RuntimeException();
        }

        int length = array.length;


        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i ;
            //从元素1开始

            //从元素i的前一个元素开始，与temp比较大小，并使前一个元素放到i位置
            //直到找到第一个比temp小的元素，
            for (; j > 0&&array[j-1] <= temp; j--) {
                array[j] = array[j-1];
            }

            //将暂存的元素i放到这里
            array[j] = temp;

        }


    }

}
