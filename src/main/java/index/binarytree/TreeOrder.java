package index.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangzhe.bj on 2017/10/31.
 */
public class TreeOrder {

    public static void main(String[] args) {
        TreeOrder order = new TreeOrder();

        TreeNode head = order.createTree();
        order.preOrder(head);
        System.out.println();

        order.nonRecPreOrder(head);
        System.out.println();

        order.levelTraversal(head);

    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + ",");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void nonRecPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = node;
        while (t != null || stack.size() > 0) {
            //t不为null 和 stack 大于0 为两个独立操作
            while (t != null) {
                System.out.print(t.getValue() + ",");
                stack.push(t);
                t = t.getLeft();
            }

            //触底，向上一位遍历右节点
            if (stack.size() > 0) {
                t = stack.pop();
                t = t.getRight();
            }
        }
    }

    public void levelTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        //入队
        queue.offer(node);
        while (queue.size() > 0) {
            //弹出队首
            TreeNode t = queue.remove();
            if (t != null) {
                System.out.print(t.getValue() + ",");
                queue.offer(t.getLeft());
                queue.offer(t.getRight());
            }
        }

    }

    /**
     * 16
     * /  \
     * 15  24
     * /  \
     * 7   14
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode t31 = new TreeNode(7);
        TreeNode t32 = new TreeNode(14);

        TreeNode t21 = new TreeNode(t31, t32, 15);
        TreeNode t22 = new TreeNode(24);

        TreeNode t1 = new TreeNode(t21, t22, 16);
        return t1;
    }
}
