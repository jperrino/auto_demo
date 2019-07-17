package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Label extends BaseControl {

    public Label(By by) {
        super(by);
    }

    public String getText(){
        try{
            return getElement().getText();
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

}
