package index.实践.构建高效可伸缩缓存.改进;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by wangzhe.bj on 2018-06-21.
 */
public class UserCostFacade<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V>  c;

    public UserCostFacade(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {

        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                //此时缓存为空，还没有其他查询请求过来

                //建立一个Callable，查询arg
                Callable<V> callable = () -> c.compute(arg);

                FutureTask<V> futureTask = new FutureTask<>(callable);

                f = cache.putIfAbsent(arg, futureTask);

                if (f == null) {
                    //在此期间仍没有别人查询此任务
                    f = futureTask;
                    futureTask.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                //取消任务时remove，进入下一个循环
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                e.printStackTrace();
                throw e;
            }

        }
    }
}
