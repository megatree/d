package index.综合题系列1;

/**
 * Created by wangzhe.bj on 2017/12/5.
 */
public class 零到100之间整数排序 {

    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 2, 3, 6, 5, 4, 7, 9, 8, 11};
        sort(arr);

    }

    /**
     * 桶排序
     * @param arr
     */
    public static void sort(int[] arr) {
        int[] bucket = new int[101];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                for (int j = 0; j < bucket[i]; j++) {
                    System.out.print(i + ",");
                }

            }
        }
    }
}
