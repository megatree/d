package index.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by user on 2018-09-17
 */
public class ExportPDF {
    /*
    直接用图片生成PDF
     */
    public static void ExportPDFWithImage(List<Image> images, OutputStream out) throws DocumentException, IOException {
        Document doc = new Document(PageSize.A4,0,0,0,0);
        PdfWriter pdf = PdfWriter.getInstance(doc,out);
        doc.open();
        float percent =  (PageSize.A4.getWidth()/getMaxWidth(images))*100;
        for(int i=0;i<images.size();i++){
            Image image = images.get(i);
            image.scalePercent(percent);
            doc.add(image);
            if(i < images.size() - 1){
                doc.newPage();
            }
        }
        doc.close();
        pdf.close();
        out.close();
    }
    /*
    直接用图片生成PDF
     */
    public static void ExportPDFWithImage(Map<Integer,Image> images, OutputStream out) throws DocumentException, IOException {
        List<Image> list = new ArrayList<Image>();
        for(Integer i : images.keySet()){
            list.add(images.get(i));
        }
        ExportPDFWithImage(list,out);
    }
    /*
    根据图片路径导出PDF
     */
    public static void ExportPDFWithUrl(List<String> images, OutputStream out) throws DocumentException, IOException {
        Document doc = new Document(PageSize.A4,0,0,0,0);
        PdfWriter pdf = PdfWriter.getInstance(doc,out);
        doc.open();
        for(int i=0;i<images.size();i++){
            Image image = Image.getInstance(images.get(i));
            image.scalePercent((PageSize.A4.getWidth()/image.getWidth())*100);
            doc.add(image);
            if(i < images.size() - 1){
                doc.newPage();
            }
        }
        doc.close();
        pdf.close();
        out.close();
    }

    /**
     * 获取最大宽度
     * @param list
     * @return
     */
    public static float getMaxWidth(List<Image> list){
        float temp = 0;
        float a = 0;
        for(int i=0;i<list.size();i++) {
            temp = list.get(i).getWidth();
            if(i > 0){
                a = list.get(i-1).getWidth();
                if(temp < a){
                    temp = a;
                }
            }
        }
        return temp;
    }
}
