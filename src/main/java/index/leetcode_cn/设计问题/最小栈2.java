package index.leetcode_cn.设计问题;

import org.junit.Test;

import java.util.Stack;

public class 最小栈2 {


    @Test
    public void go() {

    }


    public static class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> helper = new Stack<>();


        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            helper.push(helper.size()==0?x:Math.min(x,helper.peek()));
        }

        public void pop() {
            stack.pop();
            helper.pop();
        }

        public int top() {
            return stack.peek();
        }


        /**
         * 常数时间
         *
         * @return
         */
        public int getMin() {
            return helper.peek();
        }
    }
}