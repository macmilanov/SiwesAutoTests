package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class KeycloakLoginPage {

    private WebDriver webDriver;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;;
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    public KeycloakLoginPage getKeycloakLoginPage()
    {
        return this;
    }

    public KeycloakLoginPage setLoginField(String text)
    {
        loginField.clear();
        loginField.sendKeys(text);
        return this;
    }

    public KeycloakLoginPage setPasswordField(String text)
    {
        passwordField.clear();
        passwordField.sendKeys(text);
        return this;
    }
    public KeycloakLoginPage ensurePageLoaded()
    {
        new WebDriverWait(webDriver, 60).until(presenceOfElementLocated(By.xpath("//div[normalize-space()='Идентификация и аутентификация внутренних систем и пользователей']")));
        return this;
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public KeycloakLoginPage (WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
