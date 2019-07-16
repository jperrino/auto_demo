package controller;

import driver.DriverInstanceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class Link extends BaseController {

    public Link(By by)
    {
        super(by);
    }

    public Link(By by, DriverInstanceManager driver)
    {
        super(by);
        super.setDriver(driver);
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

    public void retryingFindClick()
    {
        //boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                getElement().click();
                //result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        //return result;
    }

    public void sendEnter()
    {
        try
        {
            getElement().sendKeys(Keys.ENTER);
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
