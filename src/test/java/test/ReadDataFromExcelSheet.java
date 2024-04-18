package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ReadData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String expValue = "lina";
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int lastRow = sh.getLastRowNum();
		int firstRow = sh.getFirstRowNum();
		int lastCell = sh.getRow(firstRow).getLastCellNum();
		int firstCell = sh.getRow(firstRow).getFirstCellNum();
		
		for(int r = firstRow; r<=lastRow; r++) {
			
			String actualValue = sh.getRow(r).getCell(firstCell).getStringCellValue();
			if(actualValue.equalsIgnoreCase(expValue)) {
				for(int c = firstCell; c< lastCell; c++) {
					
					String data = sh.getRow(r).getCell(c).getStringCellValue();
					System.out.print(data+" ");
				}
			}
		}
	}

}
