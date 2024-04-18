package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapFormRead {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ReadData1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet3");
		
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		
		
		
		
		HashMap <String, String> rD = new HashMap<String, String>();
		String key = null;
		String value = null;
		for(int r = 0; r <= rowCount; r++) {
			for(int c = 1; c < cellCount;c++) {
				key = sh.getRow(r).getCell(0).getStringCellValue();
				value = sh.getRow(r).getCell(c).getStringCellValue();
				
				rD.put(key, value);
			}
		}
		
		driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		for(Entry <String, String> map : rD.entrySet()) {
			
			driver.findElement(By.name(key)).sendKeys(value);
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//span[.='My Account']")).click();
			driver.findElement(By.linkText("Logout")).click();
			
			driver.findElement(By.xpath("//span[.='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			
		}
		
		
	}
}
