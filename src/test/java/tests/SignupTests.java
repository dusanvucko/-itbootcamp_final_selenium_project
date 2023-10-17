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

    @Test(priority = 2, retryAnalyzer = retryAnalyzer.class)
    public void checksInputTypes() throws InterruptedException {
        navPage.clickOnSignUpButton();

        wait
                .until(ExpectedConditions.titleContains("Signup - My Awesome App"));

        signupPage.checkEmailInputType();
        signupPage.checkPasswordInputType();
        signupPage.checkConfirmPassowordInputType();
    }

    }


