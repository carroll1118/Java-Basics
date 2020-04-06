package com.example.poi.xls;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class PoiReadExcel {
    public static void main(String[] args) {

        // 引入需要解析的文件
        File file = new File("d:/poi.xls");
        try {
            // 创建Excel 读取文件内容
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
            /**
             * 第一种方式读取Sheet页
             */
//            HSSFSheet sheet = workbook.getSheet("Sheet0");
            /**
             * 第二种方式读取Sheet页
             */
            HSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = 0;// 起始行第0行
            int lasrRowNum = sheet.getLastRowNum();// 一直读到最后一行
            for (int i = 0; i < lasrRowNum; i++) {
                HSSFRow row = sheet.getRow(i);
                // 获取当前最后单元格列号
                int lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    HSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();// 注意！ 如果Excel 里面的值是String 那么getStringCellValue 如果是其他类型 则需要修改
                    System.out.print(value + "  ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
