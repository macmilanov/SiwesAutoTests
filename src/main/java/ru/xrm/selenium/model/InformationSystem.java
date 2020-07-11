package ru.xrm.selenium.model;

public class InformationSystem {
    public String InformationSystemName;
    public String InformationSystemToken;
    public String InformationSystemMnemonic;
    public Boolean IsActiveState;

    public String getInformationSystemName()
    {
        return InformationSystemName;
    }
    public String getInformationSystemToken()
    {
        return InformationSystemToken;
    }
    public String getInformationSystemMnemonic()
    {
        return InformationSystemMnemonic;
    }
    public Boolean getIsActiveState()
    {
        return IsActiveState;
    }

    public InformationSystem setInformationSystemName(String informationSystemName)
    {
        this.InformationSystemName = informationSystemName;
        return this;
    }

    public InformationSystem setInformationSystemMnemonic(String informationSystemMnemonic)
    {
        this.InformationSystemMnemonic = InformationSystemMnemonic;
        return this;
    }

    public InformationSystem setInformationSystemToken(String informationSystemToken)
    {
        this.InformationSystemToken = informationSystemToken;
        return this;
    }

}
