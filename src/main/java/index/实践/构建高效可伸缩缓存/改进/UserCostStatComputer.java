package index.实践.构建高效可伸缩缓存.改进;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhe.bj on 2018-06-21.
 */
public class UserCostStatComputer implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws Exception {

        TimeUnit.SECONDS.sleep(3);
        return new BigInteger(arg);
    }
}
