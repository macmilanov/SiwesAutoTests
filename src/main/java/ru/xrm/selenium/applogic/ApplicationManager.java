package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.pages.InformationSystemAddEditPage;
import ru.xrm.selenium.pages.InformationSystemManagementPage;
import ru.xrm.selenium.pages.KeycloakLoginPage;
import ru.xrm.selenium.pages.StartingPage;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;

public class ApplicationManager {
    public WebDriver webDriver;
    public StartingPage startingPage;
    public KeycloakLoginPage keycloakLoginPage;
    public InformationSystemManagementPage informationSystemManagementPage;
    public InformationSystemAddEditPage informationSystemAddEditPage;
    public InformationSystem createdInformationSystem;
    public InformationSystem editedInformationSystem;


    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        startingPage = new StartingPage(webDriver);
        keycloakLoginPage = new KeycloakLoginPage(webDriver);
        informationSystemManagementPage = new InformationSystemManagementPage(webDriver);
        informationSystemAddEditPage = new InformationSystemAddEditPage(webDriver);
        createdInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
        editedInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();

    }
}
