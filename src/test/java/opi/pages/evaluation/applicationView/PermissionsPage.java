package opi.pages.evaluation.applicationView;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PermissionsPage extends BaseApplicationViewPage {

    private static SelenideElement
            deleteExpertButton = $(By.xpath("//button[contains(@class,'icon-trash')]")),
            deleteNoteInput = $(By.xpath("//div[contains(@id,'permissionDelete')]//textarea")),
            saveNoteButton = $(By.xpath("//div[contains(@id,'permissionDelete')]//button//span[contains(text(),'Tak') or contains (text(), 'Yes')]"));


    @Step("usuwanie recenzenta")
    public void clickDeleteExpert() throws InterruptedException {
        deleteExpertButton.click();
        Thread.sleep(1000);
    }

    @Step("dodawanie komentarza do usuwania recenzenta")
    public void addDeleteNote(String note) throws InterruptedException {
        deleteNoteInput.clear();
        deleteNoteInput.setValue(note);
        saveNoteButton.click();
    }


}
