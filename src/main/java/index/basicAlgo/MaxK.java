package index.basicAlgo;

/**
 * Created by wangzhe.bj on 2017/9/20.
 */
public class MaxK {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 2, 4, 6, 8, 10, 12, 11, 14, 15, 13};
        find(array, 0, array.length - 1, 7);

    }


    public static void find(int[] array, int begin, int end, int k) {
        int i = partition(array, begin, end);

        if (i + 1 > k) {
            //左半部分,递归查找
            find(array, begin, i - 1, k);
        } else if (i + 1 < k) {
            //右半部分,递归查找
            find(array, i + 1, end, k);
        } else {
            System.out.println("找到了第" + k + "大的数为:" + array[i]);
            return;
        }
    }

    /**
     * 每轮快速排序
     *
     * @param array
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] array, int begin, int end) {
        if (begin < end) {
            //第一个数作为基准
            int key = array[begin];

            while (begin < end) {
                while (begin < end && array[end] < key) {
                    end--;
                }
                if (begin < end) {
                    array[begin] = array[end];
                    begin++;
                }
                while (begin < end && array[begin] > key) {
                    begin++;
                }
                if (begin < end) {
                    array[end] = array[begin];
                    end--;
                }

            }
            array[begin] = key;

        }
        return begin;
    }


}
