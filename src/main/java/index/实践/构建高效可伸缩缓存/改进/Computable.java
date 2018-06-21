package index.实践.构建高效可伸缩缓存.改进;

/**
 * Created by wangzhe.bj on 2018-06-21.
 */
public interface Computable<A, V> {

    V compute(A arg) throws Exception;

}
