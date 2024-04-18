package TenAssignments9April;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MacCosmetics {

	WebDriver driver;
	
	@Test
	public void shopNowButton() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
		Thread.sleep(3000);
		search.sendKeys("one");
		search.clear();
		search.sendKeys("songs");
		
		Thread.sleep(3000);
		List<WebElement> autosuggestions = driver.findElements(By.xpath("//div[@class='sbdd_b']/descendant::li/descendant::b"));
		
		System.out.println(autosuggestions.size());
		
		for(WebElement li : autosuggestions) {
			System.out.println(li.getText());
		}
		
		driver.findElement(By.xpath("//div[@class='sbdd_b']/descendant::li/descendant::b[.=' new']")).click();
	
		//driver.findElement(By.xpath("//li//descendant::b[.=' new']")).click();
	}
}
