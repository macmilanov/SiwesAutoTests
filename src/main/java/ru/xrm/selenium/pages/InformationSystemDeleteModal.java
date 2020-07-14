package ru.xrm.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.applogic.ApplicationManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class InformationSystemDeleteModal {
    private ApplicationManager applicationManager;

    public InformationSystemDeleteModal(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    private WebDriver webDriver;
    @FindBy(xpath = "//button[normalize-space()='Подтвердить']")
    private WebElement confirmButton;
    @FindBy(xpath = "//h2[normalize-space()='Подтверждение действия']")
    private WebElement modalHeader;
    @FindBy(xpath = "//h2[normalize-space()='Подтвердить']/div[contains()='Вы действительно хотите удалить информационную систему']")
    private WebElement modalContent;

    public InformationSystemDeleteModal(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public InformationSystemDeleteModal ensureLoaded() {
        new WebDriverWait(webDriver, 5).until(visibilityOf(modalHeader));
        return this;
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

}
