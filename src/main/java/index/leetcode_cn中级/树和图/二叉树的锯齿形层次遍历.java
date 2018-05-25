package index.leetcode_cn中级.树和图;

import index.leetcode_cn.树.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mythss on 2018-05-25.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/86/
 */
public class 二叉树的锯齿形层次遍历 {

    /**
     * 非递归层次遍历，将要到下一层时，反转队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        //存放每层遍历结果
        List<Integer> tempList = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        //把自己放入队列
        queue.offer(root);

        //用两个计数变量，控制每层的终点
        int nextLevelCount = 0;
        int curLevelLeft = 1;
        boolean isLeft = true;

        while (queue.size() > 0) {
            //从队列中取出
            TreeNode tmp;

            //如果本层要从左向右遍历，
            //从双端队列队首加入元素，队尾取出元素
            if (isLeft) {
                tmp = queue.pollFirst();

                if (tmp != null) {
                    tempList.add(tmp.val);

                    if (tmp.left != null) {
                        queue.offerLast(tmp.left);
                        nextLevelCount++;
                    }

                    if (tmp.right != null) {
                        queue.offerLast(tmp.right);
                        nextLevelCount++;
                    }

                    //本层消费一个
                    curLevelLeft--;
                }

            } else {
                //从右向左，需要从队尾取出元素，
                //队首加入元素，同时加入顺序反转
                tmp = queue.pollLast();

                if (tmp != null) {
                    tempList.add(tmp.val);

                    if (tmp.right != null) {
                        queue.offerFirst(tmp.right);
                        nextLevelCount++;
                    }

                    if (tmp.left != null) {
                        queue.offerFirst(tmp.left);
                        nextLevelCount++;
                    }

                    curLevelLeft--;
                }

            }


            //本层所有的遍历完毕，
            //初始化下层参数
            if (curLevelLeft == 0) {
                curLevelLeft = nextLevelCount;
                nextLevelCount = 0;

                result.add(tempList);
                tempList = new LinkedList<>();

                isLeft = !isLeft;
            }

        }

        return result;
    }

}
