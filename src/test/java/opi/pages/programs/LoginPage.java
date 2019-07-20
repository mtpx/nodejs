package opi.pages.programs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends BasePage {

    private static SelenideElement emailInput = $("#email"),
            passwordInput = $("#password"),
            loginButton = $("#loginButton"),
            createAccountBtn = $(By.xpath("//a[contains(@href,'/programs/register')]//span[contains(@class,'button')]")),
            popupAboutLogin = $(".ui-growl-title");


    @Step("Logowanie za pomoca: user: {0}, pass: {1}")
    public void login(String login, String password) throws InterruptedException {
        $(this.emailInput).clear();
        $(this.passwordInput).clear();
        $(this.emailInput).setValue(login);
        $(this.passwordInput).setValue(password);
        Thread.sleep(200);
        $(this.loginButton).shouldBe(Condition.enabled).click();
    }

    @Step("Pobieranie wiadomosci z bledem logowania")
    public SelenideElement getErrorMessage(){
        return popupAboutLogin;
    }

    @Step("Czekanie na znikniecie komunikatu po logowaniu")
    public void waitForPopupAboutLogin(){
        popupAboutLogin.shouldBe(Condition.disappear);
    }

    @Step("Zwracanie textu z popup")
    public String getTextFromPopup(){
        return popupAboutLogin.getText();
    }

    @Step("Tworzenie konta")
    public void clickCreateBtn() { createAccountBtn.click(); }


}
