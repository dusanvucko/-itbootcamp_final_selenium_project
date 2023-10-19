package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.retryAnalyzer;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retryAnalyzer.class)
    public void setLocaleToES() {

        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnSpanishLanguageInMenuList();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje'.");
    }

    @Test(priority = 2, retryAnalyzer = retryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishLanguageInMenuList();
        Assert.assertEquals(navPage.getHeaderText(), "Landing", "Text in header should be 'Landing'.");
    }

    @Test(priority = 3, retryAnalyzer = retryAnalyzer.class)
    public void setLocaleToCN() {
        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnChineseLanguageInMenuList();
        Assert.assertEquals(navPage.getHeaderText(), "首页", "Text in header should be '首页'.");
    }

    @Test(priority = 4, retryAnalyzer = retryAnalyzer.class)
    public void setLocaleToFR() {
        navPage.clickOnLanguageMenuButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnFrenchLanguageInMenuList();
        Assert.assertEquals(navPage.getHeaderText(), "Page d'atterrissage", "Text in header should be 'Page d'atterrissage'.");
    }


}
