package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Header extends BaseController{

    public Header(By by) { super(by); }

    public String getStyle(){
        try{
            return getElement().getAttribute("Style");
        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
