package index.leetcode_cn.字符串;

import org.junit.Test;

/**
 * Created by mythss on 2018-05-14.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 另一种思路：
 * 取第一个元素，作为默认前缀
 * 依次遍历后续数组中每一个元素
 * 对每一个元素indexOf，返回若不为0，则去掉前缀最后一个字符
 * 如此直到默认前缀变空，或者数组所有元素indexOf 均为0
 */
public class 最长公共前缀 {

    @Test
    public void go() {

        assert longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl");
        assert longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals("");

    }

    /**
     * 11ms
     * 50%
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }


        int index = 0;
        boolean interrupt = false;
        StringBuilder sb = new StringBuilder();
        //上一个首元素字符
        char firstEleChar = 0;

        while (true) {
            for (int i = 0; i < strs.length; i++) {
                //超出最短元素长度，终止
                if (strs[i].length() == index) {
                    interrupt = true;
                    break;
                }

                if (i == 0) {
                    firstEleChar = strs[0].charAt(index);
                    continue;
                }

                //首元素外，其他元素index位置字符 与首元素不同，终止
                if (strs[i].charAt(index) != firstEleChar) {
                    interrupt = true;
                    break;
                }

            }

            if (interrupt) {
                break;
            }

            //至此，index位置字符在 strs所有元素中均存在
            sb.append(firstEleChar);

            index++;
        }

        return sb.toString();
    }
}
