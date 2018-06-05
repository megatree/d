package index.leetcode_cn中级.数学;

import org.junit.Test;

/**
 * Created by mythss on 2018-06-04.
 *
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/116/
 *
 */
public class x的平方根 {

    @Test
    public void go(){
        System.out.println(Math.abs(9.56123123124/2));


    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // write your code here
        if (x < 0)
        {
            return 0;
        }
        double err = 1e-15;
        double t = x;
        while (Math.abs(t - x/t) > err * t) {
            t = (x / t + t) / 2.0;
        }
        return (int)t;
    }


}
