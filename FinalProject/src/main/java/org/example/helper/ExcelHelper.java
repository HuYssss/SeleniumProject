package org.example.helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHelper {
    public static Object[][] readExcelFromFile(String filePath) {
        Object[][] dataProvider;
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            dataProvider = new Object[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);

                    if (cell != null) {
                        dataProvider[i][j] = cell.toString();
                    } else {
                        dataProvider[i][j] = "";
                    }
                }
            }

            workbook.close();

            return dataProvider;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }
}