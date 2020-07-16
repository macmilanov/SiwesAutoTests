package ru.xrm.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.model.InformationSystem;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class InformationSystemAddEditPage extends Page{

    @FindBy(xpath = "//label[normalize-space()='Наименование информационной системы']/following-sibling::input[@class='control']")
    private WebElement informationSystemNameField;
    @FindBy(xpath = "//label[normalize-space()='Мнемоника']/following-sibling::input[@class='control']")
    private WebElement informationSystemMnemonicField;
    @FindBy(xpath = "//label[normalize-space()='ИС активна']/preceding-sibling::input[@type='checkbox']")
    private WebElement isActiveState;
    @FindBy(xpath = "//input[@placeholder='Token']")
    private WebElement informationSystemTokenField;

    public InformationSystemAddEditPage getInformationSystemAddEditPage() {
        return this;
    }

    public InformationSystemAddEditPage ensurePageLoaded(Boolean pageToEdit) {
        try {
            WebElement pageTitle = pageToEdit ? webDriver.findElement(By.xpath("//h2[normalize-space()='Изменение информационной системы, зарегистрированной в СМЭВ']"))
                    : webDriver.findElement(By.xpath("//h2[normalize-space()='Добавление информационной системы, зарегистрированной в СМЭВ']"));
            new WebDriverWait(webDriver, 5).until(ExpectedConditions.or(
                    visibilityOf(pageTitle),
                    visibilityOf(submitButton),
                    elementToBeClickable(isActiveState)));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public InformationSystemAddEditPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public InformationSystemAddEditPage fillInformationSystemCard(InformationSystem informationSystem) {
        fillTextField(informationSystem.InformationSystemName, informationSystemNameField);
        if (informationSystem.IsActiveState) {
            if (!isActiveState.isSelected()) {
                this.isActiveState.click();
            }
        }
        else{
            if(isActiveState.isSelected()){
                this.isActiveState.click();
            }
        }
        fillTextField(informationSystem.InformationSystemMnemonic, informationSystemMnemonicField);
        fillTextField(informationSystem.InformationSystemToken, informationSystemTokenField);
        return this;
    }

    public InformationSystem readInformationSystemCard() {
        return new InformationSystem()
                .setInformationSystemName(informationSystemNameField.getAttribute("value"))
                .setInformationSystemMnemonic(informationSystemMnemonicField.getAttribute("value"))
                .setInformationSystemToken(informationSystemTokenField.getAttribute("value"))
                .setIsActiveState(webDriver.findElement(By.xpath("//label[normalize-space()='ИС активна']/preceding-sibling::input[@type='checkbox']")).isSelected());
    }
}
