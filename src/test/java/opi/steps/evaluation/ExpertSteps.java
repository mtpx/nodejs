package opi.steps.evaluation;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import opi.pages.evaluation.EvaluationAssignReviewerPage;
import opi.pages.evaluation.EvaluationPage;
import opi.pages.evaluation.applicationView.PermissionsPage;
import opi.pages.programs.LoginPage;
import opi.utils.Log;
import opi.utils.PropertiesReader;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class ExpertSteps {
    static String signature;
    EvaluationPage objEvaluationPage = new EvaluationPage();
    LoginPage objLoginPage = new LoginPage();
    PermissionsPage objPermissionsPage = new PermissionsPage();
    Faker faker = new Faker();
    PropertiesReader objPropertiesReader = new PropertiesReader();
    EvaluationAssignReviewerPage objEvaluationAssignReviwerPage = new EvaluationAssignReviewerPage();

    @Given("^UserEmployee finds application with status formal evaluation accepted$")
    public void useremployeeFindsApplicationWithStatusFormalEvaluationAccepted() throws IOException, InterruptedException {
        objPropertiesReader.getProperties();
        Selenide.open(objPropertiesReader.getUrlEvaluation());
        objLoginPage.login(objPropertiesReader.getEmployee(),objPropertiesReader.getPassword());
        objEvaluationPage.selectAllPrograms();
        objEvaluationPage.deselectAllPrograms();
        objEvaluationPage.setProgram(objPropertiesReader.getProgramName());
        objEvaluationPage.selectAllStatuses();
        objEvaluationPage.deselectAllStatuses();
        objEvaluationPage.checkFormalPositiveEvaluation();
        signature = objEvaluationPage.getFirstApplicationSignature();
        objEvaluationPage.checkFirstAvaiableApplication();
        Log.info("signature: "+signature);
        objEvaluationPage.setSignature(signature);
    }

    @When("^UserEmployee adds expert to application$")
    public void userEmpAddsExpertToApplication() throws IOException, InterruptedException {
        objEvaluationPage.clickAssignReviewer();
        objEvaluationAssignReviwerPage.setExpert(objPropertiesReader.getExpertUsername());
    }

    @Then("^UserExpert is added to application$")
    public void userExpIsAddedToApplication() throws IOException, InterruptedException {

    }



    @Given("^UserEmployee is on permissions page of application with added expert$")
    public void userEmpIsOnPermissionsPageOfApplicationWithAddedExpert() throws IOException, InterruptedException {
        objEvaluationPage.selectAllStatuses();
        objEvaluationPage.setSignature(ExpertSteps.signature);
        objEvaluationPage.clickOnFirstAvaiableApplication();
        objPermissionsPage.clickPermissionTab();

    }

    @When("^UserEmployee removes expert from application$")
    public void useremployeeRemovesExpertFromApplication() throws InterruptedException {
       objPermissionsPage.clickDeleteExpert();
       objPermissionsPage.addDeleteNote(faker.lorem().characters(15));
    }

    @Then("^UserExpert was removed from application$")
    public void userexpertWasRemovedFromApplication() {
      /*  Assert.assertEquals("Nie znaleziono żadnej pozycji.", permissionsPage.getTextFromEmptyListReviewer());
        tabsOfViewApplication.backToApplicationsList();
        Assert.assertTrue(evaluationPage.checkStatusApplication("-merit_evaluation"));
        administrationSteps.clickLogout();
        //sprawdza, czy expert nie widzi wniosku po zalogowaniu
        eLoginSteps.login(reader.readingFileUsersProperties().getProperty("MAIL_EXPERT_KOM1"), reader.readingFileUsersProperties().getProperty("PASSWORD_ALL_USERS"));
        evaluationSteps.filterOneApplication(signature, program);
        Assert.assertEquals("Nie znaleziono żadnej pozycji.", evaluationPage.getTextFromEmptyList());*/
      objEvaluationPage.clickLogout();

    }

}
