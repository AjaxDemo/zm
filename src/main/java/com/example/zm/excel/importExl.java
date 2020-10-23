package com.example.zm.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author:zm
 * @since 2020/10/22 23:14
 */
public class importExl {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/员工信息.xlsx");
        //获得该文件的输入流
        FileInputStream stream = new FileInputStream(file);
        // 多态  抛异常
        Workbook sheets = new XSSFWorkbook(stream);
        //获取一个工作表(sheet页)，下标从0开始
        Sheet sheet = sheets.getSheetAt(0);
        for (int i = 1; i<=sheet.getLastRowNum() ; i++) {
            // 获取行数
            Row row = sheet.getRow(i);
            // 获取单元格 取值
            String value1 = row.getCell(0).getStringCellValue();
            String value2 = row.getCell(1).getStringCellValue();
            String value3 = row.getCell(2).getStringCellValue();
            String value4 = row.getCell(3).getStringCellValue();
            String value5= row.getCell(4).getStringCellValue();

            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println(value4);
            System.out.println(value5);
        }
        //关流
        sheets.close();
        stream.close();
    }
}
