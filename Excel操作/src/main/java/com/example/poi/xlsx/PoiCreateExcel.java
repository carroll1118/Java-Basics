package com.example.poi.xlsx;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class PoiCreateExcel {

    public static void main(String[] args) {
        // 创建表头
        String[] title = {"id","name","sex"};
        //创建Excel工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个工作表shheet
        Sheet sheet = workbook.createSheet();
        //创建第一行
        Row row = sheet.createRow(0);
        Cell cell = null;
        // 插入第一行
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 追加数据
        for (int i = 1; i < 10; i++) {// 这里的int 起始是1 也就是第二行开始
            Row nexTrow = sheet.createRow(i);
            Cell cell2 = nexTrow.createCell(0);
            cell2.setCellValue("a"+i);
            cell2 = nexTrow.createCell(1);
            cell2.setCellValue("user");
            cell2 = nexTrow.createCell(2);
            cell2.setCellValue("男");
        }
        // 创建一个文件
        File file = new File("d:/poi.xlsx");// 这里可以修改成高版本的
        try {
            file.createNewFile();
            // 将内容存盘
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);

            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
