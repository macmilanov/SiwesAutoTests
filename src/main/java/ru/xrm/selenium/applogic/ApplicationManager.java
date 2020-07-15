package ru.xrm.selenium.applogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.xrm.selenium.model.InformationSystem;
import ru.xrm.selenium.pages.*;
import ru.xrm.selenium.util.PropertyLoader;
import ru.xrm.selenium.util.RandomInformationSystemGenerator;

public class ApplicationManager {
    public WebDriver webDriver;
    public StartingPage startingPage;
    public KeycloakLoginPage keycloakLoginPage;
    public InformationSystemManagementPage informationSystemManagementPage;
    public InformationSystemAddEditPage informationSystemAddEditPage;
    public InformationSystemDeleteModal deleteModal;
    public InformationSystem createdInformationSystem;
    public InformationSystem editedInformationSystem;
    public String baseUrl;
    public static PropertyLoader loader;


    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        loader = new PropertyLoader();
        loader.setActiveProfileProperties(System.getProperty("profile-id"));
        baseUrl = loader.loadProperty("site.url");
        startingPage = new StartingPage(webDriver);
        keycloakLoginPage = new KeycloakLoginPage(webDriver);
        informationSystemManagementPage = new InformationSystemManagementPage(webDriver);
        informationSystemAddEditPage = new InformationSystemAddEditPage(webDriver);
        deleteModal = new InformationSystemDeleteModal(webDriver);
        createdInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
        editedInformationSystem = RandomInformationSystemGenerator.getRandomInformationSystem();
    }

    public void openStaringPage(Boolean isToAutorize){
        if(isToAutorize)
        {
            webDriver.navigate().to(baseUrl);
        } }
}
