package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class InformationSystemAddEditPage {
    @FindBy(xpath = "//button[normalize-space()='Сохранить']")
    private WebElement submitButton;

    //Элементы реестра ИС
    @FindBy(xpath = "//label[normalize-space='ТНаименование информационной системы']/following-sibling::input[@class='control']")
    private WebElement InformationSystemNameField;
    @FindBy(xpath ="//input[@placeholder='Мнемоника']")
    private WebElement InformationSystemMnemonicField;
    @FindBy(xpath = "//label[normalize-space='ИС активна']/preceding-sibling::input[@type='checkbox']")
    private WebElement isActiveState;

    private WebDriver webDriver;

    public InformationSystemAddEditPage getInformationSystemAddEditPage()
    {
        return this;
    }

    public InformationSystemAddEditPage ensurePageLoaded()
    {
        new WebDriverWait(webDriver, 5).until(presenceOfElementLocated(By.xpath("//button[normalize-space()='Сохранить']")));
        return this;                                                                            ///button[normalize-space()='Добавить']
    }

    public InformationSystemAddEditPage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
