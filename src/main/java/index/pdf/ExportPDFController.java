package index.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create by user on 2018-09-17
 */

@Controller
@RequestMapping("/pdf")
public class ExportPDFController {

    @Autowired
    private Environment env;


    @RequestMapping(value = "/download.do", method = {RequestMethod.POST, RequestMethod.GET})
    public void DownLoadPDF(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("生成PDF开始");
        String fileName = "服务数据报告-" + System.currentTimeMillis() +".pdf";
        OutputStream outputStream = null;
        try {
            // 防止中文乱码
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.setContentType("application/octet-stream;charset=UTF-8");
            outputStream = new BufferedOutputStream(response.getOutputStream());
            String NewCode = "";
            String OrderId = "";
            String params = "newcode=" + NewCode + "&" + "orderid=" + OrderId;
            String key = env.getProperty("api.order.fang.com.key");
            String value = env.getProperty("api.order.fang.com.key.value");
            String sign = EncryptUtil.getSign(key,value,params);
            String url = env.getProperty("a.txyun.fang.com") + "?newcode=" + NewCode + "&orderid=" + OrderId + "&sign=" + sign;
            Rectangle rectangle = PageSize.A4;
            int height = (int)(rectangle.getHeight()*2.5);
            int width = (int)(rectangle.getWidth()*2.5);
            Dimension size1 = new Dimension(width,2300);
            Dimension size2 = new Dimension(width,height);
            Map<Integer,Image> images = Collections.synchronizedSortedMap(new TreeMap<Integer, Image>());
            BrowserByPhantomJsDriverNoStatic driver = new BrowserByPhantomJsDriverNoStatic(env.getProperty("phantomjs.path"));
            System.out.println("加载网页开始。。。");
            driver.LoadUrl(url);
            int num = 0;
            while(!driver.executeScript("return getTotalRequest()").toString().equals("12")){
                if(++num > 75){
                    break;
                }
                Thread.sleep(200);
            }
            System.out.println("加载网页结束。。。");
            System.out.println("开始截图。。。");
            int pageSize = Integer.parseInt(driver.executeScript("return getPageNum()").toString());
            System.out.println("总页数：" + pageSize);
            for(int i=0;i<pageSize;i++){
                System.out.println("第"+(i+1)+"次截图开始。。。");
                driver.ResetWindowSize(size1);
                driver.executeScript(String.format("changeShow(%d)",i));
                driver.ResetWindowSize(size2);
                Thread.sleep(260);
                driver.executeScript("window.document.body.scrollTop = 8000;");
                Image image = null;
                if(i>0){
                    BufferedImage img = driver.renderHtml2Image();
                    image = ImageCut.MoveTopNpxToFoot(img);
                }else {
                    image = driver.renderHtml2Image("png");
                }
                images.put(i,image);
                System.out.println("第"+(i+1)+"次截图结束。。。");
            }
            System.out.println("截图结束。。。");
            driver.quit();
            System.out.println("生成PDF结束");
            ExportPDF.ExportPDFWithImage(images,outputStream);
        } catch (UnsupportedEncodingException e) {
            System.out.println("生成PDF异常：" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("生成PDF异常：" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("生成PDF异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

}
