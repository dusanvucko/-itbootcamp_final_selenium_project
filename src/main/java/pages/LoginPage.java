package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    protected NavPage navPage;
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        navPage = new NavPage(driver, wait);
    }

    }

