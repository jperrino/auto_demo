package pageObjects;

import driver.DriverInstanceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import controls.Button;
import controls.Textbox;
import controls.Link;

public class GooglePage extends BasePageObject {

	public GooglePage(DriverInstanceManager driver)
	{
		super(By.xpath(""));
		super.setDriver(driver);
	}

	public void setDriver(DriverInstanceManager driver)
	{
		super.setDriver(driver);
	}
	
	public Textbox search_txtb()
	{
		try
		{
			return new Textbox(By.name("q"), super.getDriverManager());
					//id("lst-ib"));
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Button search_btn()
	{
		try
		{
			return new Button(By.xpath("//*[@value='Google Search']"), super.getDriverManager());
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}

	public Link result_link(String link)
	{
		try
		{
			return new Link(By.xpath("//a[@href='"+link+"']"), super.getDriverManager());
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
}
