package opi.pages.evaluation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import opi.utils.Log;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EvaluationPage extends BasePage {

    private static SelenideElement
            //programs
            programFilterButton = $(By.xpath("//label[@id='form:filter-selected-program_label']")),
            selectAllProgramsCheckbox = $(By.xpath("//div[@id='form:filter-selected-program_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")),
            deselectAllProgramsCheckbox = $(By.xpath("//div[@id='form:filter-selected-program_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//span[@class='ui-chkbox-icon ui-icon ui-icon-check']")),
            programCheckboxVerification = $(By.xpath("//*[@id='form:filter-selected-program_panel']//child::div[contains(@class, 'ui-helper-clearfix')]//child::div//child::span[contains(@class, 'chkbox-icon')]")),
            programPanel = $(By.xpath("//div[@id='form:filter-selected-program_panel']")),

    //status
    statusFilterButton = $(By.xpath("//label[@id='form:filter-selected-statuses_label']")),
            selectAllStatusesCheckbox = $(By.xpath("//div[@id='form:filter-selected-statuses_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")),
            deselectAllStatusesCheckbox = $(By.xpath("//div[@id='form:filter-selected-statuses_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//span[@class='ui-chkbox-icon ui-icon ui-icon-check']")),
            formalPositiveEvaluationCheckbox = $(By.xpath("//li[@class='ui-selectcheckboxmenu-item ui-selectcheckboxmenu-list-item ui-corner-all ui-selectcheckboxmenu-unchecked']//label[contains(text(),'Ocena formalna - pozytywna')]")),
            statusCheckboxVerification = $(By.xpath("//*[@id='form:filter-selected-statuses_panel']//child::div[contains(@class, 'ui-helper-clearfix')]//child::div//child::span[contains(@class, 'chkbox-icon')]")),
            statusPanel = $(By.xpath("//div[@id='form:filter-selected-statuses_panel']")),
            firstApplicationStatus = $("tbody[id='datatableForm:applicationTable_data'] tr:nth-of-type(1) td:nth-of-type(8) a div span"),

    //inputs
    signatureFilterInput = $(By.xpath("//input[@id='form:filter-specified-signature']")),

    //buttony
    assignReviewerButton = $(By.xpath("//button[@id='datatableForm:application--assign-kom-button']"));

    private static ElementsCollection

            //lista wnioskow

            listOfApplicationsCheckboxes = $$(("tbody[id='datatableForm:applicationTable_data'] tr[role='row'] td:nth-of-type(1)")),
            listOfApplicationSignatures = $$(("tbody[id='datatableForm:applicationTable_data'] tr[role='row'] td:nth-of-type(2)"));


    //____________________________________________________________________________


    @Step("Zaznaczenie wszystkich programow")
    public void selectAllPrograms() {
        do {
            try {
               // if (!programPanel.isDisplayed())
                programPanel.shouldNotBe(Condition.visible);
                programFilterButton.click();
                programPanel.shouldBe(Condition.visible);
                if (programCheckboxVerification.getAttribute("class").contains("blank"))
                    selectAllProgramsCheckbox.shouldBe(Condition.visible).click();
                programFilterButton.click();
                selectAllProgramsCheckbox.shouldNotBe(Condition.visible);
            } catch (Exception e) {
                continue;
            }
        } while (!programFilterButton.getText().contains("*"));


    }

    @Step("odznaczenie wszystkich programow")
    public void deselectAllPrograms() throws InterruptedException {
        do {
            try {
                programPanel.shouldNotBe(Condition.visible);
                programFilterButton.click();
                programPanel.shouldBe(Condition.visible);
                if (programCheckboxVerification.getAttribute("class").contains("check"))
                    deselectAllProgramsCheckbox.click();
                programFilterButton.click();
            } catch (Exception e) {
                continue;
            }
        } while (programFilterButton.getText().contains("("));


    }

    @Step("zaznaczenie wszystkich statusow")
    public void selectAllStatuses() {
        do {
            try {
                statusPanel.shouldNotBe(Condition.visible);
                //if (!statusPanel.isDisplayed())
                statusFilterButton.click();
                statusPanel.shouldBe(Condition.visible);
                if (statusCheckboxVerification.getAttribute("class").contains("blank"))
                    selectAllStatusesCheckbox.shouldBe(Condition.visible).click();
                statusFilterButton.click();
            } catch (Exception e) {
                continue;
            }
        } while (!statusFilterButton.getText().contains("(*)"));

    }

    @Step("odznaczenie wszystkich statusow")
    public void deselectAllStatuses() {
        do {
            try {
                statusPanel.shouldNotBe(Condition.visible);
                statusFilterButton.click();
                statusPanel.shouldBe(Condition.visible);
                if (statusCheckboxVerification.getAttribute("class").contains("check"))
                    deselectAllStatusesCheckbox.click();
                statusFilterButton.click();
            } catch (Exception e) {
                continue;
            }
        } while (statusFilterButton.getText().contains("("));


    }

    @Step("ustawienie programu")
    public void setProgram(String programNameInput) {
        if(!programPanel.isDisplayed()){
            programFilterButton.click();
        }
        $(By.xpath("//li[@class='ui-selectcheckboxmenu-item ui-selectcheckboxmenu-list-item ui-corner-all ui-selectcheckboxmenu-unchecked']//label[contains(text(),'" + programNameInput + "')]")).shouldBe(Condition.visible).click();
    }

    @Step("filtrowanie decyzja formalna - pozytywna")
    public void checkFormalPositiveEvaluation() {
        if (!formalPositiveEvaluationCheckbox.isDisplayed()) {
            statusFilterButton.click();
        }
        formalPositiveEvaluationCheckbox.click();
        statusFilterButton.click();
        firstApplicationStatus.shouldHave(Condition.cssClass("application-formal_evaluation_accept"));
    }

    @Step("pobieranie sygnatury pierwszego wniosku")
    public String getFirstApplicationSignature() {
        return listOfApplicationSignatures.get(0).getText();
    }

    @Step("zaznaczenie pierwszego wniosku na liscie")
    public void checkFirstAvaiableApplication() {
        listOfApplicationsCheckboxes.get(0).click();
    }

    @Step("przydzielanie recenzenta do wniosku")
    public void clickAssignReviewer() {
        assignReviewerButton.click();
    }


    @Step("ustawienie filtra po sygnaturze wniosku {0}")
    public void setSignature(final String signature) {
        signatureFilterInput.setValue(signature).pressEnter();
        Log.info("liczba widocznych aplikacji: " + listOfApplicationsCheckboxes.size());
        listOfApplicationsCheckboxes.get(1).shouldNotBe(Condition.visible);
    }

    public void removeExpertFromApplication() {

    }

    @Step("zwracanie ilosci widocznych wnioskow")
    public int getVisibleApplicationsNumber() {
        Log.info("liczba widocznych aplikacji: " + listOfApplicationSignatures.size());
        return listOfApplicationSignatures.size();
    }

    @Step("zwracanie losowej z widocznych sygnatur")
    public String getFirstSignature() {

        List signatures;
        signatures = listOfApplicationSignatures.texts();
        return signatures.get(0).toString();
    }

    @Step("klikniecie na pierwszy dostepny wniosek")
    public void clickOnFirstAvaiableApplication() {
        listOfApplicationSignatures.get(0).click();
    }

}




