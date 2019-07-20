package opi;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Expert.feature"
)
public class ExpertTest {
    @BeforeClass
    public static void initSettings() throws IOException {
        DOMConfigurator.configure("log4j.xml");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.startMaximized=false;
        Configuration.timeout = 7500;
        Configuration.holdBrowserOpen = false;
        Configuration.reportsFolder = "allure-results";
    }

}
