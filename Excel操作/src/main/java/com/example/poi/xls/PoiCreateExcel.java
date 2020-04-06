package com.example.poi.xls;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        // 插入第一行
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        // 追加数据
        for (int i = 1; i < 10; i++) {// 这里的int 起始是1 也就是第二行开始
            HSSFRow nexTrow = sheet.createRow(i);
            HSSFCell cell2 = nexTrow.createCell(0);
            cell2.setCellValue("a"+i);
            cell2 = nexTrow.createCell(1);
            cell2.setCellValue("user");
            cell2 = nexTrow.createCell(2);
            cell2.setCellValue("男");
        }
        // 创建一个文件
        File file = new File("d:/poi.xls");
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
