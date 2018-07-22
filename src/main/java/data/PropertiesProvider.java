package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
	
	FileInputStream fis;
	Properties prop;
	
	public PropertiesProvider()
	{
	File src = new File("./src/main/resources/config.property");
	try
	{
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		String chromePath = prop.getProperty("ChromeDriver");
		System.out.println("ChromePath is: "+chromePath);
	}
	catch(FileNotFoundException e)
	{
		System.out.println(e.getMessage());
	}
	catch(IOException e)
	{
		System.out.println(e.getMessage());
	}

	}
	
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}

}
