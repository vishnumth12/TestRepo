package SelectorsHubPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice1 {
	WebDriver driver;
	
	
	@Test
	public void enterUserEmail() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Actions a = new Actions(driver);
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		
		WebElement emailTf = driver.findElement(By.xpath("//input[starts-with(@id,'shub')]"));
		emailTf.sendKeys("mac@gmail.com");
		
		WebElement passTf = driver.findElement(By.id("pass"));
		passTf.sendKeys("pass#");
		
		WebElement compTf = driver.findElement(By.name("company"));
		compTf.sendKeys("Epitome");
		
		WebElement moblTf = driver.findElement(By.xpath("//div[@class='element-companyId']/descendant::div[.='Mobile Number']/following-sibling::input"));
		moblTf.sendKeys("987654345");
		
		WebElement cruTf = driver.findElement(By.id("inp_val"));
		cruTf.sendKeys("Tina");
		
		WebElement subBtn = driver.findElement(By.xpath("//button[.='Submit']"));
		subBtn.click();
		
		
		WebElement icn = driver.findElement(By.xpath("//*[name()='svg' and @iconid]/descendant::*[name()='path']"));
		
		a.moveToElement(icn).click(icn).perform();
		Thread.sleep(3000);
		WebElement nameFld = driver.findElement(By.xpath("//input[@placeholder= 'First Enter name']"));
		nameFld.sendKeys("Mac"); 
	
		WebElement lastNameTf = driver.findElement(By.xpath("//input[@placeholder='Enter Last name']"));
		a.moveToElement(lastNameTf).perform();

		//jse.executeScript("arguments[0].setAttribute('value', arguments[1])", lastNameTf, "Segwill");
		jse.executeScript("arguments[0].value = 'Segwill'", lastNameTf);
		
		WebElement dropBtn = driver.findElement(By.className("dropbtn"));
		dropBtn.click();
		
		WebElement dropOptn = driver.findElement(By.linkText("Join Training"));
		dropOptn.click();
		
		Set <String> windowHandles = driver.getWindowHandles();
		
		for(String win : windowHandles) {
			String title = driver.switchTo().window(win).getTitle();
			if(title.contains("Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios.")) {
				//driver.switchTo().window(win);
				break;
			}
		}
		
		WebElement dd = driver.findElement(By.id("cars"));
		Select s = new Select(dd);
		s.selectByIndex(2);
		
		
		
	}
}
