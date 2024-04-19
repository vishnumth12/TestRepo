package TenAssignments9April;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AvedaTest {

	WebDriver driver;
	
	@Test
	public void selectAllProducts() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.aveda.de/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.id("onetrust-reject-all-handler")).click();
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//div[.='GERMANY' and @id='site-footer-select-country--label']"));
		JavascriptExecutor se = (JavascriptExecutor) driver;
		se.executeScript("arguments[0].scrollIntoView()", country);
		Thread.sleep(3000);
		country.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='UNITED STATES' and @role='gridcell']")).click();
		Set <String> winHandles = driver.getWindowHandles();
		for(String handle : winHandles) {
			String title = driver.switchTo().window(handle).getTitle();
			
			if(title.contains("Vegan Hair Conditioners & Salons | Aveda")) {
				break;
			}
		}

		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Modal Message']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		WebElement ele2 =  driver.findElement(By.xpath("//button[@id='id4y']//*[name()='svg']//*[name()='path']"));
		ele2.click();
		driver.navigate().refresh();
		WebElement sb = driver.findElement(By.xpath("(//div[@class='content']/descendant::a[.='SKIN & BODY'])[2]"));
		a.moveToElement(sb).perform();
		
		String allMakeup = "(//div[@class='content']/descendant::a[.='all makeup'])[2]";
		driver.findElement(By.xpath(allMakeup)).click();
		
		Thread.sleep(5000);
		
		List <WebElement> li = driver.findElements(By.xpath("//h2[text() and text()!='Do Not Sell or Share My Personal Information / Targeted Ads']"));


		for(WebElement mu : li) {
			System.out.println(mu.getText());
		}
		
		driver.quit();
		
		}
	
	}
 