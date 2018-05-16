package index.leetcode_cn.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangzhe.bj on 2018-05-16.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
 */
public class 二叉树的层次遍历 {

    List<List<Integer>> result = new ArrayList<>();

    @Test
    public void go() {
        List<List<Integer>> result = new LinkedList<>();
        System.out.println(result.get(0));
    }

    /**
     * 非递归
     * 空结点不计入
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        List<Integer> tempList = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //下一层数量
        int nextLevelCount = 0;
        //本层剩余数量
        int curLevelLeftCount = 1;
        while (queue.size() > 0) {
            TreeNode tmp = queue.poll();

            if (tmp != null) {
                //本层List +1
                tempList.add(tmp.val);

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    nextLevelCount++;
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    nextLevelCount++;
                }

                //消费本层一个元素，本层剩余元素-1
                curLevelLeftCount--;
            }

            //本层遍历完毕，重置计数
            if (curLevelLeftCount == 0) {
                curLevelLeftCount = nextLevelCount;
                nextLevelCount = 0;
                result.add(tempList);
                tempList = new LinkedList<>();
            }

        }

        return result;
    }

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        levelOrder(root, 0);
        return result;
    }

    /**
     * 先序遍历，等于从左向右。
     * 恰好由于要分层给出层次遍历结果，因此每个元素可以放到对应level的List里面
     *
     * @param root
     * @param level
     */
    public void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> tempList = null;
        if (result.size() > level) {
            tempList = result.get(level);
        }
        if (tempList == null) {
            tempList = new ArrayList<>();
            result.add(level, tempList);
        }
        tempList.add(root.val);


        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
