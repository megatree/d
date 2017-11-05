package index.questions;

/**
 * 递增数组旋转，首先确认数组成员是否可以重复
 * 12345 旋转成  34512
 * 01111 旋转成  11101 或者 10111
 * <p>
 * 二分法
 * <p>
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 旋转数组最小数字 {

    public static void main(String[] args) {

//        int[] array = {3, 4, 5, 1, 2};
//        int[] array = {3, 4, 4, 1, 2};
//        int[] array = {0, 1, 1, 1, 2};
        int[] array = {0, 1, 1, 1, 1};
        System.out.println(min(array));

    }

    public static int min(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("");
        }

        int head = 0;
        int tail = arr.length - 1;
        int mid = head;


        while (arr[head] >= arr[tail]) {
            mid = (head + tail) / 2;

            //这种情况首尾扫描
            if (arr[head] == arr[tail] && arr[head] == arr[mid]) {
                int m = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] < m) {
                        m = arr[i];
                    }
                }
                return m;
            }

            if (tail - head == 1) {
                return arr[tail];
            }

            if (arr[mid] >= arr[head]) {
                head = mid;
                continue;
            }

            if (arr[mid] <= arr[tail]) {
                tail = mid;
                continue;
            }


        }
        return arr[mid];
    }
}
