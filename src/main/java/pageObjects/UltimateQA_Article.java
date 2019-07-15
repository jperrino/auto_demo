package pageObjects;

import controller.Label;
import controller.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class UltimateQA_Article extends BasePageObject {

    public UltimateQA_Article(By by) { super(by); }

    public Link article_link(){
        try{
            return new Link(By.xpath("./a"));
        }
        catch(NoSuchElementException e){
            return null;
        }
    }
    public Label article_lbl(){
        try{
            return new Label(By.xpath("./p"));
        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
