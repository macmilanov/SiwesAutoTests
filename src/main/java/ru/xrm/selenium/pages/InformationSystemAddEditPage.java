package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.InformationSystem;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class InformationSystemAddEditPage {
    @FindBy(xpath = "//button[normalize-space()='Сохранить']")
    private WebElement submitButton;

    //Элементы реестра ИС
    @FindBy(xpath = "//label[normalize-space()='Наименование информационной системы']/following-sibling::input[@class='control']")
    private WebElement informationSystemNameField;
    @FindBy(xpath ="//label[normalize-space()='Мнемоника']/following-sibling::input[@class='control']")
    private WebElement informationSystemMnemonicField;
    @FindBy(xpath = "//label[normalize-space()='ИС активна']/preceding-sibling::input[@type='checkbox']")
    private WebElement isActiveState;
    @FindBy(xpath = "//input[@placeholder='Token']")
    private WebElement informationSystemTokenField;

    private WebDriver webDriver;

    public InformationSystemAddEditPage getInformationSystemAddEditPage()
    {
        return this;
    }

    public InformationSystemAddEditPage ensurePageLoaded()
    {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.or(
                visibilityOf(submitButton),
                elementToBeClickable(isActiveState)));
        return this;
    }


    public InformationSystemAddEditPage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public InformationSystemAddEditPage fillInformationSystemCard(InformationSystem informationSystem) {
        fillTextField(informationSystem.InformationSystemName, informationSystemNameField);
        if(!informationSystem.IsActiveState){this.isActiveState.click();}
        fillTextField(informationSystem.InformationSystemMnemonic, informationSystemMnemonicField);
        fillTextField(informationSystem.InformationSystemToken, informationSystemTokenField);
        return this;
    }

    private void fillTextField(String string, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(string);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

}
