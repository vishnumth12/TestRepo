package test;

import org.testng.annotations.Test;
public class DataReceiverClass {

	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "dataProvider1")
	public void dataReader1(String name, String job) {
		System.out.println(name+" is working as a "+job);
	}
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "four")
	public void dataReader2(String name, String job) {
		System.out.println(name+" is working as a "+job);
	}
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "company")
	public void dataReader3(String name, String job, String company) {
		System.out.println(name+" is working as a "+job+ " at " +company);
	}

}
