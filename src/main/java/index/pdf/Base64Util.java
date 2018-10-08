package index.pdf;

import com.itextpdf.text.pdf.codec.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Create by user on 2018-09-17
 */
public class Base64Util {
    public static String encode(BufferedImage bufferedImage, String imgType) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imgType, outputStream);
        return encode(outputStream);
    }

    public static String encode(ByteArrayOutputStream outputStream) {
        return Base64.encodeBytes(outputStream.toByteArray());
    }

    public static byte[] encodeToByte(BufferedImage bufferedImage, String imgType) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imgType, outputStream);
        return outputStream.toByteArray();
    }
}
