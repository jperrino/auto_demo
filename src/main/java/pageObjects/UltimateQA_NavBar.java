package pageObjects;

import controller.*;
import driver.DriverExtension;
import driver.WebElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UltimateQA_NavBar extends BasePageObject {

    public UltimateQA_NavBar() { super(By.id("top-menu")); }

    ///////////////
    /* OPCION 1 */
    //////////////
    public Iterable<WebElement> op1_menu_links(){
        try{
            return DriverExtension.findElementsWait(this.locator);

        }
        catch(NoSuchElementException e){
            return null;
        }
    }
    ////////////////

    ///////////////
    /* OPCION 2 */
    //////////////
    public List<Link> op2_menu_links(){
        try{

            List<Link> lista = null;

            for (WebElement e : this.getElements()) {
                lista.add((Link) e);
            }

            return lista;

        }
        catch(NoSuchElementException e){
            return null;
        }
    }
    ////////////////

    public List<String> menu_link_texts(){
        List<String> texts = new ArrayList<>();
        try{
            return WebElementExtension.getElementsText(this.getElements());
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Button search_btn(){
        try{
            return new Button(By.id("et_top_search"));
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Image main_logo(){
        try {
            return new Image(By.id("logo"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }

    public Textbox search_txtb(){
        try{
            return new Textbox(By.xpath("//input[@type='search']"));
//            return WebElementExtension.findElementWait(By.xpath("//input[@type='search']"));
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
