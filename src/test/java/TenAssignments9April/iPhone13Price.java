package TenAssignments9April;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iPhone13Price {

	WebDriver driver;
	
	@Test
	public void iphone() throws EncryptedDocumentException, IOException {
		
	driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	searchBox.sendKeys("iPhone 13");
	searchBox.clear();
	searchBox.sendKeys("iPhone 13");
	driver.findElement(By.id("nav-search-submit-text")).click();
	String xpath1 = "//span[.='Apple iPhone 13 Pro, 128GB, Sierra Blue - Unlocked (Renewed)']/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='puisg-row']/descendant::span[@class='a-price-whole']";
	WebElement price = driver.findElement(By.xpath(xpath1));
	
	String pricei = price.getText();
	System.out.println(pricei);
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ReadData1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Cell c = wb.getSheet("Sheet3").createRow(8).createCell(0);
	c.setCellValue(pricei);
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\ReadData1.xlsx");
	wb.write(fos);
	
	driver.close();
	
	}	
	
}
