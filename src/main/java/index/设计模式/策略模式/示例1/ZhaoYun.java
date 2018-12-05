package index.设计模式.策略模式.示例1;

/**
 * Created by wangzhe.bj on 2018-12-05.
 */
public class ZhaoYun  {

    public static void main(String[] args) {
        Context context = new Context(new BackDoor());
        context.operate();

        context = new Context(new GreenLight());
        context.operate();

        context = new Context(new BlockEnemy());
        context.operate();

    }
}

