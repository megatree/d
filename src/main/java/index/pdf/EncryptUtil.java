package index.pdf;

import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by wangzhe.bj on 2018/2/24.
 */
public class EncryptUtil {

    /*
    返回加密串
     */
    public static String getSign(String key, String value, String params) throws Exception {
        String waitSign = params + "&" + key + "=" + value;
        String md5Sign = DigestUtils.md5Hex(waitSign);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String sign = aesEncrypt(md5Sign + "_" + format.format(new Date()), value);
        return sign;
    }
    /*
    AES加密
     */
    private static String aesEncrypt(String str, String key) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return new BASE64Encoder().encode(bytes);
    }
}
