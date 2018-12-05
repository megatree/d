package index.设计模式.策略模式.示例1;

/**
 * Created by wangzhe.bj on 2018-12-05.
 */
public class BackDoor implements IStrategy {

    @Override
    public void operate() {
        System.out.println("开后门");
    }
}
