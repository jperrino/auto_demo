package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class UltimateQA_ResultsPage extends BasePageObject {

    public UltimateQA_ResultsPage() { super(By.id("left-area")); }


    public List<UltimateQA_Article> list_articles(){
        try{

            List<UltimateQA_Article> articles = new ArrayList<>();
            int size = this.findElementsInside(By.xpath(".//article")).size();

            for(int i=1; i<= size; i++){
                UltimateQA_Article art = new UltimateQA_Article(By.xpath(".//article["+i+"]"));
                articles.add(art);
            }

            return articles;

        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
