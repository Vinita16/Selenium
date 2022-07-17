package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("/Users/vinitarajak/Desktop/TestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int totalSheet = workbook.getNumberOfSheets();
		for (int i = 0; i < totalSheet; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				// Access to first Row
				Row firstRow = rows.next();
				// Reading the first row
				Iterator<org.apache.poi.ss.usermodel.Cell> cel = firstRow.cellIterator();
				while (cel.hasNext()) {
					org.apache.poi.ss.usermodel.Cell value = cel.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {

					}

				}

			}
		}

	}

}
