package index.leetcode_cn中级.树和图;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2018-05-26.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/88/
 */
public class 每个节点的右向指针 {

    @Test
    public void go() {

    }

    /**
     * 等于是层次遍历此二叉树
     * 这里使用非递归解法
     *
     * @param root
     */
    public void connect_1(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);

        int curLevelLeft = 1;
        int nextLevelCount = 0;
        //本层中前一个node
        TreeLinkNode preNode = null;

        while (queue.size() > 0) {

            TreeLinkNode temp = queue.poll();

            //判空
            if (temp == null) {
                continue;
            }

            if (temp.left != null) {
                queue.offer(temp.left);
                nextLevelCount++;
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                nextLevelCount++;
            }

            //本层中preNode 指向当前节点
            if (preNode != null) {
                preNode.next = temp;
            }
            preNode = temp;


//            temp.val
            curLevelLeft--;

            //如果本层已经扫完，赋值下一层
            if (curLevelLeft == 0) {
                curLevelLeft = nextLevelCount;
                nextLevelCount = 0;

                preNode = null;
            }


        }

    }

    /**
     * 递归解法
     * 题目前提为，完全二叉树
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            //左右节点连接
            root.left.next = root.right;

            //root next 同级树，左右连接
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

    }
}
