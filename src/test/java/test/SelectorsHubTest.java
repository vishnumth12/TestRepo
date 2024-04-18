package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorsHubTest {

	
	@org.testng.annotations.Test
	public void shadowRootElements() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement shadowRootUsername = driver.findElement(By.cssSelector("input[id='kils']"));
		SearchContext sc = shadowRootUsername.getShadowRoot();
		Thread.sleep(3000);
		sc.findElement(By.id("kils")).sendKeys("Mac");
		
		driver.close();
		
	}
}
