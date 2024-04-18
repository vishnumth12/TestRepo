//package test;
//
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//public class CloseTheNthWindow {
//	 WebDriver driver;
//	 
//	@org.testng.annotations.Test
//	public WebDriver closeThe7thWindow() throws InterruptedException {
//		for(int i =1; i <= 10; i++) {
//		driver = new ChromeDriver();
//		driver.get("https://www.flipkart.com/");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("count : "+i);
//		}
//
//	}
//	@Test
//	public void quitBrowser() throws InterruptedException {
//		WebDriver driver = closeThe7thWindow();
//		driver.quit();
//	}
//}
