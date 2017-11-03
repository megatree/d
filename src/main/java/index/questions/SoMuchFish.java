package index.questions;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e3dd485dd23a42899228305658457927
 * 来源：牛客网
 * <p>
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 * 输入描述:
 * <p>
 * 输入数据包括3行. 第一行为新放入鱼的尺寸范围minSize,maxSize(1 ≤ minSize,maxSize ≤ 1000)，以空格分隔。
 * 第二行为鱼缸里面已经有鱼的数量n(1 ≤ n ≤ 50)
 * 第三行为已经有的鱼的大小fishSize[i](1 ≤ fishSize[i] ≤ 1000)，以空格分隔。
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出有多少种大小的鱼可以放入这个鱼缸。考虑鱼的大小都是整数表示
 * <p>
 * <p>
 * Created by wangzhe.bj on 2017/11/3.
 */
public class SoMuchFish {

    public static void main(String[] args) {
        int minSize = 1, maxSize = 100;
        int n = 5;
        //已有鱼的大小
        int[] fishSizes = {0, 1,3,6,8,44};
        //下标代表新放入鱼的尺寸，值1标记为不允许
        int[] newFishSizes = new int[1001];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int fishSize = fishSizes[i];
            for (int j = 2 * fishSize; j <= maxSize && j <= 10 * fishSize; j++) {
                newFishSizes[j] = 1;
            }
            for (int j = fishSize / 2; j >= minSize && j >= Math.ceil(fishSize / 10.0); j--) {
                newFishSizes[j] = 1;
            }
        }

        System.out.println("种类如下");
        for (int i = minSize; i <= maxSize; i++) {
            if (newFishSizes[i] == 0) {
                count++;
                System.out.print(i+",");
            }
        }
        System.out.println();
        System.out.println("可放入鱼的种类数量为");
        System.out.println(count);



    }
}
