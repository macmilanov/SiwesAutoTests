package ru.xrm.selenium.util;


import ru.xrm.selenium.model.InformationSystem;

import java.util.Random;

public class RandomInformationSystemGenerator {
    private static String[] informationSystemName = new String[]
            {
                    "Администрация города Богданович",
                    "Администрация города Реж",
                    "Администрация города Заречный",
                    "Администрация города Камышлов",
                    "Администрация города Среднеуральск",
                    "Администрация города Сысерть",
                    "Администрация города Нижний Тагил",
                    "Администрация города Качканар",
            };

    private static String[] informationSystemToken = new String[]
            {
                    "DB085175AF684343888344561C2723C1",
                    "DB085175AF684343888344561C2723C2",
                    "DB085175AF684343888344561C2723C3",
                    "DB085175AF684343888344561C2723C4",
                    "DB085175AF684343888344561C2723C5",
                    "DB085175AF684343888344561C2723C6",
                    "DB085175AF684343888344561C2723C7",
                    "DB085175AF684343888344561C2723C8",
                    "DB085175AF684343888344561C2723C9",
                    "DB085175AF684343888344561C2723C0",
            };


    public static InformationSystem getRandomInformationSystem() {
        InformationSystem informationSystem = new InformationSystem();
        informationSystem.setInformationSystemName(CollectionUtil.getRandomElement(informationSystemName))
                .setInformationSystemToken(CollectionUtil.getRandomElement(informationSystemToken))
                .setInformationSystemMnemonic(RandomStringUtil.randomNumberString(5))
                .setIsActiveState(new Random().nextBoolean());
        return informationSystem;
    }
}
