package test;

import java.net.SocketException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTheCountry {
	 
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/odi");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	Thread.sleep(3000);
	List <WebElement> countries = driver.findElements(By.cssSelector("h3[class='si-team-name']"));
	for(WebElement each : countries) {
	
		String text = each.getText();
		if(text.equalsIgnoreCase("Sri lanka")) {
			System.out.println(text);
			break;
		}
			
	}
	Thread.sleep(10000);
	driver.close();
	}
}
