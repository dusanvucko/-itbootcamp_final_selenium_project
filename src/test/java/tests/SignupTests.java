package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.retryAnalyzer;

public class SignupTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = retryAnalyzer.class)
    public void visitsTheSignUpPage() throws InterruptedException {

        navPage.clickOnSignUpButton();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/signup");
    }

    }


