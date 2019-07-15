import driver.DriverInstanceManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GitHubHomePage;
import pageObjects.GitHubLoginPage;

public class Test2 extends BaseTest {

    private GitHubHomePage gitHubHomePage;
    private GitHubLoginPage gitHubLoginPage;

    public Test2(){
        this.gitHubHomePage = new GitHubHomePage();
        this.gitHubLoginPage = new GitHubLoginPage();
    }

    @BeforeMethod
    public void goHome(){
        DriverInstanceManager.getDriverInstance()
                .navigate()
                .to("https://github.com/");
    }

    @Test(priority = 1)
    public void invalid_login_empty_fields(){
        gitHubLoginPage.sign_in_link().click();
        gitHubLoginPage.sign_in_btn().click();
        Assert.assertTrue(gitHubLoginPage.loginError_lbl().getText().toLowerCase().contains("incorrect username or password"));
    }

    @Test(priority = 2)
    public void invalid_login_empty_username(){
        gitHubLoginPage.sign_in_link().click();
        gitHubLoginPage.password_txtb().sendText("Demo12345");
        gitHubLoginPage.sign_in_btn().click();
        Assert.assertTrue(gitHubLoginPage.loginError_lbl().getText().toLowerCase().contains("incorrect username or password"));
    }

    @Test(priority = 3)
    public void invalid_login_empty_password(){
        gitHubLoginPage.sign_in_link().click();
        gitHubLoginPage.username_txtb().sendText("AutDemo123");
        gitHubLoginPage.sign_in_btn().click();
        Assert.assertTrue(gitHubLoginPage.loginError_lbl().getText().toLowerCase().contains("incorrect username or password"));
    }

    @Test(priority = 4)
    public void successful_login(){
        gitHubLoginPage.sign_in_link().click();
        gitHubLoginPage.username_txtb().sendText("AutDemo123");
        gitHubLoginPage.password_txtb().sendText("Demo12345");
        gitHubLoginPage.sign_in_btn().click();
        gitHubHomePage.profile_btn().click();
        Assert.assertEquals(gitHubHomePage.username_lbl().getText(),"AutDemo123");
    }
}
