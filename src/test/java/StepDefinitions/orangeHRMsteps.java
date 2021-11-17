package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.loginPageObjects;

public class orangeHRMsteps {

    public WebDriver driver;
    public loginPageObjects lpo;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @When("I open orange hrm homepage")
    public void i_open_orange_hrm_homepage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Then("I verify that the logo is present")
    public void i_verify_that_the_logo_is_present() {
        boolean flag=driver.findElement(By.cssSelector("img[src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']")).isDisplayed();
        //Assert.assertTrue(flag);
        Assert.assertTrue(flag);
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }

    @Then("I enter valid {string} and {string}")
    public void i_enter_valid_and(String string, String string2) {

        driver.manage().window().maximize();
        lpo = new loginPageObjects(driver);
        lpo.setUsername(string);
        lpo.setpwd(string2);
    }

    @When("I click submit button")
    public void i_click_submit_button() {
        lpo.clicksub();
    }

    @Then("I login to the application page and Dashboard is visible")
    public void i_login_to_the_application_page_and_dashboard_is_visible() {
        boolean status = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(status);

    }



}
