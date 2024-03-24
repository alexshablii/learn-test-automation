package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePageObject {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By accountName = By.className("account_name");
    private By incomeTypeSelect = By.id("form_income_source");
    private By descriptionField = By.id("form_description");
    private By amountField = By.id("form_amount");
    private By yearField = By.id("form_year");
    private By monthFormSelect = By.id("form_month");
    private By goCTA = By.xpath("//form[@class='add_income_form']//b");
    private By addedTransactionDescription = By.xpath("//table//tr[2]//td[2]");
    private By addedTransactionAmount = By.xpath("//table//tr[2]//td[4]");

    //Methods
    public String getAccName() {
        WebElement actualAccount = driver.findElement(accountName);
        return actualAccount.getText();
    }

    public void addIncome(String incomeType, String description, String amount, String year, String month) {
        Select selectSalary = new Select(driver.findElement(incomeTypeSelect));
        selectSalary.selectByVisibleText(incomeType);

        WebElement desc = driver.findElement(descriptionField);
        desc.sendKeys(description);

        WebElement amnt = driver.findElement(amountField);
        amnt.sendKeys(amount);

        WebElement y = driver.findElement(yearField);
        y.clear(); //clear form
        y.sendKeys(year);

        Select selectMonth = new Select(driver.findElement(monthFormSelect));
        selectMonth.selectByVisibleText(month);

        WebElement proceed = driver.findElement(goCTA);
        proceed.click();
    }

    public String getRecentTransactionDescription() {
        return driver.findElement(addedTransactionDescription).getText();
    }

    public String getRecentTransactionAmount() {
        return driver.findElement(addedTransactionAmount).getText();

    }
}
