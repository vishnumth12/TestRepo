package TestNg;

import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider = "sendData1")
	public void getData(String car, String color, String fuel) {
		System.out.println("The car is : "+car+" with color "+color+" and fuel "+fuel);
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] sendData(){
		
		Object [][] data = new Object[3][2];
		
		data[0][0] = "Tata";
		data[0][1] = "Green";
	
		data[1][0] = "Audi";
		data[1][1] = "Red";
		
		data[2][0] = "BMW";
		data[2][1] = "Blue";
		
		return data;
		
	}
	
	
	@org.testng.annotations.DataProvider
	public Object[][] sendData1(){
		
		Object [][] data = new Object[3][3];
		
		data[0][0] = "Tata";
		data[0][1] = "Green";
		data[0][2] = "petrol";
	
		data[1][0] = "Audi";
		data[1][1] = "Red";
		data[1][2] = "diesel";
		
		data[2][0] = "BMW";
		data[2][1] = "Blue";
		data[2][2] = "CNG";
		
		return data;
		
	}
}
