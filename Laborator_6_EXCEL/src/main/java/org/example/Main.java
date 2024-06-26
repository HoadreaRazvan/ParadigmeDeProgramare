package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));

//Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

//Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                //Check the cell type and format accordingly
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "t");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    }
}