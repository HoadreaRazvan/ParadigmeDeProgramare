package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        OutputStream fileOut = new FileOutputStream("D:\\1_PROGRAMMING\\Java\\2_PROJECTS\\Paradigme_de_programare\\Laborator_7\\output.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Hoadrea Razvan");

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("2", new Object[] {"Amit", "Shukla", 9,8,7,5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8,9,6,7});
        data.put("4", new Object[] {"John", "Adwards", 8,8,7,6 });
        data.put("5", new Object[] {"Brian", "Schultz", 7,6,8,9});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

        Row dataRow;
        for(int i=0;i<4;i++) {

            dataRow = sheet.getRow(i);
            dataRow.createCell(6).setCellFormula("AVERAGE(C" + (i+1) + ":F" + (i+1) + ")");
            dataRow.createCell(7).setCellFormula("MAX(C" + (i+1) + ":F" + (i+1) + ")");
        }
        SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
        ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule(ComparisonOperator.LT, "100");
        PatternFormatting fill1 = rule1.createPatternFormatting();
        fill1.setFillBackgroundColor(IndexedColors.GREEN.index);
        fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        CellRangeAddress[] regions = {
                CellRangeAddress.valueOf("A1:A6")
        };

        sheetCF.addConditionalFormatting(regions,rule1);


//Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream(new File("output.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}