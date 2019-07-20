package opi.pages.evaluation.applicationView;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import opi.pages.evaluation.BasePage;
import static com.codeborne.selenide.Selenide.$;

public class BaseApplicationViewPage extends BasePage {
    private static SelenideElement
            permissionTabButton = $(By.xpath("//a[contains(@href,'permissions')]")),
            backToApplicationsListButton = $(By.xpath("//a[contains(@class,'icon-angle-left like-link')]"));

    @Step("Przejscie do zakladki uprawnienia")
    public void clickPermissionTab(){
        permissionTabButton.click(); }

    public void backToApplicationsList(){
        backToApplicationsListButton.click();
    }

}
