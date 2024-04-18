package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabaddiMedals {

	WebDriver driver;
	
	@org.testng.annotations.Test
	public void getMedals() {
		
		driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List <WebElement> allTeams = driver.findElements(By.xpath("//div[@class='team-information']"));
		int teamNum = allTeams.size();

		for(WebElement ele : allTeams) {
			
			String teamName = ele.getText();
			
				WebElement tmp = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data matches-play']"));
				WebElement tmw = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data matches-won']"));
				WebElement tml = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data matches-lost']"));
				WebElement tmd = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data matches-draw']"));
				WebElement tmsd = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data score-diff']"));
			//	WebElement tf = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data form']"));
				WebElement tp = driver.findElement(By.xpath("//p[contains(text(),'"+teamName+"')]/../../../following-sibling::div[@class='table-data points']"));
				
				System.out.println(teamName+" : "+tmp.getText()+" : "+tmw.getText()+" : "+tml.getText()+" : "+tmd.getText()+" : "+tmsd.getText()+" : "+tp.getText());
			}
	}
}
