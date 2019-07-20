package opi.steps.evaluation;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import opi.pages.evaluation.DocumentsPage;
import opi.pages.evaluation.EvaluationPage;
import opi.pages.programs.LoginPage;
import opi.utils.PropertiesReader;

import static com.codeborne.selenide.Selenide.close;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

public class DocumentsFilteringSteps {
    EvaluationPage objEvaluationPage = new EvaluationPage();
    DocumentsPage objDocumentsPage = new DocumentsPage();
    LoginPage objLoginPage = new LoginPage();
    PropertiesReader objPropertiesReader = new PropertiesReader();


    @Given("^UserEmployee is on documents list$")
    public void useremployeeIsOnDocumentsList() throws IOException, InterruptedException {

        objPropertiesReader.getProperties();
        Selenide.open(objPropertiesReader.getUrlEvaluation());
        objLoginPage.login(objPropertiesReader.getEmployee(), objPropertiesReader.getPassword());
        objDocumentsPage.clickMainMenu();
        objDocumentsPage.clickDocuments();
        objDocumentsPage.selectAllPrograms();
    }

    @When("^UserEmployee filter random document by signature$")
    public void useremployeeFilterRandomDocumentBySignature() {
        objDocumentsPage.setSignature(objPropertiesReader.getExampleDocumentSignature());
    }

    @Then("^documents is filtered$")
    public void documentsIsFiltered() throws InterruptedException {
        assertThat(1,is(equalTo(objDocumentsPage.getVisibleDocumentsSignatures().size())));

        objDocumentsPage.clickLogout();

    }



}