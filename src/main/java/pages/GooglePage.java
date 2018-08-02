package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import controller.Button;
import controller.Textbox;
import controller.Link;

public class GooglePage extends BasePage {

	public GooglePage()
	{
		super(By.xpath(""));
	}
	
	public Textbox search_txtb()
	{
		try
		{
			return new Textbox(By.id("lst-ib"));
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
			return new Button(By.xpath("//*[@value='Google Search']"));
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
			return new Link(By.xpath("//a[@href='"+link+"']"));
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
}
