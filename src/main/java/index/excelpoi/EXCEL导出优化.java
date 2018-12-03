package index.excelpoi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Created by wangzhe.bj on 2018-12-03.
 */
public class EXCEL导出优化 {

    /**
     * 手动刷
     *
     * @param args
     * @throws IOException
     */
    public static void main2(String[] args) throws IOException {
        System.setProperty("java.io.tmpdir", "C:\\Users\\User\\AppData\\Local\\Temp\\poi");
        System.out.println(System.getProperty("java.io.tmpdir"));

        // turn off auto-flushing and accumulate all rows in memory
        SXSSFWorkbook wb = new SXSSFWorkbook(-1);
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 100000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

            // manually control how rows are flushed to disk
            if (rownum % 100 == 0) {
                ((SXSSFSheet) sh).flushRows(100);
                // retain 100 last rows and flush all others

                // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                // this method flushes all rows
            }

        }

        File file = new File("sxssf.xlsx");
        if (file.exists()) {
            file.delete();
        }

        FileOutputStream out = new FileOutputStream("sxssf.xlsx");

        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();


    }


    /**
     * 自动刷临时文件
     * SXSSFWorkbook
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.setProperty("java.io.tmpdir", "C:\\Users\\User\\AppData\\Local\\Temp\\poi");
        System.out.println(System.getProperty("java.io.tmpdir"));

        // turn off auto-flushing and accumulate all rows in memory
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 10000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }
        }

        File file = new File("sxssf.xlsx");
        if (file.exists()) {
            file.delete();
        }

        FileOutputStream out = new FileOutputStream("sxssf.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
//        wb.dispose();


    }


}
