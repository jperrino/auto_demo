import driver.DriverInstanceManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.Arrays;
import java.util.List;

public class Test3 extends  BaseTest {

    private UltimateQA_HomePage homePage;
    private UltimateQA_NavBar navBar;
    private UltimateQA_RightPanel rightPanel;
    private UltimateQA_ResultsPage resultsPage;

    public Test3(){
        this.homePage = new UltimateQA_HomePage();
        this.navBar = new UltimateQA_NavBar();
        this.rightPanel = new UltimateQA_RightPanel();
        this.resultsPage = new UltimateQA_ResultsPage();
    }

    @BeforeMethod
    public void goHome(){
        DriverInstanceManager.getDriverInstance()
                .navigate()
                .to("https://www.ultimateqa.com/automation/");
    }

    @Test(priority = 1) //1. Verificar el ribbon
    public void verificar_el_ribbon(){
        boolean flag = false;
        List<String> links = Arrays.asList(
                "video tutorials",
                "resources",
                "automation exercises",
                "blog",
                "work with us");

            if(navBar.menu_link_texts().get(0).equals(links.get(0)) &&
               navBar.menu_link_texts().get(1).contains(links.get(1)) &&
               navBar.menu_link_texts().get(2).equals(links.get(2)) &&
               navBar.menu_link_texts().get(3).equals(links.get(3)) &&
               navBar.menu_link_texts().get(4).equals(links.get(4))
            ){
                flag = true;
            }

        Assert.assertTrue(flag, "Ribbon Menu Link Texts error");
        Assert.assertTrue(navBar.search_btn().isDisplayed(), "Ribbon Search Button error");
        Assert.assertTrue(navBar.main_logo().isDisplayed(), "Ribbon Main Logo error");
    }

    @Test(priority = 2) //2. Verificar que al hacer click en la lupa abre input de search
    public void verificar_search_input(){
        navBar.search_btn().click();
        DriverInstanceManager.wait(1);

        Assert.assertTrue(navBar.search_txtb().isDisplayed());
    }

    @Test(priority = 3) //3. Abrir un post RANDOM del panel derecho y verificar que cambie la URL
    public void abrir_random_post_y_verificar_url() {
        String home_url = DriverInstanceManager
                .getDriverInstance()
                .getCurrentUrl()
                .toLowerCase();

        rightPanel.random_link().click();

        Assert.assertFalse(DriverInstanceManager.getDriverInstance()
                .getCurrentUrl().toLowerCase().equals(home_url));
    }

    @Test(priority = 4) //4. Verificar que scrolleando hacia abajo se agrande el header
    public void verificar_header_size(){
        String header_style = homePage.home_header().getStyle().toLowerCase();

        JavascriptExecutor js = (JavascriptExecutor) DriverInstanceManager.getDriverInstance();
        js.executeScript("window.scrollBy(0,1000)");

        /*
        DriverInstanceManager.getActionInstance()
                    .keyDown(Keys.PAGE_DOWN)
                    .pause(1000)
                    .release();
        */

        Assert.assertFalse(homePage.home_header().getStyle().toLowerCase().equals(header_style));
        js.executeScript("window.scrollBy(0,-1000)");

        /*
        DriverInstanceManager.getActionInstance()
                .keyDown(Keys.PAGE_UP)
                .pause(1000)
                .release();
        */
    }

    @Test(priority = 5) //5. Hacer PO de la página de resultados con una property estilo lista de cada posteo
    public void crear_PO_de_resultados_de_busqueda(){
        navBar.search_btn().click();
        navBar.search_txtb().sendText("selenium");
        navBar.search_txtb().submit();

        System.out.println("Este es el texto del primer article!!!");
        System.out.println(resultsPage.list_articles().get(0).getInnerText());

        Assert.assertTrue(resultsPage.list_articles().size() != 0);
    }

}
