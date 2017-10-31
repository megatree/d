package index.algo;

/**
 * Created by wangzhe.bj on 2017/8/3.
 */
public class SelectSort {

    private int[] array;

    public SelectSort(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {

    }

    public void sort() {
        int length = array.length;

        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            int temp = array[i];

            for (int j = i + 1; j < length; j++) {
                if (array[j] < temp) {
                    minIndex = j;
                }
            }

            int t = array[minIndex];
            array[minIndex] = temp;
            array[i] = t;

        }
    }

}
