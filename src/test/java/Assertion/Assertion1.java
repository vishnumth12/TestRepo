package Assertion;

//import static org.testng.Assert.assertNotEquals; no need intead use import static org.testng.Assert.*; for all Hard assertions

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Assertion1 {

	WebDriver driver;
	
	@Test
	public void testAsert1() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		String title = driver.getTitle();
		//assertEquals(title, "Facebook – log in or sign up");
		assertNotEquals(title, "Facebook – log in or sign up");
		System.out.println("Facebook login page is displayed");
		driver.close();
		
	}
	
	@Test
	public void testAssert2() {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		boolean titleMatch = driver.getTitle().equals("Amazon.com");
		//assertTrue(titleMatch);
		assertFalse(titleMatch);
		System.out.println("Title is matched");
		driver.close();
		
	}
	
	@Test
	public void testAsert3() {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Boolean titleMatch = driver.getTitle().equals("Amazon.com");
		assertNotNull(titleMatch);
		System.out.println("Title is matched");
		fail("Failed");
		driver.close();
		
	}
	
	@Test
	public void testAssert4() {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//Boolean titleMatch = driver.getTitle().equals("Amazon.com");
		String actualTitle = "Amazon.com";
		String expTitle = driver.getTitle();
		
		assertSame(actualTitle, expTitle);
		driver.close();
		
		
	}
	
	
}
