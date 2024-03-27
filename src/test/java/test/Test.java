package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

 public static void main(String[] args) throws IOException {
	
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://demo7.vtexperts.com/vtigercrm7demo/index.php");
	 
	 Properties p = new Properties();
	 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	 p.load(fis);
	 
	 String BROWSER = p.getProperty("browser");
	 String URL = p.getProperty("url");
	 String USERNAME = p.getProperty("username");
	 String PASSWORD = p.getProperty("password");
	 
	 WebElement usrField = driver.findElement(By.name("username"));
	 WebElement passField = driver.findElement(By.name("password"));
	 
	 usrField.clear();
	 usrField.sendKeys("demo");
	 passField.clear();
	 passField.sendKeys("demo");
	 
	 driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
	 
	 driver.quit();
	 
}
		
	

}
