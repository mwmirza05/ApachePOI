package net.ABC.tests;

import net.ABC.utilities.Config_Excel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExcelTest {
//
public static void main(String[] args) {
    String g = Config_Excel.getMethodsCell("testData","test_01" );
    System.out.println(g);
    String h = Config_Excel.getMethodsCell("testData2","test_01" );
    System.out.println(h);
}


    //public void check(){Config_Excel.getMethodsCell("testData","test_01" );


}
