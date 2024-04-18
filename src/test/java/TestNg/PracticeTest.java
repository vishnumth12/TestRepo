package TestNg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test(priority = 1, invocationCount = 1)
	public void createTest() {
		//Assert.fail();
		System.out.println("----Create test----");
		Reporter.log("Create test", true);//prints both in report and in console
		Reporter.log("create test"); //prints only in report not in console
	}
	
	@Test(priority = 3, dependsOnMethods= {"createTest"})
	public void deleteTest() {
		System.out.println("----Delete Test-----");
	}

	@Test(priority =2)
	public void editTest() {
		System.out.println("-----Edit Test------");
	}
	
	
}
