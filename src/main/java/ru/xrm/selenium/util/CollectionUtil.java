package ru.xrm.selenium.util;

import java.util.Collection;
import java.util.Random;

public class CollectionUtil {
    private static Random random = new Random();

    @SuppressWarnings("unchecked")
    public static <T> T getRandomElement(Collection<T> collection)
    {
        int size = collection.size();
        return (T) collection.toArray()[random.nextInt(size)];
    }

    public static <T> T getRandomElement(T[] array)
    {
        int length = array.length;
        return (T) array[random.nextInt(length)];
    }

    public static <T> String concatenation(Collection<T> collection, CharSequence separator)
    {
        StringBuilder sb = new StringBuilder();
        for (T item : collection)
        {
            sb.append(item.toString());
            sb.append(separator);
        }
        if (sb.length() > 0)
        {
            sb.setLength(sb.length() - separator.length());
        }
        return sb.toString();
    }
}
