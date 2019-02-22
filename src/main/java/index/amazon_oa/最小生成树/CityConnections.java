package index.amazon_oa.最小生成树;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangzhe.bj on 2019-02-22.
 */
public class CityConnections {

    int unionNum = 0;

    @Test
    public void test() {
        ArrayList<Connection> connections = new ArrayList<>();
        //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",2));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",16));
        //这里就输出一下看看结果。
        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
        }
    }

    public ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        ArrayList<Connection> result = new ArrayList<>();
        //先对入参判空
        if (connections == null || connections.isEmpty()) {
            return result;
        }
        //对入参排序
        Collections.sort(connections, Comparator.comparingInt(o -> o.cost));

        //用来记录node 及对应 版本号
        Map<String, Integer> map = new HashMap<>();

        for (Connection connection : connections) {
            String a = connection.node1;
            String b = connection.node2;

            //判断要不要这条边
            //判断依据就是 kruskal
            if (union(map, a, b)) {
                result.add(connection);
            }
        }

        //检查是不是所有城市都在一个union
        String find = connections.get(0).node1;
        int num = map.get(find);
        for (String s : map.keySet()) {
            if (map.get(s) != num) {
                //s 与第一个node不在一个union
                //按照题目要求，返回空
                return new ArrayList<>();
            }
        }

        //对结果进行排序
        Collections.sort(result, (o1, o2) -> {
            if (o1.node1.equals(o2.node1)) {
                return o1.node2.compareTo(o2.node2);
            }
            return o1.node1.compareTo(o2.node1);
        });

        return result;
    }

    private boolean union(Map<String, Integer> map, String a, String b) {
        //两个城市都没在已知集合里，put 进map
        if (!map.containsKey(a) && !map.containsKey(b)) {
            map.put(a, unionNum);
            map.put(b, unionNum);
            unionNum++;
            return true;
        }

        //如果两个城市一方落单，加入另一方
        if (!map.containsKey(a) && map.containsKey(b)) {
            int num = map.get(b);
            map.put(a, num);
            return true;
        }

        if (map.containsKey(a) && !map.containsKey(b)) {
            int num = map.get(a);
            map.put(b, num);
            return true;
        }

        //两方都在已知集合里，判断是不是一个集合，如果是，则不能再加进result，踢掉
        Integer num1 = map.get(a);
        Integer num2 = map.get(b);
        if (num1.equals(num2)) {
            return false;
        }

        //a b不在同一个集合，把b加进a
        for (String s : map.keySet()) {
            if (map.get(s) == num2) {
                map.put(s, num1);
            }
        }

        return true;
    }

    public static class Connection {
        String node1;
        String node2;
        int cost;

        public Connection(String node1, String node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }
}
