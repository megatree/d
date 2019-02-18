package index.amazon_oa;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangzhe.bj on 2019-02-18.
 */
public class HeapTest {

    private int[] arr = {1,2,3,4,5,6,7,8,9};

    @Test
    public void maxHeap() {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //2 - 1是大顶堆，默认是小顶堆
                return o2-o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        System.out.println(Arrays.toString(maxHeap.toArray()));

    }
}
