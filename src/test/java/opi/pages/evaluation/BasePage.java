package opi.pages.evaluation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private SelenideElement
            loginInput = $(".c-programs > a"),
            mainMenuButton = $(By.xpath("//a[@id='headerForm:mobile-menu-trigger']//em[@class='icon-bars']")),
            documentsButton = $(By.xpath("//a[@class='ui-menuitem-link ui-corner-all mobmenuitem testdocs']")),
            logoutButton = $("a[href*='/logout']");


    @Step("Przejście na stronę logowania")
    public void clickLogin() {
        loginInput.click();
    }

    @Step("Przejscie do menu glownego")
        public void clickMainMenu(){
        mainMenuButton.click();
    }

    @Step("Przejscie do dokumentow")
        public void clickDocuments(){
        documentsButton.shouldBe(Condition.visible).click();
    }

    @Step("wylogowanie")
    public void clickLogout(){
        clickMainMenu();
        logoutButton.shouldBe(Condition.visible).click();
    }

    @Step("start przegladarki")
    public void setUpBrowser(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 7500;
        Configuration.holdBrowserOpen = false;
        Configuration.reportsFolder = "allure-results";
    }



}
