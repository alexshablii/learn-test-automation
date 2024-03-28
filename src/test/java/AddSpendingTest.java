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

public class AddSpendingTest {
    WebDriver driver;
    private OfficePage officePage;
    private AccountPage accountPage;

    @Test
    public void verifyBillSpendingsAdded() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open Website
        driver.get("http://localhost/accounting.us/");

        //List test data
        String accountName = "CHASE CHECKING";
        String spendingType = "Bills";
        String descrp = "Car";
        String amnt= "500";
        String year = "2024";
        String month = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add spendings and submit
        accountPage.addSpendings(spendingType, descrp, amnt, year, month);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        Assert.assertEquals(accountPage.getRecentSpendingDescription(), descrp);
        Assert.assertEquals(accountPage.getRecentSpendingAmount(), "-$" + amnt);

        //Close browser
        driver.quit();

    }
}
