package com.example.poi.xlsx;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class PoiReadExcel {
    public List<Double> readExcels(InputStream is)throws Exception{
        List<Double> xlsxList = new ArrayList<Double>();
        try {
            if(is ==null){
                throw new IOException("文件不正确！");
            }
            Workbook workbook = WorkbookFactory.create(is);
            FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
            //获取第一张表
            Sheet sheet = workbook.getSheetAt(0);
            if(sheet == null){
                throw new IOException("传入的excel的第一张表为空！");
            }
            for(int rowNum = 0;rowNum <= sheet.getLastRowNum(); rowNum++){
                Row row = sheet.getRow(rowNum);
                if(row != null){
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String result = "";
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        double value = 0;
                        String valueString = cell.getStringCellValue();
                        if(null!=fe.evaluate(cell)){
                            value = fe.evaluate(cell).getNumberValue();
                        }
                        //result = result + cellNum + ":"+value + "----";
                        result = result + cellNum + ":"+valueString + "----";
                    }
                    System.out.println(result + "  ");
                }
            }
            is.close();
        } catch (FileNotFoundException e) {
            throw new Exception("文件不正确!");
        }
        return xlsxList;
    }

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("d:/poi.xlsx");
        PoiReadExcel re = new PoiReadExcel();
        re.readExcels(is);
    }
}
