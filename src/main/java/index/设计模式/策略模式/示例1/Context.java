package index.设计模式.策略模式.示例1;

/**
 * Created by wangzhe.bj on 2018-12-05.
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate(){
        strategy.operate();
    }
}
