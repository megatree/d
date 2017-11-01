package index.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangzhe.bj on 2017/10/31.
 */
public class TreeOrder {
    private int index = -1;

    /**
     * ____16
     * ___/  \
     * __15  24
     * _/  \
     * 7   14
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeOrder order = new TreeOrder();

        TreeNode head = order.createTree();
        System.out.println("递归先序");
        order.preOrder(head);
        System.out.println("\n非递归先序");
        order.nonRecPreOrder(head);
        System.out.println("\n层次遍历");
        order.levelTraversal(head);
        System.out.println("\n递归中序");
        order.inOrder(head);
        System.out.println("\n非递归中序");
        order.noRecInOrder(head);
        System.out.println("\n序列化");
        String serial = order.serialize(head);
        System.out.println(serial);
        System.out.println("\n反序列化");
        TreeNode root = order.deserialize(serial);
        order.preOrder(root);

    }

    /**
     * 序列化
     *
     * @param node
     * @return
     */
    public String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(node.getValue() + ",");
        sb.append(serialize(node.getLeft()));
        sb.append(serialize(node.getRight()));
        return sb.toString();

    }

    /**
     * 反序列化
     */
    public TreeNode deserialize(String str) {
        index++;
        String[] arr = str.split(",");
        TreeNode node = null;
        if (!"#".equals(arr[index])) {
            node = new TreeNode(Integer.valueOf(arr[index]));
            node.setLeft(deserialize(str));
            node.setRight(deserialize(str));
        }

        return node;
    }

    /**
     * 递归中序遍历二叉树
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + ",");
            inOrder(node.getRight());
        }
    }

    public void noRecInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = node;
        while (t != null || stack.size() > 0) {
            //t不为null 和 stack 大于0 为两个独立操作
            while (t != null) {
                stack.push(t);
                t = t.getLeft();
            }
            //说明t.left 为null，即t为叶子节点
            //进入下面代码块，将叶子结点弹出，再打印

            //触底，向上一位遍历右节点
            if (stack.size() > 0) {
                t = stack.pop();
                System.out.print(t.getValue() + ",");
                t = t.getRight();
            }
        }

    }

    /**
     * 递归先序
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + ",");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 非递归先序
     *
     * @param node
     */
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

    /**
     * 层次遍历
     *
     * @param node
     */
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
     * ____16
     * ___/  \
     * __15  24
     * _/  \
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
