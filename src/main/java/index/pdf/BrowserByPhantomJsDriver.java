package index.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Create by user on 2018-09-17
 */
public class BrowserByPhantomJsDriver {

    private static PhantomJSDriver webDriver = null;//getWebDriver();

    private static PhantomJSDriver getWebDriver(){
        Properties pro = new Properties();
        try {
            pro.load(BrowserByPhantomJsDriver.class.getClassLoader().getResourceAsStream("com/fang/ebcenter/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持（第二参数表明的是你的phantomjs引擎所在的路径，which/whereis phantomjs可以查看）
        // fixme 这里写了执行， 可以考虑判断系统是否有安装，并获取对应的路径 or 开放出来指定路径
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, pro.getProperty("phantomjs.path"));
        //创建无界面浏览器对象
        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver;
    }
    /*
    加载网页
     */
    public static void LoadUrl(String url){
        webDriver.get(url);
    }
    /*
    设置截屏窗口
     */
    public static void ResetWindowSize(Dimension size){
        webDriver.manage().window().setSize(size);
    }
    /*
    运行JS
     */
    public static Object executeScript(String script){
        return webDriver.executeScript(script);
    }
    /*
    运行phantomjs
     */
    public static void executePhantomJS(String script){
        webDriver.executePhantomJS(script);
    }
    /*
    返回图片
     */
    public static BufferedImage renderHtml2Image() throws IOException {
        File file = webDriver.getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(file);
        if(file.exists()){
            file.delete();
        }
        return img;
    }
    /*
    返回图片
     */
    public static BufferedImage renderHtml2Image(String url, Dimension size, String script) throws IOException {
        LoadUrl(url);
        ResetWindowSize(size);
        if(script != null && script != ""){
            executeScript(script);
        }
        File file = webDriver.getScreenshotAs(OutputType.FILE);
        return ImageIO.read(file);
    }
    /*
    返回图片
     */
    public static Image renderHtml2Image(String imgType) throws BadElementException,IOException {
        BufferedImage img = renderHtml2Image();
        byte[] bytes = Base64Util.encodeToByte(img,imgType);
        return Image.getInstance(bytes);
    }
    /*
    返回图片
     */
    public static Image renderHtml2Image(String url, Dimension size, String imgType, String script) throws BadElementException,IOException {
        BufferedImage img = renderHtml2Image(url,size,script);
        byte[] bytes = Base64Util.encodeToByte(img,imgType);
        return Image.getInstance(bytes);
    }
    /*
    退出
     */
    public static void quit(){
        webDriver.quit();
    }
    /*
    关闭
     */
    public static void close(){
        webDriver.close();
    }
}
