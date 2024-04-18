package test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public Object[][] dataProvider1() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "rmg";  	data[0][1] = "rmg123";
		data[1][0] = "Neena";   data[1][1] = "Developer";
		data[2][0] = "Zac";  	data[2][1] = "Scrum Master";
		
		return data;
	}
	
	@DataProvider(name = "four")
	public Object[][] dataProvider2() {
		
		Object[][] data = new Object[4][2];
		
		data[0][0] = "Mac";  	data[0][1] = "QA";
		data[1][0] = "Neena";   data[1][1] = "Developer";
		data[2][0] = "Meena";  	data[2][1] = "Scrum Master";
		data[3][0] = "Zac";  	data[3][1] = "Product Owner";
		
		return data;
	}
	
	@DataProvider(name = "company")
	public Object[][] dataProvider3() {
		
		Object[][] data = new Object[4][3];
		
		data[0][0] = "Mac";  	data[0][1] = "QA";         		data[0][2] = "Cognizant";
		data[1][0] = "Neena";   data[1][1] = "Developer";		data[1][2] = "TCS";
		data[2][0] = "Meena";  	data[2][1] = "Scrum Master";	data[2][2] = "Accenture";
		data[3][0] = "Zac";  	data[3][1] = "Product Owner";	data[3][2] = "Uber";
		
		return data;
	}
}
