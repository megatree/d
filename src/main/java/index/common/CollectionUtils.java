package index.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mythss on 2018-05-22.
 */
public class CollectionUtils {

    public static void print(List<List<String>> list) {
        list.forEach(l -> {
            System.out.println(Arrays.toString(l.toArray()));
        });
    }
}
