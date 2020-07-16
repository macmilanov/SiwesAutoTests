package ru.xrm.selenium.util;


import ru.xrm.selenium.model.InformationSystem;

import java.util.Random;

public class RandomInformationSystemGenerator {
    public static InformationSystem getRandomInformationSystem() {
        InformationSystem informationSystem = new InformationSystem();
        informationSystem.setInformationSystemName(RandomStringUtil.randomRussianString(5))
                .setInformationSystemToken(RandomStringUtil.randomRussianString(5))
                .setInformationSystemMnemonic(RandomStringUtil.randomNumberString(5))
                .setIsActiveState(new Random().nextBoolean());
        return informationSystem;
    }
}
