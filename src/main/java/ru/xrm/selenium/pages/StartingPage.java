package ru.xrm.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class StartingPage {

    @FindBy(xpath = "//button[normalize-space()='Войти']")
    private WebElement enterButton;
    private WebDriver webDriver;

    public StartingPage ensurePageLoaded() {
        try {
            new WebDriverWait(webDriver, 5).until(visibilityOf(enterButton));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public StartingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickEnterButton(Boolean isToAuthorize) {
        if (isToAuthorize) {
            enterButton.click();
        }
    }

}
