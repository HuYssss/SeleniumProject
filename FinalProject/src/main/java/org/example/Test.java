package org.example;

import org.example.configuration.Configuration;
import org.example.helper.ExcelHelper;

public class Test {
    public static void main(String[] args) {
        Configuration config = new Configuration("app.properties");
        String path = config.getProperty("data");

        Object[][] excelData = ExcelHelper.readExcelFromFile(path);

        for (Object[] row : excelData) {
            for (Object cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
