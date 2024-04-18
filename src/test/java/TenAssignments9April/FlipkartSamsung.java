package TenAssignments9April;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipkartSamsung {

	WebDriver driver;
	
	@Test
	public void selectSmsung() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@class='YBLJE4']/descendant::span[.='Appliances']/child::span[.='Appliances']")).click();
		WebElement tv = driver.findElement(By.xpath("//div[@class='_3Il5oO dwRsDN']//*[.='TVs & Appliances']"));
		Actions a = new Actions(driver);
		a.moveToElement(tv).perform();
		driver.findElement(By.xpath("//div[@class='_1fwVde']/descendant::a[.='Samsung']")).click();
		
	}
}
