package opi.steps.programs;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import opi.pages.programs.LoginPage;
import opi.utils.PropertiesReader;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class LoginSteps {
    PropertiesReader objPropertiesReader = new PropertiesReader();

    @Given("^user is on login page programs$")
    public void userIsOnLoginPagePrograms() throws IOException {
        objPropertiesReader.getProperties();
        Selenide.open(objPropertiesReader.getUrlPrograms());
    }

    @When("^he enters valid credentials to programs$")
    public void heEntersValidCredentialsToPrograms() throws InterruptedException {
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.login(objPropertiesReader.getUser(),objPropertiesReader.getPassword());
    }

    @Then("^he is logged in programs$")
    public void heIsLoggedInPrograms(){
        System.out.println("logged");
    }

    @When("^he enters invalid credentials to programs$")
    public void heEntersInvalidCredentialsToPrograms() throws InterruptedException {
        LoginPage objLoginPage = new LoginPage();
        objLoginPage.login("invalid","invalid");
    }

    @Then("^he isnt logged in programs$")
    public void heIsntLoggedInPrograms(){
        System.out.println("isnt logged");
    }

}
