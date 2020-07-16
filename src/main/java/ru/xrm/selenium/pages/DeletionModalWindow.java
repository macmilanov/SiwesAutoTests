package ru.xrm.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.xrm.selenium.applogic.ApplicationManager;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DeletionModalWindow {
    private ApplicationManager applicationManager;

    public DeletionModalWindow(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    private WebDriver webDriver;
    @FindBy(xpath = "//button[normalize-space()='Подтвердить']")
    private WebElement confirmButton;
    @FindBy(xpath = "//h2[normalize-space()='Подтверждение действия']")
    private WebElement modalHeader;

    public DeletionModalWindow(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public DeletionModalWindow ensureLoaded() {
        try {
            new WebDriverWait(webDriver, 5).until(visibilityOf(modalHeader));
            return this;
        } catch (TimeoutException e) {
            return this;
        }
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }

    public String checkNameOfObjectToDelete(String expectedName) {
        String noMatch = "No information system name was found";
        String actualModalContent = webDriver.findElement(By.xpath("//h2[normalize-space()='Подтверждение действия']/following-sibling::div")).getText();
        Pattern regExPattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = regExPattern.matcher(actualModalContent);
        return matcher.find() ? matcher.group(1) : noMatch;
    }

}
