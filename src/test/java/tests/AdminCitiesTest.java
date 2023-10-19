package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.retryAnalyzer;

import java.util.List;
public class AdminCitiesTest extends BasicTest {
    @Test(priority = 1, retryAnalyzer = retryAnalyzer.class)
    public void visitsAdminCitiesPageAndListCities() throws InterruptedException {

        loginPage.autoLogin("admin@admin.com", "12345");

        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
    }

    @Test(priority = 2, retryAnalyzer = retryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
//        loginPage.autoLogin("admin@admin.com", "12345");

        navPage.clickOnAdminButton();
        citiesPage.clickOnCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateEditCityDialogToAppear();

        WebElement cityInputField = citiesPage.getCityInputField();
        Assert.assertEquals(cityInputField.getAttribute("type"), "text");
    }


    @Test(priority = 3, retryAnalyzer = retryAnalyzer.class)
    public void createNewCity() throws InterruptedException {
//        loginPage.autoLogin("admin@admin.com", "12345");
        navPage.clickOnAdminButton();


        citiesPage.clickOnCitiesButton();

        citiesPage.clickOnNewItemButton();

        citiesPage.waitForCreateEditCityDialogToAppear();

        citiesPage.enterCityName("Ledena stena City");

        citiesPage.clickOnSaveButton();

        messagePopUpPage.waitForMessagePopupToBeVisible();

        WebElement cityInputField = citiesPage.getCityInputField();
        Assert.assertEquals(cityInputField.getAttribute("type"), "text");
    }

    @Test(priority = 4, retryAnalyzer = retryAnalyzer.class)
    public void editCity() throws InterruptedException {

        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();


        citiesPage.searchCityName("Ledena Stena City");

        citiesPage.waitForNumberOfRowsInTableToBe(1);

        citiesPage.clickOnEditButtonForFirstRow();

        citiesPage.enterCityName("Nis");

        citiesPage.clickOnSaveButton();

        messagePopUpPage.waitForMessagePopupToBeVisible();

        Assert.assertTrue(citiesPage.getMessagePopupText().contains("Saved successfully"));
    }

    @Test(priority = 5, retryAnalyzer = retryAnalyzer.class)
    public void searchCity() throws InterruptedException {
        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        citiesPage.searchCityName("Ledena Stena City");

        citiesPage.waitForNumberOfRowsInTableToBe(1);

        String actualCityName = citiesPage.getFirstRowName();
        Assert.assertEquals("Ledena Stena City", actualCityName);
    }

    @Test(priority = 6, retryAnalyzer = retryAnalyzer.class)
    public void deleteCity() throws InterruptedException {

        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        citiesPage.searchCityName("Barcelona");

        citiesPage.waitForNumberOfRowsInTableToBe(1);

        String actualCityName = citiesPage.getFirstRowName();
        Assert.assertEquals("Barcelona", actualCityName);

        citiesPage.clickOnDeleteButtonForFirstRow();

        citiesPage.waitForDeleteDialogToBeVisible();

        citiesPage.clickDeleteButtonInDialog();

        messagePopUpPage.waitForMessagePopupToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessagePopupText().contains("Deleted successfully"));
    }
}


