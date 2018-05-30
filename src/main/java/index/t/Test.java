package index.t;

import com.alibaba.fastjson.JSON;
import index.util.ClassIntrospector;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by wangzhe.bj on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException {
        String cookies = "sfut=4E5D86A98EBBAB9C9BD962A0D3D240CDB114B06D9BEA5DE3739936A00AD918908C61102876F7976EBD0AC" +
                "AC26A1FF6D425D62CABEF0404CCB09037576FF01D94841D26C30B7D0708CE0CFB9862C9139B79ACF6B35D641C359FC83B8647D4EAD4; " +
                "sfyt=GOqzturlueaBIiY3upXJiDIu69hnCLlHc-IK5rY1FHejfq8ACXIJZSmxZa9fmSxD8xlxHEOlpSiHxTzYoiV0mw==;";
        String url = "http://ebcenter.light.fang.com/ebcenter.new/zxb/im.do?dateBegin=20180520&dateEnd=20180523";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Cookie", cookies)
                .url(url)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("网络错误");
            }
            String s = response.body().string();

            System.out.println(response.networkResponse().request().headers().toMultimap().toString());
            System.out.println();
            System.out.println(s);

        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }

    }

    public enum E {
        ABC("def"),
        GHI("k");

        E(String def) {
        }
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
