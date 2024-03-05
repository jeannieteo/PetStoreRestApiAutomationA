package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReaders {
    String path_excel = "/testData/petstoreAPI_testData.xlsx";
    
    @DataProvider
    public Object[][] getUserData() {

        FileInputStream fileInput;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        String path;
        path = System.getProperty("user.dir") + path_excel;

        try {//open file
            fileInput = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try { //get workbook from the file
            workbook = new XSSFWorkbook(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet("Sheet1"); //get users worksheet
        int lastrow = sheet.getLastRowNum();
        int lastcol = sheet.getRow(0).getLastCellNum();
        //System.out.println("\nuser workSheet last row: " + lastrow);
        //System.out.println("\nuser workSheet last cell number: " + lastcol);

        //define size of object
        Object[][] data = new Object[lastrow][lastcol];

        //iterate and populate data
        for (int i = 1; i <= lastrow; i++) {//row-- omit first row cause they are header
            for (int j = 0; j < lastcol; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        
        try {
        	workbook.close();
            fileInput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    
    @DataProvider
    public String[] getUsername() {

        FileInputStream fileInput;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        String path;
        path = System.getProperty("user.dir") + path_excel;

        try {//open file
            fileInput = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try { //get workbook from the file
            workbook = new XSSFWorkbook(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet("Sheet1"); //get users worksheet
        int lastrow = sheet.getLastRowNum();
        //define size of object
        String[] usernames = new String[lastrow];

        //iterate and populate data
        for (int i = 1; i <= lastrow; i++) {//row-- omit first row cause they are header
        	usernames[i - 1] = sheet.getRow(i).getCell(1).getStringCellValue();
        }
        
        try {
        	workbook.close();
            fileInput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usernames;
    }

}