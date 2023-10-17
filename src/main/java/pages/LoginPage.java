package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.FileStore;

public class LoginPage extends BasicPage {
    protected NavPage navPage;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        navPage = new NavPage(driver, wait);
    }
    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public void autoLogin(String email, String password) {
            navPage.clickOnLoginButton();
            getEmailInput().sendKeys(email);
            getPasswordInput().sendKeys(password);
            navPage.clickOnLoginButton();
    }
}

