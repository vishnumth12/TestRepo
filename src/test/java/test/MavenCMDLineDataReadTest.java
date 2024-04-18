package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MavenCMDLineDataReadTest {

	@Test
	public void MavenCMDLine() {
		
		WebDriver driver=null;

		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		if(BROWSER.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser Name");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.quit();
	}

}
