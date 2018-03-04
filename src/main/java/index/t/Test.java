package index.t;

import index.util.ClassIntrospector;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {


    }


    static public class User {
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
