package index.basicAlgo;

import java.util.Arrays;

/**
 * 找一个基准值，使它左面的元素都小于它
 * 然后再递归左右数组
 * <p>
 * Created by wangzhe.bj on 2017/8/3.
 */
public class QuickSort {

    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 3, 77, 54, 38, 98};
        QuickSort quickSort = new QuickSort(arr);
        quickSort.sort();
        quickSort.print();
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public void sort() {
        quickSort2(array, 0, array.length - 1);
    }

    public static void quickSort2(int[] src, int begin, int end) {
        if (src == null) {
            throw new RuntimeException("非法参数");
        }

        if (begin == end) {
            //结束出口
            return;
        }

        if (begin < end) {
            int index = Sorts.partition2(src, begin, end);

            quickSort2(src, begin, index - 1);

            quickSort2(src, index + 1, end);
        }


    }

    private static void quickSort(int[] src, int begin, int end) {
        if (begin < end) {

            int key = src[begin];
            int i = begin;
            int j = end;

            while (i < j) {
                // 先从右向左移动，满足条件元素大于基准值
                while (i < j && src[j] > key) {
                    j--;
                }

                //跳出循环时，元素不大于基准值，j位置元素移动到i上
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }

                while (i < j && src[i] < key) {
                    i++;
                }

                if (i < j) {
                    src[j] = src[i];
                    j--;
                }


            }

            // i==j
            src[j] = key;

            quickSort(src, begin, i - 1);

            quickSort(src, i + 1, end);
        }
    }
}
