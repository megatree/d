package index.basicAlgo;

/**
 * Created by wangzhe.bj on 2017/10/12.
 */
public class FirstCharInStringSingle {

    public static void main1(String[] args) {
        String str = "a1a2d3dc3fs112332";

        int[] s = new int[256];
        //初始化数组
        for (int i = 0; i < s.length; i++) {
            s[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            s[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (s[str.charAt(i)] == 1) {
                System.out.print(str.charAt(i));
                break;
            }
        }
    }

    public static void main2(String[] args) {
        FirstCharInStringSingle inc = new FirstCharInStringSingle();
        int i = 0;
        inc.fermin(i);
        i = i++;
        System.out.println(i);

    }

    void fermin(int i) {
        i++;
    }
}
