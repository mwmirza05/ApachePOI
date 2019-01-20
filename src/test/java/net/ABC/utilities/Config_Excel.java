package net.ABC.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Config_Excel {
    // declaring the the static variables
    static File source;
    static FileInputStream file;
    static String path = "C:\\Users\\Flame\\eclipse-workspace\\Migrations\\src\\test\\resources\\testData\\testData.xlsx";
    static XSSFWorkbook wk;

    //intializing the static variables
    static {
        try{
            source = new File(path);
            file = new FileInputStream(source);
            wk = new XSSFWorkbook(file);
        }catch (Exception e){
            System.out.println("File loading error: File path"+path+"is incorrectt");
        }
    }

    // This method will be used for one specific quiry
    public static String getExcelData (String sheetName, int rowNum, int columnNum){
        String data;
        try{
            XSSFWorkbook wk = new XSSFWorkbook(file);
            XSSFSheet sheet = wk.getSheet(sheetName);
            data = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
        }catch (Exception e){
            data = "File loading error: File path"+path+"is incorrect";
        }
        return data;
    }

    // This method will used to get the sql methods for any specific test case
    public static String getMethodsCell( String sheetName, String test_id) {
        String methodsCell ="";
        try {
            XSSFSheet sheet = wk.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();
            int idColumn = 0; // assuming first column will have id's - you can reset
            int executionChecknColumn = 2; // assuming third column will have execution check - you can reset
            int methodsColumn = 1; // assuming second column will have sql methods - you can reset
            for (int r = 0; r <= lastRow; r++) {
                String id = sheet.getRow(r).getCell(idColumn).getStringCellValue();
                String executionCheck = sheet.getRow(r).getCell(executionChecknColumn).getStringCellValue();
                if (id.equalsIgnoreCase(test_id) && executionCheck.equalsIgnoreCase("y")) {
                    methodsCell = sheet.getRow(r).getCell(methodsColumn).getStringCellValue();
                }
            }
//            if(methodsCell.equals("")){
//                System.out.println("Error: Re-check testCase id & Test CaseExecution & SheetName");
//            }
        } catch (Exception e) {
            System.out.println("File loading error: File path" + path + "is incorrect");
        }
        return methodsCell;
    }

    // this method can be used to to directly get the String array for sql methods of any specific test case
    // Not recommended to use because empthy will come as "[]" - chances of error
    public static String[] getMethodsArray (String sheetName, String test_id){
        String data = getMethodsCell(sheetName, test_id) ;
        return data.split("&");
    }

    // this method will run all the te
    public static void runAllTests(String sheettName){

        String methodsCell ="";
        try {
            XSSFSheet sheet = wk.getSheet(sheettName);
            int lastRow = sheet.getLastRowNum();
            int idColumn = 0; // assuming first column will have id's - you can reset
            String[] sqlMethods;

            for (int r = 0; r <= lastRow; r++) {
               String test_id = sheet.getRow(r).getCell(idColumn).getStringCellValue();
               sqlMethods = getMethodsCell(sheettName,test_id).split("&");
                    for(String sql_method : sqlMethods){
                        // here you declare reusable method for of each test case by whatever suits you..
                        // you can use case or just declare here by name

                        System.out.println(sql_method); // illustration purposes
                    }
                sqlMethods = null;
            }

        } catch (Exception e) {
            System.out.println("File loading error: File path" + path + "is incorrect");
        }
    }

}
