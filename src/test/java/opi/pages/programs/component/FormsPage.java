package opi.pages.programs.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormsPage {
    private static SelenideElement
            saveDraftBtn = $(By.xpath("(//button[@class='btn ladda-button'])[1]")),
            submitBtn = $(By.xpath("(//button[@class='btn ladda-button'])[2]")),
            pdfBtn = $(By.xpath("//button[text()=' PDF']")),
            backToProgramsListBtn = $(By.xpath("//a[contains(@class, 'icon-angle-left')]")),
            draftPopup = $(By.xpath("//span[@class='ui-growl-title']")),
            confirmationDialogYesBtn = $(By.xpath("//div[contains(@id,'confirmation-dialog≡dialog')]//div[contains(@class,'buttons')]//span[contains(@class,'primary')]"));


    public void saveDraftBtnClick(){
        saveDraftBtn.click();
    }

    public void submitBtnClick(){
        submitBtn.click();
    }

    public void pdfBtnClick(){
        pdfBtn.click();
    }

    public void backToProgramsListBtnClick(){
        backToProgramsListBtn.click();
    }

    public String getTextDraftPopupPl(){
        return draftPopup.getText();
    }

    public void waitForDraftPopup(){
        draftPopup.shouldBe(Condition.visible);
    }

    public void confirmSendApplication(){
        confirmationDialogYesBtn.click();
    }

    public void waitForConfirmationDialog(){
        confirmationDialogYesBtn.shouldBe(Condition.visible);
    }
}
