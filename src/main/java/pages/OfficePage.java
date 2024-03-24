package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficePage extends BasePageObject {

    public OfficePage(WebDriver driver) {
        super(driver);
    }
    public void selectAccByName (String accName) {
        By account = By.linkText(accName); //(define locator)
        WebElement checkingAccount = driver.findElement(account); //find element
        checkingAccount.click();


    }

}
