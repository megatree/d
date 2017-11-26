package index.questions;

import java.util.Stack;

/**
 *
 * Created by wangzhe.bj on 2017/11/26.
 */
public class 两个栈实现一个队列 {

    public static void main(String[] args) {
        Stack4Queue<String> queue = new Stack4Queue<>();
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.poll();
        queue.poll();
        queue.put("4");
        queue.put("5");
        queue.poll();
        queue.poll();
        queue.put("6");


    }

    /**
     * 1、stack1直接入栈
     * 2、stack2不为空，直接出栈。否则stack1全部押入stack2，再出栈
     * @param <E>
     */
    public static class Stack4Queue<E> {

        /**
         * stack1负责入队
         */
        private Stack<E> stack1;
        /**
         * stack2 负责出队
         */
        private Stack<E> stack2;

        public Stack4Queue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public boolean put(E item) {
            stack1.push(item);
            return true;
        }


        public <E> E poll() {
            if (stack1.empty() && stack2.empty()) {
                return null;
            }

            if (!stack2.empty()) {
                return (E) stack2.pop();

            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return (E) stack2.pop();
            }

        }

        public int size() {
            return stack1.size() + stack2.size();
        }

    }
}
