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
    private By recentTransactionDescription = By.xpath("//table//tr[2]//td[2]");
    private By recentIncomeTransactionAmount = By.xpath("//table//tr[2]//td[4]");

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
        return driver.findElement(recentTransactionDescription).getText();
    }

    public String getRecentTransactionAmount() {
        return driver.findElement(recentIncomeTransactionAmount).getText();

    }

    // Create locators for Add Spending Transaction form
    private By spendingTypeSelect = By.id("form_spend_categories");
    private By descrpField = By.xpath("//form[@class='spending_transaction_form']//input[@id='form_description']");
    private By amntField = By.xpath("//form[@class='spending_transaction_form']//input[@id='form_amount']");
    private By yearSpent = By.xpath("//form[@class='spending_transaction_form']//input[@id='form_year']");
    private By monthSpentForm = By.xpath("//form[@class='spending_transaction_form']//select[@id='form_month']");
    private By goButton = By.xpath("//form[@class='spending_transaction_form']//b");
    private By recentSpendingDescription = By.xpath("//table//tr[2]//td[2]");
    private By recentSpendingTransactionAmount = By.xpath("//table//tr[2]//td[3]");

    //Methods
    public void addSpendings(String spendingType, String descrp, String amountF, String year, String month) {
        Select selectSalary = new Select(driver.findElement(spendingTypeSelect));
        selectSalary.selectByVisibleText(spendingType);

        WebElement desc = driver.findElement(descrpField);
        desc.sendKeys(descrp);

        WebElement amnt = driver.findElement(amntField);
        amnt.sendKeys(amountF);

        WebElement y = driver.findElement(yearSpent);
        y.clear(); //clear form
        y.sendKeys(year);

        Select selectMonth = new Select(driver.findElement(monthSpentForm));
        selectMonth.selectByVisibleText(month);

        WebElement proceed = driver.findElement(goButton);
        proceed.click();
    }

    public String getRecentSpendingDescription() {
        return driver.findElement(recentSpendingDescription).getText();
    }

    public String getRecentSpendingAmount() {
        return driver.findElement(recentSpendingTransactionAmount).getText();

    }


    private By amountToTransfer = By.xpath("//form[@class='to_savings_not_affect_form']//input[@id='form_amount']");
    private By accType  = By.xpath("//form[@class='to_savings_not_affect_form']//select[@id='form_account']");
    private By transferYear = By.xpath("//form[@class='to_savings_not_affect_form']//input[@id='form_year']");
    private By transferMonth = By.xpath("//form[@class='to_savings_not_affect_form']//select[@id='form_month']");
    private By proceedCTA = By.xpath("//form[@class='to_savings_not_affect_form']//b");
    private By recentTransferDescription = By.xpath("//table//tr[2]//td[2]");
    private By recentTransferAmount = By.xpath("//table//tr[2]//td[3]");

    //Methods
    public void addTransfer(String transferAmount, String accountTp, String transferY, String transferM) {

        WebElement desc = driver.findElement(amountToTransfer);
        desc.sendKeys(transferAmount);

        Select selectAccount = new Select(driver.findElement(accType));
        selectAccount.selectByVisibleText(accountTp);

        WebElement y = driver.findElement(transferYear);
        y.clear(); //clear form
        y.sendKeys(transferY);

        Select selectMonth = new Select(driver.findElement(transferMonth));
        selectMonth.selectByVisibleText(transferM);

        WebElement proceed = driver.findElement(proceedCTA);
        proceed.click();
    }

    public String getRecentTransferDescription() {
    return driver.findElement(recentTransferDescription).getText();
}

    public String getRecentTransferAmount() {
        return driver.findElement(recentTransferAmount).getText();

}
}

