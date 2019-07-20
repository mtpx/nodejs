package opi.pages.programs;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


public class BasePage {
    //private static final Logger log = LogManager.getLogger(BasePage.class);
    private SelenideElement login = $(".c-programs > a");


    @Step("Przejście na stronę logowania")
    public void clickLogin() {
        login.click();
    }


}

