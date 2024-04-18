package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarPopUpTest {

	public static WebDriver driver;
	
	@BeforeMethod
	public void calenderPop() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void redBus() throws InterruptedException {
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.id("onwardCal")).click();
		driver.findElement(By.xpath("//span[text()='28']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("onwardCal")).click();
		
		for(;;) {
			try {
		
		driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH' and text()='20']")).click();
			}
			catch(NoSuchElementException nse) {
				driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD' and @style='flex-grow: 1; cursor: pointer;'][2]")).click();
			}}
	}
}
