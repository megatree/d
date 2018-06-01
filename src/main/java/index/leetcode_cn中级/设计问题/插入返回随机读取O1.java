package index.leetcode_cn中级.设计问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by wangzhe.bj on 2018-06-01.
 */
public class 插入返回随机读取O1 {

    @Test
    public void go() {
        int val = 0;
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();
    }

    class RandomizedSet {

        int listIndex = -1;
        private HashMap<Integer, Integer> intIndexMap = new HashMap<>();
        private List<Integer>             list        = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         * 若不在集合中，插入并返回true
         * 若在，返回false
         */
        public boolean insert(int val) {
            if (intIndexMap.containsKey(val)) {
                return false;
            }

            listIndex++;
            list.add(listIndex, val);
            intIndexMap.put(val, listIndex);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!intIndexMap.containsKey(val)) {
                return false;
            }
            int index2Del = intIndexMap.get(val);
            int valTail = list.get(listIndex);

            //末尾元素设置到要删除位置，同时更新其在map中索引
            list.set(index2Del, valTail);
            intIndexMap.put(valTail, index2Del);

            //map中删除此元素
            intIndexMap.remove(val);

//            list.remove(listIndex);
            listIndex--;

            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            int r = random.nextInt(listIndex + 1);
            return list.get(r);
        }
    }
}
