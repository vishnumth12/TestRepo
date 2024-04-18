package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.OFOSWelcomePage;

public class LoginToOFOSTest {

	@org.testng.annotations.Test(dataProviderClass = DataProviderClass.class, dataProvider = "dataProvider1")
	public void loginToApp(String username, String password) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		WebElement loginTab = driver.findElement(By.linkText("Login"));
		loginTab.click();
		
		WebElement loginFormHeaderText = driver.findElement(By.xpath("//h2[.='Login to your account']"));
		
		//Validation
		if(loginFormHeaderText.getText().equals("Login to your account")) {
			System.out.println("Login to your account Page is Displayed");
		}
		else {
			System.out.println("Defect : Login to your account not displayed");
		}
		
		OFOSWelcomePage wp = new OFOSWelcomePage(driver);
		wp.navigateToLoginPageAndValidate(driver);
			
		WebElement usernameTextfield = driver.findElement(By.name("username"));
		usernameTextfield.sendKeys(username);
		
		WebElement passwordTextfield = driver.findElement(By.name("password"));
		passwordTextfield.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.id("buttn"));
		loginButton.click();
		
		driver.quit();
	}
	
	
}
