package index.实践.构建高效可伸缩缓存.原版;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhe.bj on 2018-06-21.
 */
public class UserCostStatComputer {

    private final Map<String, BigInteger> cache = new HashMap<>();

    public synchronized BigInteger compute(String userId) throws InterruptedException {
        BigInteger result = cache.get(userId);
        if (result == null) {
            result = doCompute(userId);
            cache.put(userId, result);
        }
        return result;
    }

    private BigInteger doCompute(String userId) throws InterruptedException {
        // assume it cost a long time...
        TimeUnit.SECONDS.sleep(3);
        return new BigInteger(userId);
    }
}
