package com.example.JXL;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class JxlReadExcel {

    public static void main(String[] args) {
        try {
            // 创建 Workbook
            Workbook workbook = Workbook.getWorkbook(new File("d:/jxl.xls"));
            // 获取工作表sheet
            Sheet sheet = workbook.getSheet(0);
            // 获取数据
            for (int i = 0; i < sheet.getRows(); i++) {// 获取行
                for (int j = 0; j < sheet.getColumns(); j++) {// 获取列
                    Cell cell = sheet.getCell(j,i);
                    System.out.print(cell.getContents() + " ");// 得到单元格的内容
                }
                System.out.println();
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
