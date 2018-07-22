package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Link extends BaseControl {

    public Link(By by) {
        super(by);
    }

    public String getLinkText()
    {
        try
        {
            return getElement().getAttribute("href");
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
    }

    public String getText()
    {
        try
        {
            return getElement().getText();
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
    }

    public void click()
    {
        try
        {
            getElement().click();
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
