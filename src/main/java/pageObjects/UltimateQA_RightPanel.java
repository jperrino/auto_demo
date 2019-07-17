package pageObjects;

import controls.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UltimateQA_RightPanel extends BasePageObject {

    public UltimateQA_RightPanel() { super(By.id("recent-posts-2")); }

    public List<Link> panel_links(){
        try{
            List<Link> links = new ArrayList<>();
            int size = findElementsInside(By.xpath(".//a")).size();
            for(int i=1; i<= size; i++){
                Link l = new Link(By.xpath(".//ul/li["+i+"]/a"));
                links.add(l);
            }
            return links;
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public Link random_link(){
        Random rdm = new Random();

        try{
            return panel_links().get(1);
//                    rdm.nextInt(panel_links().size()));
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

}
