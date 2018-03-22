package index.basicAlgo;

import java.util.Arrays;

/**
 * Created by wangzhe.bj on 2017/7/25.
 */
public class SwapWithoutTempvar {
    public static void main(String[] args) {
        int[] a = {4,5};

        a[0] = a[0]^a[1];
        a[1] = a[1]^a[0];
        a[0] = a[0]^a[1];

        System.out.println(Arrays.toString(a));

        int i=1;
        int j =1;
        System.out.println(i++);
        System.out.println(++j);

    }
}
