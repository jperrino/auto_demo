package pageObjects;

import controls.Button;
import controls.Label;
import controls.Link;
import controls.Textbox;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GitHubLoginPage extends BasePageObject {

    public GitHubLoginPage() {
        super(By.xpath(""));
    }

    public Link sign_in_link(){
        try{
            return new Link(By.xpath("//a[@href='/login']"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Textbox username_txtb(){
        try{
            return new Textbox(By.id("login_field"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Textbox password_txtb(){
        try{
            return new Textbox(By.id("password"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Label loginError_lbl(){
        try{
            return new Label(By.id("js-flash-container"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Button sign_in_btn(){
        try{
            return new Button(By.name("commit"));

        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
