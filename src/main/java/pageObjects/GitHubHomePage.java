package pageObjects;

import controller.Button;
import controller.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GitHubHomePage extends BasePageObject {

    public GitHubHomePage() {
        super(By.xpath(""));
    }

    public Button profile_btn(){
        try{
            return new Button(By.xpath("//ul[@id='user-links']/li/details/summary[@class='HeaderNavlink name mt-1']"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Label username_lbl(){
        try{
            return new Label(By.xpath("//ul[@id='user-links']/li/details/details-menu/ul/li/strong"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
