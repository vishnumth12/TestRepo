package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
public class WriteDataIntoExcelFileTest {

	@Test
	public void writeData() throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ReadData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.createSheet("WriteData"+new Random().nextInt());
		
		for(int i =0; i<10; i++) {
			Row r = sh.createRow(i);
			for(int j = 0; j<10; j++) {
		Cell c = r.createCell(j);
		String s = "Write Data ";
		c.setCellValue(s+new Random().nextInt());
			}
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ReadData1.xlsx");
		wb.write(fos);
	}
}
