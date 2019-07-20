package opi.pages.evaluation;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EvaluationAssignReviewerPage extends BasePage {

    private static SelenideElement
            assignReviewerButton = $(By.xpath("//input[@id='reviewersDialogForm:application-expert-dialog--action-kom-submit']")),
            expertNameInput = $(By.xpath("//input[@id='reviewersDialogForm:filter:filter-autocomplete-experts_input']")),
            expertPanelFirstResult = $(By.xpath("//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all ui-state-highlight']")),
            selectAllExpertsCheckbox = $(By.xpath("//th[contains(@id,'datatableExpertForm:applicationExpert:expert-column--select')]//span[contains(@class,'ui-chkbox-icon ui-icon ui-icon-blank ui-c')]//parent::div")),
            expectedKomSubmitDate = $(By.xpath("//input[@id='reviewersDialogForm:confirmMeritEvaluationActionDate_input']"));
    private static ElementsCollection
            reviewersRows=$$(By.xpath("//tbody[@id='reviewersDialogForm:datatableExpertForm:applicationExpert_data']//tr[@role='row']"));




    //____________________________________________________________________________




    @Step("przydzielanie recenzenta do wniosku")
    public void clickAssignReviewer(){
        assignReviewerButton.click();
    }

    @Step("ustawianie danych recenzenta {0}")
    public void setExpert(String expertName) throws InterruptedException {
        this.expertNameInput.shouldBe(Condition.visible).setValue(expertName);
        expertPanelFirstResult.click();
        reviewersRows.shouldHave(CollectionCondition.size(1));
        selectAllExpertsCheckbox.click();
        selectKomSubmitDate();
        //assignReviewerButton.shouldBe(Condition.enabled).click();
    }

    @Step("wybor oczekiwanego terminu zlozenia KOM")
    public void selectKomSubmitDate(){
        expectedKomSubmitDate.shouldBe(Condition.visible).click();
        expectedKomSubmitDate.pressEnter();
    }
}




