package TenAssignments9April;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectADropDownByParameter {
	
	WebDriver driver;
	
	public void selectDDOption(String ddIdentifier) {
	WebElement dd = driver.findElement(By.xpath("dd selector"));
	Select s = new Select(dd);
	s.selectByVisibleText(ddIdentifier);
	}

}
