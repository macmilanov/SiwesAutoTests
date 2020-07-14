package ru.xrm.selenium.util;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {
    public static String randomRussianString(int length)
    {
        char[] chars = "цукенгшщзхъфывапролджэячсмитьбю".toCharArray();
        return RandomStringUtils.random(length, chars);
    }
    public static String randomNumberString(int length)
    {
        char[] chars = "1234567890".toCharArray();
        return RandomStringUtils.random(length, chars);
    }
}
