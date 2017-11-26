package index.questions;

/**
 * Created by wangzhe.bj on 2017/11/26.
 */
public class 开平方根 {

    public static void main(String[] args) {

        System.out.println(sqrt(4.0));
    }

    public static double sqrt(double m) {
        double i = 0;
        int k = 0;
        while ((i * i) <= m)
            i += 0.1;
        for (int j = 0; j < 10; j++) {
            i = (m / i + i) / 2;
        }
        return i;
    }
}
