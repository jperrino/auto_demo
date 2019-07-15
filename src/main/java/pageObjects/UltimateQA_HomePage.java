package pageObjects;

import controller.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class UltimateQA_HomePage extends BasePageObject {

    public UltimateQA_HomePage() { super(By.xpath("")); }

    public Header home_header(){
        try {
            return new Header(By.id("page-container"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

}
