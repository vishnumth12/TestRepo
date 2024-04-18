package TenAssignments9April;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyntraWebSiteTests {
	
	ChromeOptions opn = new ChromeOptions();
	WebDriver driver = new ChromeDriver(opn);
	Actions a = new Actions(driver);
	
	@BeforeMethod
	public void launchBrowserAndLoadMyntra() {
		
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void closeBrowserWindows() {
		driver.quit();
	}
	
	@Test
	public void homeLivingList() {
	
		WebElement homeAndLivingTab = driver.findElement(By.xpath("//a[.='Home & Living']"));
		a.moveToElement(homeAndLivingTab).perform();
		String homeDecorLink = "//a[.='Home Décor']/ancestor::li[@class='desktop-oddColumnContent']/descendant::ul/descendant::li[position()<13]";
		List <WebElement> homeDecor = driver.findElements(By.xpath(homeDecorLink));
		
		for(WebElement hd : homeDecor) {
			System.out.println(hd.getText());
		}
	}
	
	@Test
	public void getCountOfRecords() throws InterruptedException{
		

		
		List<WebElement> images = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		Thread.sleep(20000);
		System.out.println("The number of images/records displayed on the webpage is : "+images.size());
	
		for(WebElement i : images) {
			System.out.println(i.getText());
		}
		
	}
	
	@Test
	public void selectCustRating() throws InterruptedException {
		
		opn.addArguments("--disable-notifications");
		
		WebElement mensTab = driver.findElement(By.xpath("//a[.='Men']"));
		a.moveToElement(mensTab).perform();
		String jacketsLink = "//a[.='Jackets' and @href = '/men-jackets']";
		driver.findElement(By.xpath(jacketsLink)).click();
		
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("//label[@class='sort-label ' and text()='Customer Rating']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder= 'Search for products, brands and more']")).sendKeys("Mango-Man", Keys.ENTER);
		WebElement assertion = driver.findElement(By.xpath("//h1[.='Mango Man']"));
		if(assertion.getText().equalsIgnoreCase("Mango Man")) {
			System.out.println("Mango Man Shirt page is displayed");
		}else {
			System.out.println("Failed to load Mango Man shirts page");
		}
		driver.findElement(By.xpath("//div[@class='search-searchProductsContainer row-base']/descendant::li[position()=6]")).click();
		
		Set<String> win = driver.getWindowHandles();
		for(String winHan : win) {
			String title= driver.switchTo().window(winHan).getTitle();
			if(title.contains("Buy MANGO MAN V Neck Pure Cotton T Shirt  - Tshirts for Men 27353592 | Myntra")) {
				break;
			}
		}
		opn.addArguments("--disable-notifications");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='size-buttons-tipAndBtnContainer']/descendant::button[.='L']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag pdp-button pdp-flex pdp-center') and .='ADD TO BAG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='desktop-cart']/span")).click();
		String firstItem = "//div[@id='cartItemsList']/descendant::div[@class='item-base-item'][position()<2]/descendant::div[@class='itemContainer-base-brand']";
		WebElement first = driver.findElement(By.xpath(firstItem));
		
		if(first.getText().equalsIgnoreCase("MANGO MAN")) {
			System.out.println("The #1 item is displaying");
		}else {
			System.out.println("The #1 item is not displaying");
		}
	}
}
