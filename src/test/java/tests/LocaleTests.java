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
}
