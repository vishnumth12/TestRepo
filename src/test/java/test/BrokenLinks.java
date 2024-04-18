package test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {

	public WebDriver driver;
	
	@Test
	public void brokenlinksFacebook(){
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement links : allLinks) {
			String href = links.getAttribute("href");
			try {
			URL url = new URL(href);
			HttpsURLConnection hurl = (HttpsURLConnection) url.openConnection();
			int statusCode = hurl.getResponseCode();
			if(statusCode >= 400 && statusCode != 0) {
				System.out.println(href+" ==> "+statusCode);
			}
		}
		catch(Exception e) {
				
		}
	}
		
	}
	@Test
	public void brokenLinksKS() throws IOException, InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement link : allLinks) {
			
			try {
				
				String attri = link.getAttribute("href");
				URL url = new URL(attri);
				HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();
				int responseCode = huc.getResponseCode();
			
				if (responseCode >= 400 || responseCode == 0 ) {
					System.out.println(link.getText() +"--- The link is broken ---- " + responseCode);
				
				} 
				else{
					System.out.println(link.getText()+"The link is not broken"+ responseCode);
				}
				
			}
				catch (Exception e) {
			}
			
		}
			
			
			
	}
}
	
