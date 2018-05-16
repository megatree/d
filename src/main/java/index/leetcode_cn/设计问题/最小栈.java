package index.leetcode_cn.设计问题;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-17.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
 */
public class 最小栈 {

    @Test
    public void go() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert -3 == minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        assert 0 == minStack.top();      //--> 返回 0.
        assert -2 == minStack.getMin();   //--> 返回 -2.

    }

    public static class MinStack {

        private int min;
        /** 第一次push改变状态，pop完所有元素改变状态 */
        private boolean minInited = false;
        private int[] table;

        private int p = -1;

        public MinStack() {
            table = new int[10];
        }

        public void push(int x) {
            ensureCapacity();
            p++;
            table[p] = x;

            if (!minInited) {
                min = x;
                minInited = true;
            } else {
                if (x < min) {
                    min = x;
                }
            }
        }

        public void pop() {
            //弹出去的正好是最小值，此时需要重新找最小值
            if (p > 0 && table[p] == min) {
                min = table[0];
                for (int i = 0; i <= p - 1; i++) {
                    if (table[i] < min) {
                        min = table[i];
                    }
                }
            }

            p--;
            if (p < 0) {
                p = -1;
                min = 0;
                minInited = false;
                //至此，最小值需要重新初始化
            }
        }

        public int top() {
            return p < 0 ? 0 : table[p];
        }

        private void ensureCapacity() {
            if (p >= table.length - 1) {
                int[] newTable = new int[table.length * 2];
                System.arraycopy(table, 0, newTable, 0, table.length);
                this.table = newTable;
            }
        }

        /**
         * 常数时间
         *
         * @return
         */
        public int getMin() {
            return min;
        }
    }


}
