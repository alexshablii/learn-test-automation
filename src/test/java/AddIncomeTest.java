import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddIncomeTest {
    WebDriver driver;

    @Test
    public void verifySalaryIncomeType() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //Select Chase Checking account
        String accountName = "CHASE CHECKING";
        By account = By.linkText(accountName); //(define locator)
        WebElement checkingAccount = driver.findElement(account); //find element
        checkingAccount.click();

        //Verify correct account info is displayed
        By actualAcc = By.className("account_name"); //define locator
        WebElement actualAccount = driver.findElement(actualAcc);
        String actualAccName = actualAccount.getText();

        Assert.assertEquals(actualAccName, accountName);

        //Select income type (Salary, cashback, interest payment, other) field
        By incomeTypeSelect = By.id("form_income_source"); //define locator
        Select selectSalary = new Select(driver.findElement(incomeTypeSelect));
        selectSalary.selectByVisibleText("Salary");

        //Enter description
        String description = "kForce";
        By descriptionField = By.id("form_description"); //define element
        WebElement desc = driver.findElement(descriptionField);
        desc.sendKeys(description);

        //Enter amount
        String amount = "1000";
        By amountField = By.id("form_amount");
        WebElement amnt = driver.findElement(amountField);
        amnt.sendKeys(amount);

        //Enter year
        String year = "2024";
        By yearField = By.id("form_year");
        WebElement y = driver.findElement(yearField);
        y.clear(); //clear form
        y.sendKeys(year);

        //Select month
        By monthFormSelect = By.id("form_month");
        Select selectMonth = new Select(driver.findElement(monthFormSelect));
        selectMonth.selectByVisibleText("March");

        //Click on Go CTA
        By goCTA = By.xpath("//form[@class='add_income_form']//b"); //define locator
        WebElement proceed = driver.findElement(goCTA);
        proceed.click();

        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        By actualDescriptionLocator = By.xpath("//table//tr[2]//td[2]");
        String actualDescription = driver.findElement(actualDescriptionLocator).getText();
        By actualAmountLocator = By.xpath("//table//tr[2]//td[4]");
        String actualAmount = driver.findElement(actualAmountLocator).getText();

        Assert.assertEquals(actualDescription, description);
        Assert.assertEquals(actualAmount, "$" + amount);

        //Close browser
        driver.quit();

    }

    @Test
    public void verifyCashbackIncomeType()throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //Select Chase Checking account
        String accountName = "CHASE CHECKING";
        By account = By.linkText(accountName); //(define locator)
        WebElement checkingAccount = driver.findElement(account); //find element
        checkingAccount.click();

        //Verify correct account info is displayed
        By actualAcc = By.className("account_name"); //define locator
        WebElement actualAccount = driver.findElement(actualAcc);
        String actualAccName = actualAccount.getText();

        Assert.assertEquals(actualAccName, accountName);

        //Select income type (Salary, cashback, interest payment, other) field
        By incomeTypeSelect = By.id("form_income_source"); //define locator
        Select selectSalary = new Select(driver.findElement(incomeTypeSelect));
        selectSalary.selectByVisibleText("Cashback");

        //Enter description
        String description = "Chase purchases";
        By descriptionField = By.id("form_description"); //define element
        WebElement desc = driver.findElement(descriptionField);
        desc.sendKeys(description);

        //Enter amount
        String amount = "2";
        By amountField = By.id("form_amount");
        WebElement amnt = driver.findElement(amountField);
        amnt.sendKeys(amount);

        //Enter year
        String year = "2024";
        By yearField = By.id("form_year");
        WebElement y = driver.findElement(yearField);
        y.clear(); //clear form
        y.sendKeys(year);

        //Select month
        By monthFormSelect = By.id("form_month");
        Select selectMonth = new Select(driver.findElement(monthFormSelect));
        selectMonth.selectByVisibleText("March");

        //Click on Go CTA
        By goCTA = By.xpath("//form[@class='add_income_form']//b"); //define locator
        WebElement proceed = driver.findElement(goCTA);
        proceed.click();

        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        By actualDescriptionLocator = By.xpath("//table//tr[2]//td[2]");
        String actualDescription = driver.findElement(actualDescriptionLocator).getText();
        By actualAmountLocator = By.xpath("//table//tr[2]//td[4]");
        String actualAmount = driver.findElement(actualAmountLocator).getText();

        Assert.assertEquals(actualDescription, description);
        Assert.assertEquals(actualAmount, "$" + amount);

        //Close browser
        driver.quit();
    }

}
