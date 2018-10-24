package index.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by mythss on 2018-07-26.
 */
public class JwtTest {


    @Test
    public void t2() {
        System.out.println(String.format("%04d", 12213));

        ExecutorService es = Executors.newCachedThreadPool();
        es.shutdownNow();
    }

    @Test
    public void test() {
        String key = "123123123123";
        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        System.out.println(compactJws);

        String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject();
        System.out.println(subject);
    }

    @Test
    public void test2() {
        String key = "123123123123";
        String fake = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGdWNrIiwiaWF0IjoxNTMyNjE5ODkxfQ.KlT7kczjvBR22KTLIqUY0Y4pMfebFlZsf0A_WLpeKUAX600XXKzB9vZNXMvM4haadWzVXIUxvVLJ9eCYN2NPvA";
        try {
            String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(fake).getBody().getSubject();
            System.out.println(subject);
        } catch (SignatureException ex) {
            System.err.println("验证未通过");
        }
    }

    @Test
    public void test3() throws IOException {
        String url = "http://10.16.134.134:8308/agentstat/findserviceoperatereport?deptid=323283&startday=2018-09-10&endday=2018-10-10&purpose=0";
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).build();
        Request request =new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        String bodyStr = response.body().string();
        System.out.println(bodyStr);

    }
}
