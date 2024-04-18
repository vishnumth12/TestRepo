package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicMedals {

	WebDriver driver;
	
	@org.testng.annotations.Test
	public void olympicMedalTally() {
		
		driver = new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		List <WebElement> countries = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		
		for(WebElement eachCountry : countries) {
			
			String country = eachCountry.getText();
			
			WebElement goldM = driver.findElement(By.xpath("//span[contains(text(),'Armenia')]/../following-sibling::div[@data-medal-id='gold-medals-row-2']"));
			WebElement silverM = driver.findElement(By.xpath("//span[contains(text(),'Armenia')]/../following-sibling::div[@data-medal-id='silver-medals-row-2']"));
			WebElement bronzeM = driver.findElement(By.xpath("//span[contains(text(),'Armenia')]/../following-sibling::div[@data-medal-id='bronze-medals-row-2']"));
			WebElement totalM = driver.findElement(By.xpath("//span[contains(text(),'Armenia')]/../following-sibling::div[@data-medal-id='total-medals-row-2']"));
			
			System.out.println(country+" : "+goldM.getText()+" : "+silverM.getText()+" : "+bronzeM.getText()+" : "+totalM.getText());
			
			
			
		}
	}
}
