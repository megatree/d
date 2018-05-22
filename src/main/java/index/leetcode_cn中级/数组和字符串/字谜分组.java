package index.leetcode_cn中级.数组和字符串;

import index.common.CollectionUtils;
import org.junit.Test;

import java.util.*;

/**
 * Created by mythss on 2018-05-21.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
 */
public class 字谜分组 {

    @Test
    public void go() {
        String[] arrs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(arrs);
        CollectionUtils.print(list);
    }

    /**
     * 当基础数据结构不能满足要求时，考虑使用高级数据结构，HashMap
     * 不用过度考虑性能
     *
     * 27ms
     * 71%
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if (strs.length == 0) {
            return result;
        }

        List<String> tempList;
        if (strs.length < 2) {
            tempList = new LinkedList<>();
            tempList.add(strs[0]);
            result.add(tempList);
            return result;
        }

        Map<String, List<String>> unorderedListMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = order(strs[i]);
            List<String> list = unorderedListMap.get(str);
            if (list == null) {
                list = new LinkedList<>();
                result.add(list);
                unorderedListMap.put(str, list);
            }

            list.add(strs[i]);
        }

        return result;

    }

    public String order(String src) {
        char[] chars = src.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

}
