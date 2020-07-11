package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class InformationSystemManagementPage {
    //Общие для всех реестров элементы
    @FindBy(xpath = "//button[normalize-space='Добавить']")
    private WebElement addButton;
    @FindBy(xpath = "//button[normalize-space='Выход']")
    private WebElement exitButton;
    @FindBy(xpath = "//label[normalize-space='Только активные']/preceding-sibling::input[@type='checkbox']")
    private WebElement IsActiveCheckbox;
    @FindBy(xpath = "//button[normalize-space='Найти']")
    private WebElement SearchButton;
    @FindBy(xpath = "//button[normalize-space='Очистить']")
    private WebElement ClearFilterButton;
    //Элементы реестра ИС
    @FindBy(xpath = "//input[@placeholder='Наименование ИС']")
    private WebElement InformationSystemNameField;
    @FindBy(xpath ="//input[@placeholder='Мнемоника']")
    private WebElement InformationSystemMnemonicField;

    private WebDriverWait wait;
    private WebDriver webDriver;

    public InformationSystemManagementPage getInformationSystemManagementPage()
    {
        return this;
    }

    public InformationSystemManagementPage ensurePageLoaded()
    {
        wait.until(presenceOfElementLocated(By.xpath("//h2[normalize-space()='Информационные системы, зарегистрированные в СМЭВ']")));
        return this;
    }

    public InformationSystemManagementPage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
