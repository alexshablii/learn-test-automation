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

public class TransferToSavings {
    WebDriver driver;
    private OfficePage officePage;
    private AccountPage accountPage;

    @Test
    public void verifyTransferToSavings() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/mac/x64/chromedriver");
        driver = new ChromeDriver();

        //Open website
        driver.get("http://localhost/accounting.us/");

        //List test data
        String accountName = "CHASE CHECKING";
        String transferAmount = "100";
        String accountTp= "Chase Savings";
        String transferY = "2024";
        String transferM = "March";

        //Select Chase Checking account
        officePage = new OfficePage(driver);
        officePage.selectAccByName(accountName);

        //Verify correct account info is displayed
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getAccName(), accountName);

        //add amount for transfer and submit
        accountPage.addTransfer(transferAmount, accountTp, transferY, transferM);
        Thread.sleep(2000);

        //Verify transaction data is correctly displayed
        //Assert.assertEquals(accountPage.getRecentTransferDescription(), accountTp);
        Assert.assertEquals(accountPage.getRecentTransferAmount(), "-$" + transferAmount);

        //Close browser
        driver.quit();

    }
}
