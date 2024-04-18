package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		
		p.setProperty("browser", "Edge");
		p.setProperty("url", "the website url");
		p.setProperty("username", "demo");
		p.setProperty("password", "demo");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\CommonData2.properties");
		p.store(fos, "The data is stored");

	}

}
