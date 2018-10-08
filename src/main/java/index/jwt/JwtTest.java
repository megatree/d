package index.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mythss on 2018-07-26.
 */
public class JwtTest {


    @Test
    public void t2(){
        System.out.println(String.format("%04d",12213));

        ExecutorService es = Executors.newCachedThreadPool();
        es.shutdownNow();
    }

    @Test
    public void test(){
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
    public void test2(){
        String key = "123123123123";
        String fake = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGdWNrIiwiaWF0IjoxNTMyNjE5ODkxfQ.KlT7kczjvBR22KTLIqUY0Y4pMfebFlZsf0A_WLpeKUAX600XXKzB9vZNXMvM4haadWzVXIUxvVLJ9eCYN2NPvA";
        try {
            String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(fake).getBody().getSubject();
            System.out.println(subject);
        }catch (SignatureException ex){
            System.err.println("验证未通过");
        }
    }
}
