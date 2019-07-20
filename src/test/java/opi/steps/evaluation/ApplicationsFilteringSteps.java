package opi.steps.evaluation;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import opi.pages.evaluation.BasePage;
import opi.pages.evaluation.EvaluationPage;
import opi.pages.programs.LoginPage;
import opi.utils.PropertiesReader;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.close;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

public class ApplicationsFilteringSteps {
    static String signature;
    EvaluationPage objEvaluationPage = new EvaluationPage();
    LoginPage objLoginPage = new LoginPage();
    PropertiesReader objPropertiesReader = new PropertiesReader();



    @Given("^UserEmployee is on applications list$")
    public void userEmployeeIsOnApplicationsList() throws IOException, InterruptedException {
        objPropertiesReader.getProperties();
        Selenide.open(objPropertiesReader.getUrlEvaluation());
        objLoginPage.login(objPropertiesReader.getEmployee(), objPropertiesReader.getPassword());
        objEvaluationPage.selectAllPrograms();
    }

    @When("^UserEmployee filter random application by signature$")
    public void useremployeeFilterRandomApplicationBySignature() {
        signature = objEvaluationPage.getFirstSignature();
        objEvaluationPage.setSignature(signature);
    }

    @Then("^application is filtered$")
    public void applicationIsFiltered() {
        assertThat(1,equalTo(objEvaluationPage.getVisibleApplicationsNumber()));
        assertThat(signature,equalTo(objEvaluationPage.getFirstSignature()));
        objEvaluationPage.clickLogout();

    }


}
