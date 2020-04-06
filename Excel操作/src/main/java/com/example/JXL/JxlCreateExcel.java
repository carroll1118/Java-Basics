package com.example.JXL;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class JxlCreateExcel {

    public static void main(String[] args) {
        // 首先设置表格第一行 表格头名称 也就是列名
        String [] title = {"id","name","sex"};
        // 创建Excel文件 存入路径
        File file = new File("d:/jxl.xls");
        try {
            file.createNewFile();
            // 创建工作薄
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            // 创建sheet
            WritableSheet sheet = workbook.createSheet("sheet1",0);
            // 添加数据
            Label label = null;
            // 第一行设置列名
            for (int i = 0; i < title.length; i++) {
                label = new Label(i,0,title[i]);
                sheet.addCell(label);
            }
            // 追加数据 从第二行开始 i从1开始
            for (int i = 1; i < 9; i++) {
                label = new Label(0,i,"id:"+i);
                sheet.addCell(label);
                label = new Label(1,i,"user");
                sheet.addCell(label);
                label = new Label(2,i,"男");
                sheet.addCell(label);
            }
            // 写入 并在最后关闭流
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}