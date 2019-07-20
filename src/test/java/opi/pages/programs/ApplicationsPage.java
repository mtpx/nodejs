package opi.pages.programs;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ApplicationsPage {

    private static SelenideElement
            LukasiewiczBtn = $(By.xpath("//span[(@class='ui-panel-title') and (text()='LUKASIEWICZ')]//parent::div//following-sibling::div//button[@type='submit']")),
            Banach2019Btn = $(By.xpath("//span[(@class='ui-panel-title') and (text()='Banach 2019')]//parent::div//following-sibling::div//button[@type='submit']")),
            APM2Btn = $(By.xpath("//span[(@class='ui-panel-title') and (text()='Akademickie Partnerstwa Międzynarodowe 2')]//parent::div//following-sibling::div //button[@type='submit']")),
            programsTestowyNawa2019_2020Btn = $(By.xpath("//span[(@class='ui-panel-title') and (text()='Program Testowy NAWA-OPI')]//parent::div//following-sibling::div //button[@type='submit']"));

    public void lukasiewiczClick(){
        LukasiewiczBtn.click();
    }

    public void banach2019Click(){
        Banach2019Btn.click();
    }

    public void apm2BtnClick(){
        APM2Btn.click();
    }

    public void programsTestowyNawaBtnClick(){
        programsTestowyNawa2019_2020Btn.click();
    }

}
