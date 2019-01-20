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

    @Test
    public void check(){
        Config_Excel.runAllTests("testData");
    }
}
