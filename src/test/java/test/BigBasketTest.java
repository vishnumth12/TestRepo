package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketTest {

	@org.testng.annotations.Test
	public void bigBasketItem() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		WebElement searchBox = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='mx-2.5 w-4 h-4 text-appleGreen-500 fill-appleGreen-500']/following-sibling::input)[2]"));
		searchBox.sendKeys("apple", Keys.ENTER);
		
		Thread.sleep(4000);
		WebElement appleAddToCartBtn = driver.findElement(By.xpath("//h3[.='Apple - Royal Gala Economy']/../../../following-sibling::div//div[contains(@class,'relative flex flex-col w-full lg:h-8 xl:h-9 overflow-hidden')]"));
		Actions ac = new Actions(driver);
		ac.click(appleAddToCartBtn).perform();
		Thread.sleep(3000);
		WebElement addBtn = driver.findElement(By.xpath("//h3[.='Apple - Royal Gala Economy']/../../../following-sibling::div//button/*[name()='svg' and @class='CtaOnDeck___StyledPlusIcon-sc-orwifk-12 kyqQMg']"));
		
		for(int i=1; i<3; i++) {
			Thread.sleep(3000);
		ac.moveToElement(addBtn).click().perform();
		Thread.sleep(3000);
		}
		driver.quit();
	}		
  }
