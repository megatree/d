package index.questions;

import index.binarytree.TreeNode;
import index.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2017/11/5.
 */
public class 分行从上到下打印二叉树 {

    public static void main(String[] args) {

        TreeNode head = TreeUtils.createTree();
        levelTraverse(head);

    }

    public static void levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int tobePrint = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            tobePrint--;
            if (t != null) {
                System.out.print(t.getValue() + ",");
                if (t.getLeft() != null) {
                    queue.offer(t.getLeft());
                    nextLevel++;
                }
                if (t.getRight() != null) {
                    queue.offer(t.getRight());
                    nextLevel++;
                }
            }

            if (tobePrint == 0) {
                System.out.println();
                tobePrint = nextLevel;
                nextLevel = 0;
            }

        }


    }


}
