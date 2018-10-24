package index.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Create by user on 2018-09-26
 */

public class BrowserByPhantomJsDriverNoStatic {

    private PhantomJSDriver webDriver = null;

    public BrowserByPhantomJsDriverNoStatic(){}

    public BrowserByPhantomJsDriverNoStatic(String path){
//        log.info("启动虚拟浏览器开始。。。");
        webDriver = getWebDriver(path);
//        log.info("启动虚拟浏览器结束。。。");
    }

    private PhantomJSDriver getWebDriver(String path) {
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
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, path);
        //创建无界面浏览器对象
        return new PhantomJSDriver(dcaps);
    }
    /*
    加载网页
     */
    public void LoadUrl(String url){
        webDriver.get(url);
    }
    /*
    设置截屏窗口
     */
    public void ResetWindowSize(Dimension size){
        webDriver.manage().window().setSize(size);
    }
    /*
    运行JS
     */
    public Object executeScript(String script){
        return webDriver.executeScript(script);
    }
    /*
    运行phantomjs
     */
    public void executePhantomJS(String script){
        webDriver.executePhantomJS(script);
    }
    /*
    返回图片
     */
    public BufferedImage renderHtml2Image() throws IOException {
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
    public BufferedImage renderHtml2Image(String url, Dimension size, String script) throws IOException {
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
    public Image renderHtml2Image(String imgType) throws BadElementException,IOException {
        BufferedImage img = renderHtml2Image();
        byte[] bytes = Base64Util.encodeToByte(img,imgType);
        return Image.getInstance(bytes);
    }
    /*
    返回图片
     */
    public Image renderHtml2Image(String url, Dimension size, String imgType, String script) throws BadElementException,IOException {
        BufferedImage img = renderHtml2Image(url,size,script);
        byte[] bytes = Base64Util.encodeToByte(img,imgType);
        return Image.getInstance(bytes);
    }
    /*
    退出
     */
    public void quit(){
        webDriver.quit();
    }
    /*
    关闭
     */
    public void close(){
        webDriver.close();
    }
}
