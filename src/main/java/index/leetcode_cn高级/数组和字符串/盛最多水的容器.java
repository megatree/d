package index.leetcode_cn高级.数组和字符串;

import org.junit.Test;

/**
 * Created by mythss on 2018-06-13.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/126/
 * <p>
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 注意：你不能倾斜容器，n 至少是2。
 */
public class 盛最多水的容器 {

    private int max = 0;

    @Test
    public void go() {
        int[] arr = {0, 1, 5, 3, 4, 6, 2, 0, 0, 7, 8, 6};
        System.out.println(maxArea(arr));
    }

    @Test
    public void go2() {
        int[] arr = {1, 1};
        System.out.println(maxArea(arr));

    }

    /**
     * 木桶理论
     *
     * @param height
     * @return
     */
    public int maxArea_(int[] height) {

        int minHeight = 0;
        int startIndex = 0;

        for (int i = 0; i < height.length; i++) {

            if (height[i] == 0) {
                //宽高设为0
                startIndex = -1;
                minHeight = 0;
                continue;
            }

            //当前元素不为0，宽度自增
            if (startIndex < 0) {
                startIndex = i;
            }

            if (minHeight > 0) {
                minHeight = Math.min(height[i], minHeight);
            } else {
                minHeight = height[i];
            }

            int content = (i - startIndex) * minHeight;
            max = Math.max(content, max);

        }

        return max;
    }

    /**
     * 每条线即为木桶的边，底部宽应为索引之差
     * 使用双向指针法，从两侧向中间遍历。较短的一条边进行移动
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {




    }
}
