package index.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Create by user on 2018-09-26
 */
public class ImageCut {
    /**
     * 把页脚下移
     * @param source
     * @return
     */
    public static Image MoveTopNpxToFoot(BufferedImage source) throws IOException, BadElementException {
        return MoveTopNpxToFoot(source,80,"png");
    }

    /**
     * 页脚下移并返回Image
     * @param source
     * @param px
     * @return
     */
    public static Image MoveTopNpxToFoot(BufferedImage source, int px, String imgType) throws IOException, BadElementException {
        BufferedImage image = new BufferedImage(source.getWidth(),source.getHeight(),source.getType());
        image.createGraphics().drawImage(source,null,0,-px);
        image.createGraphics().drawImage(source,null,0,source.getHeight()-px);
        byte[] bytes = Base64Util.encodeToByte(image,imgType);
        return Image.getInstance(bytes);
    }
}
