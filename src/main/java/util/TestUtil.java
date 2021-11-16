package util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil
{


        public static long PAGE_LOAD_TIMEOUT = 20;
        public static long IMPLICIT_WAIT = 20;

        public static String TESTDATA_SHEET_PATH = "/Users/apple/IdeaProjects/ReadExcelData/"+"/Users/apple/IdeaProjects/ReadExcelData/src/main/java/testdatapkg/logindata.xlsx";


        static Workbook book;
        static Sheet sheet;




        public static Object[][] getTestData(String sheetName) throws IOException {
            FileInputStream file = null;

                file = new FileInputStream(TESTDATA_SHEET_PATH);


                book = WorkbookFactory.create(file);

            sheet = book.getSheet(sheetName);
            Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            // System.out.println(sheet.getLastRowNum() + "--------" +
            // sheet.getRow(0).getLastCellNum());
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                    // System.out.println(data[i][k]);
                }
            }
            return data;
        }}


