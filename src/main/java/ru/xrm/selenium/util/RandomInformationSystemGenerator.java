package ru.xrm.selenium.util;


import ru.xrm.selenium.model.InformationSystem;

public class RandomInformationSystemGenerator {
    private static String[] informationSystemName = new String[]
            {
                    "Администрация города Богданович",
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
            };

    public static InformationSystem getRandomInformationSystem ()
    {
        String name = CollectionUtil.getRandomElement(informationSystemName);
        String token =  CollectionUtil.getRandomElement(informationSystemToken);
        String mnemonic = RandomStringUtil.randomRussianString(12);
        InformationSystem informationSystem = new InformationSystem();
        informationSystem.setInformationSystemName(name)
                .setInformationSystemToken(token)
                .setInformationSystemMnemonic(mnemonic);

        return informationSystem;
    }
}
