package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EMICalculator {

	@Test
	public void emiCalculator() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Actions a = new Actions(driver);
		String toolTip = "//div[@id='emibarchart']/div//*[name()='svg']//*[@x=8]";
		String points = "//div[@id='emibarchart']/div//*[name()='svg']//*[contains(@class,'highcharts-marker')]/*";
		List <WebElement> allPoints = driver.findElements(By.xpath(points));
	
		for (WebElement aPoints : allPoints) {
			a.moveToElement(aPoints).perform();
			List <WebElement> ele2 = driver.findElements(By.xpath(toolTip));
			
			for(WebElement text : ele2){
				System.out.println(text.getText());
				
			}
			System.out.println("");
		}
		driver.close();
		
	}
	
	
	
	
	
}
