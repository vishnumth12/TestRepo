package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraDatabase {
	
  public static WebDriver driver;
  
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\RMGCommonData.properties");
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		driver.get(URL);
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create Project')]")).click();
		
//		driver.findElement(By.cssSelector("input[name='projectName'][type='text']")).sendKeys("OneProject"+new Random().nextInt());
		//WebElement teamSize = driver.findElement(By.cssSelector("input[name='teamSize'][type='text']"));
		//JavaScriptExecutor js = (JavaScriptExecutor)driver;
		Random ran = new Random();
		int random = ran.nextInt();
		String expData = "Mac"+random;
		driver.findElement(By.cssSelector("input[name='projectName'][type='text']")).sendKeys(expData);
		driver.findElement(By.cssSelector("input[name='createdBy'][type='text']")).sendKeys(expData);
		WebElement dd = driver.findElement(By.xpath("//label[text()='Project Status ']//following-sibling::select"));
		
		Select s = new Select(dd);
		s.selectByValue("Created");
		
		driver.findElement(By.cssSelector("input[value='Add Project']")).click();
		
		driver.quit();
		
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
	
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
				
		System.out.println("print");
		
		Statement state = con.createStatement();
		System.out.println(expData);
		String query = "select * from project where lower(project_name)='"+expData+"';";
//		String query = "desc project;";
				
		System.out.println("print 2");
		
		ResultSet result = state.executeQuery(query);
		
		System.out.println("print 3");
		
		while(result.next()) {
				System.out.println(result.getString(4));
		}
		
	System.out.println("print 4");
				con.close();
	}
	

}
