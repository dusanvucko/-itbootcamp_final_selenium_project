package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.retryAnalyzer;
public class AuthRoutesTest extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retryAnalyzer.class)
    public void visitsHomePage() throws InterruptedException {

        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
}

