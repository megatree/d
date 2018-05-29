package index.leetcode_cn中级.排序和搜索;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangzhe.bj on 2018-05-28.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
 * <p>
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 例如，
 * <p>
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * <p>
 * 注意：
 * <p>
 * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class TopKFrequentElements {

    @Test
    public void go() {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent(arr, 2));


    }

    /**
     * 51.9%
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            count++;
            if (count > k) {
                break;
            }
            result.add(entry.getKey());
        }

        return result;
    }
}


























