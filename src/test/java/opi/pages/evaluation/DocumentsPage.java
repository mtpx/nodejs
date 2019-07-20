package opi.pages.evaluation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import opi.utils.Log;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DocumentsPage extends BasePage {

    private static SelenideElement
            signatureFilterInput = $ (By.xpath("//input[@id='form:document-filter-specified-signature']")),
            programFilterButton = $(By.xpath("//label[@id='form:filter-selected-program_label']")),
            selectAllProgramsCheckbox = $(By.xpath("//div[@id='form:filter-selected-program_panel']//div[@class='ui-widget-header ui-corner-all ui-selectcheckboxmenu-header ui-helper-clearfix']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
    private static ElementsCollection
            listOfAvailableDocumentSignatures = $$("tbody[id='documentsForm:documentsTable_data'] tr[role='row'] td:nth-of-type(3)");


    @Step("ustawienie filtra po sygnaturze dokumentu {0}")
    public void setSignature(final String signature){
        signatureFilterInput.setValue(signature).pressEnter();
        Log.info("liczba widocznych aplikacji: "+ listOfAvailableDocumentSignatures.size());
        listOfAvailableDocumentSignatures.get(1).shouldNotBe(Condition.visible);
    }
    public void removeExpertFromApplication(){

    }

    @Step("zwracanie dostepnych sygnatur dokumentow")
    public ElementsCollection getVisibleDocumentsSignatures(){
        return listOfAvailableDocumentSignatures;
    }

    @Step("zwracanie pierwszej sygnatury")
    public String getFirstDocumentSignature(){
        Log.info("widoczne sygnatury dokumentow: "+ listOfAvailableDocumentSignatures.get(0).getText());
        return listOfAvailableDocumentSignatures.get(0).getText();
    }

    @Step("Zaznaczenie wszystkich programow")
    public void selectAllPrograms() throws InterruptedException {
        programFilterButton.click();
        try {
            selectAllProgramsCheckbox.shouldBe(Condition.visible).click();
            listOfAvailableDocumentSignatures.shouldHaveSize(10);
        }catch(Exception e){
            System.out.println("Wszystkie programy sa zaznaczone");
        }
    }


}
