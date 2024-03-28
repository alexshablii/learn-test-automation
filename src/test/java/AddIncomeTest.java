import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.OfficePage;


public class AddIncomeTest {
    WebDriver driver;
    private OfficePage officePage;
    private AccountPage accountPage;

    @Test
    public void verifySalaryIncomeType() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //List test data
        String accountName = "CHASE CHECKING";
        String incomeType = "Salary";
        String description = "kForce";
        String amount = "1000";
        String year = "2024";
        String month = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add income and submit
        accountPage.addIncome(incomeType, description, amount, year, month);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        Assert.assertEquals(accountPage.getRecentTransactionDescription(), description);
        Assert.assertEquals(accountPage.getRecentTransactionAmount(), "$" + amount);

        //Close browser
        driver.quit();

    }

    @Test
    public void verifyCashbackIncomeType()throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //Initialize test data
        String accountName = "CHASE CHECKING";
        String incomeType = "Cashback";
        String description = "Chase purchases";
        String amount = "2";
        String year = "2024";
        String month = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add income and submit
        accountPage.addIncome(incomeType, description, amount, year, month);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed

        Assert.assertEquals(accountPage.getRecentTransactionDescription(), description);
        Assert.assertEquals(accountPage.getRecentTransactionAmount(), "$" + amount);

        //Close browser
        driver.quit();
    }

    @Test
    public void verifyInterestPaymentIncomeType() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //List test data
        String accountName = "CHASE CHECKING";
        String incomeType = "Interest Payment";
        String description = "Chase";
        String amount = "200";
        String year = "2024";
        String month = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add income and submit
        accountPage.addIncome(incomeType, description, amount, year, month);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        Assert.assertEquals(accountPage.getRecentTransactionDescription(), description);
        Assert.assertEquals(accountPage.getRecentTransactionAmount(), "$" + amount);

        //Close browser
        driver.quit();

    }

    @Test
    public void verifyOtherIncomeType() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //List test data
        String accountName = "CHASE CHECKING";
        String incomeType = "Other";
        String description = "Taxes";
        String amount = "100";
        String year = "2024";
        String month = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add income and submit
        accountPage.addIncome(incomeType, description, amount, year, month);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        Assert.assertEquals(accountPage.getRecentTransactionDescription(), description);
        Assert.assertEquals(accountPage.getRecentTransactionAmount(), "$" + amount);

        //Close browser
        driver.quit();

        //test

    }

}
