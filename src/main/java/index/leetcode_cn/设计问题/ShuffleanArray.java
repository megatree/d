package index.leetcode_cn.设计问题;

import org.junit.Test;

import java.util.Random;

/**
 * Created by mythss on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
 * <p>
 * <p>
 * 打乱一个没有重复元素的数组。
 */
public class ShuffleanArray {

    @Test
    public void go() {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }

    public static class Solution {

        private int[] origin;
        private Random r = new Random();

        public Solution(int[] nums) {
            this.origin = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return origin;
        }

        /**
         * Returns a random shuffling of the array.
         * 当前元素与随机位交换
         */
        public int[] shuffle() {
            int len = origin.length;
            if (len < 2) {
                return origin;
            }

            int[] result = new int[len];
            System.arraycopy(origin,0,result,0,len);
            for (int i = 0; i < len; i++) {
                int j = r.nextInt(len);
                if (i != j) {
                    int t = result[i];
                    result[i] = result[j];
                    result[j] = t;
                }

            }
            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
