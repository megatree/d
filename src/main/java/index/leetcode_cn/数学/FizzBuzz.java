package index.leetcode_cn.数学;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mythss on 2018-05-17.
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/60/
 */
public class FizzBuzz {

    @Test
    public void go() {


    }

    /**
     * 3ms
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        if (n < 1) {
            return result;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;

    }

}
