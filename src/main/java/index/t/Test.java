package index.t;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("2"));
        list.add(new User("3"));
//        list.add(new User("3"));
//        list.add(new User("4"));
//        list.add(new User("5"));

        List<User> finalList = new ArrayList<>();
        finalList.addAll(list);
        System.out.println(Arrays.toString(finalList.toArray()));

        String a = "adsfzxcvbnm,123";

        Constructor cons;

    }




    public static class User {
        private static User user = new User("1");

        public String name;

        public User(String name) {
            this.name = name;
            System.out.println(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
