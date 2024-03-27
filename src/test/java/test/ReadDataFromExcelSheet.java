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
		
		Scanner sc = new Scanner(System.in);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Read.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String expValue = "Mac";
		
		Sheet sh = wb.getSheet("Sheet1");
		
		int lastRow = sh.getLastRowNum();
		int firstRow = sh.getFirstRowNum();
		int lastCell = sh.getRow(firstRow).getLastCellNum();
		int firstCell = sh.getRow(firstRow).getFirstCellNum();
		
		for(int r = 0; r <= 4; r++) {
			for(int c = 0; c <= 2; c++) {
				String firstColumn = wb.getSheet("Sheet1").getRow(r).getCell(c).getStringCellValue();
				System.out.println(firstColumn);
			}
			
			
		}
		
	}

}
