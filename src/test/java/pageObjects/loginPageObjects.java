package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObjects {

    public WebDriver driver;


    public loginPageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#txtUsername" )
   private WebElement username;
    @FindBy(css = "#txtPassword" )
    private WebElement pwd;
    @FindBy(css = "#btnLogin" )
    private WebElement sub;

   // private WebElement username=driver.findElement(By.cssSelector("#txtUsername"));
  //  private WebElement pwd=driver.findElement(By.cssSelector("#txtPassword"));
   // private WebElement sub=driver.findElement(By.cssSelector("#btnLogin"));

    public void setUsername(String user) {
        username.clear();
        username.sendKeys(user);
    }
    public void setpwd(String password) {
        pwd.clear();
        pwd.sendKeys(password);
    }

    public void clicksub() {
        sub.click();
    }

}
